/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import addictionmanager.AppConstants;
import addictionmanager.DateUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Deminem
 */
public class XmlStorageUtility implements StorageUtility {

    private Map<String, TasksResponse> mapDirectory;
    
    public XmlStorageUtility() {
        mapDirectory = new HashMap<String, TasksResponse>();
    }
    
    @Override
    public boolean isDocumentExists() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public TasksResponse getDocument(TaskType type) {
        
        if (!mapDirectory.isEmpty()) {
            return mapDirectory.get(type.toString());
        }
        
        return null;
    }   
    
    public void loadAllDocuments() {
        
        XStream xstream = new XStream();
        xstream.alias("Tasks", TasksResponse.class);
        xstream.registerConverter(new TaskConverter());
        xstream.alias("task", Task.class);
       
        try {
            String filePath = AppConstants.CURRENT_TASKS_FILE_NAME + ".xml";
            TasksResponse current = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (current != null) {
                mapDirectory.put(TaskType.CURRENT.toString(), current);
            }

            filePath = AppConstants.TODAY_TASKS_FILE_NAME + ".xml";
            TasksResponse today = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (today != null) {
                mapDirectory.put(TaskType.TODAY.toString(), today);
            }  
            
            filePath = AppConstants.TOMORROW_TAKS_FILE_NAME + ".xml";
            TasksResponse tomorrow = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tomorrow != null) {
                mapDirectory.put(TaskType.TOMORROW.toString(), tomorrow);
            }            
            
            filePath = AppConstants.SOMEDAY_TASKS_FILE_NAME + ".xml";
            TasksResponse someday = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (someday != null) {
                mapDirectory.put(TaskType.SOMEDAY.toString(), someday);
            }            
            
            filePath = AppConstants.LOGGED_TASKS_FILE_NAME + ".xml";
            TasksResponse logged = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (logged != null) {
                mapDirectory.put(TaskType.LOGGED.toString(), logged);
            }
            
            filePath = AppConstants.SCHEDULED_TASKS_FILE_NAME + ".xml";
            TasksResponse scheduled = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (scheduled != null) {
                mapDirectory.put(TaskType.SCHEDULED.toString(), scheduled);
            } 
            
            filePath = AppConstants.TRASHED_TASKS_FILE_NAME + ".xml";
            TasksResponse trashed = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (trashed != null) {
                mapDirectory.put(TaskType.TRASHED.toString(), trashed);
            } 
            
            System.out.println("mapDirectory : " + mapDirectory);
        } 
        catch (Exception e) {
            System.out.println("loadAllDocuments Exception : " + e.toString());
        }
         

    }
    
    public void saveAllTaskDocument(TasksResponse tResponse, String taskFileName) {
        
        try {
            XStream xstream = new XStream();
            xstream.alias("Tasks", TasksResponse.class);
            xstream.alias("task", Task.class);
            xstream.addImplicitCollection(TasksResponse.class, "list");
            
            String filePath = AppConstants.STORAGE_REPO + taskFileName + ".xml";
            FileOutputStream fs = new FileOutputStream(filePath);
            xstream.toXML(tResponse, fs);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }

    public TasksResponse saveDocument(Task task) {
        
        TasksResponse taskResponse = null;
         
        try {
            String taskFileName = "";
            XStream xstream = new XStream();
            xstream.alias("Tasks", TasksResponse.class);
            xstream.alias("task", Task.class);
            xstream.addImplicitCollection(TasksResponse.class, "list");
            
            if (task.getTaskType() == TaskType.CURRENT) {
                taskFileName = AppConstants.CURRENT_TASKS_FILE_NAME + ".xml";
                taskResponse = mapDirectory.get(TaskType.CURRENT.toString());          
            }
            else if (task.getTaskType() == TaskType.LOGGED) {
                taskFileName = AppConstants.LOGGED_TASKS_FILE_NAME + ".xml";
                taskResponse = mapDirectory.get(TaskType.LOGGED);  
            }
            else if (task.getTaskType() == TaskType.SCHEDULED) {
                taskFileName = AppConstants.SCHEDULED_TASKS_FILE_NAME + ".xml";
                taskResponse = mapDirectory.get(TaskType.SCHEDULED);  
            }
            else if (task.getTaskType() == TaskType.TOMORROW) {
                taskFileName = AppConstants.TOMORROW_TAKS_FILE_NAME + ".xml";
                taskResponse = mapDirectory.get(TaskType.TOMORROW);  
            }
            else if (task.getTaskType() == TaskType.TRASHED) {
                taskFileName = AppConstants.TRASHED_TASKS_FILE_NAME + ".xml";
                taskResponse = mapDirectory.get(TaskType.TRASHED);  
            }
            
            
            if (taskResponse == null) {
                taskResponse = new TasksResponse();
                taskResponse.add(task);
            }
            else {
                taskResponse.add(task);
            }

            String filePath = AppConstants.STORAGE_REPO + taskFileName;
            FileOutputStream fs = new FileOutputStream(filePath);
            xstream.toXML(taskResponse, fs);
        } 
        catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        
        return taskResponse;
    }
    
    
    private void reshuffleTasksOnLoad() {
        
        TasksResponse current = mapDirectory.get(TaskType.CURRENT.toString());
        TasksResponse today = mapDirectory.get(TaskType.TODAY.toString());
        TasksResponse tomorrow = mapDirectory.get(TaskType.TOMORROW.toString());
        TasksResponse scheduled = mapDirectory.get(TaskType.SCHEDULED.toString());
        TasksResponse someDay = mapDirectory.get(TaskType.SOMEDAY.toString());
        
        for (Task t : today.getList()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.TODAY.toString()).getList().remove(t);
                }
            }
        }
        
        //tomorrow enteries
        for (Task t : tomorrow.getList()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.TOMORROW.toString()).getList().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getList().add(t);
                    
                    //remove entry
                     mapDirectory.get(TaskType.TOMORROW.toString()).getList().remove(t);
                }
            }
        }
        
        
        //schedule enteries
        for (Task t : scheduled.getList()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getList().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getList().remove(t);
                }
                else if (DateUtils.isWithinDaysFuture(t.getStartDateTime(), 1)) {
                    t.setTaskType(TaskType.TOMORROW);
                    mapDirectory.get(TaskType.TOMORROW.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getList().remove(t);
                }
            }
        }
        
        //someday enteries
        for (Task t : someDay.getList()) {
            if (t.getStartDateTime() != null && !DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getList().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getList().remove(t);
                }
                else if (DateUtils.isWithinDaysFuture(t.getStartDateTime(), 1)) {
                    t.setTaskType(TaskType.TOMORROW);
                    mapDirectory.get(TaskType.TOMORROW.toString()).getList().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getList().remove(t);
                }
            }
        }
        
        
        //resave all the documents.
        saveAllTaskDocument(mapDirectory.get(TaskType.CURRENT.toString()), TaskType.CURRENT.toString());
        saveAllTaskDocument(mapDirectory.get(TaskType.TODAY.toString()), TaskType.TODAY.toString());
        saveAllTaskDocument(mapDirectory.get(TaskType.TOMORROW.toString()), TaskType.TOMORROW.toString());
        saveAllTaskDocument(mapDirectory.get(TaskType.SCHEDULED.toString()), TaskType.SCHEDULED.toString());
        saveAllTaskDocument(mapDirectory.get(TaskType.SOMEDAY.toString()), TaskType.SOMEDAY.toString());
    }
}
