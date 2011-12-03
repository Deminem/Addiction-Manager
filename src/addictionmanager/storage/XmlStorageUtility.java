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
            TasksResponse tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.CURRENT.toString(), tr);
            }

            filePath = AppConstants.TODAY_TASKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.TODAY.toString(), tr);
            }  
            
            filePath = AppConstants.TOMORROW_TAKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.TOMORROW.toString(), tr);
            }            
            
            filePath = AppConstants.SOMEDAY_TASKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.SOMEDAY.toString(), tr);
            }            
            
            filePath = AppConstants.LOGGED_TASKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.LOGGED.toString(), tr);
            }
            
            filePath = AppConstants.SCHEDULED_TASKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.SCHEDULED.toString(), tr);
            } 
            
            filePath = AppConstants.TRASHED_TASKS_FILE_NAME + ".xml";
            tr = (TasksResponse)xstream.fromXML(getClass().getResource(filePath));
            if (tr != null) {
                mapDirectory.put(TaskType.TRASHED.toString(), tr);
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
            
            String filePath = AppConstants.STORAGE_REPO + taskFileName + ".xml";
            FileOutputStream fs = new FileOutputStream(filePath);
            xstream.toXML(tResponse, fs);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }

    @Override
    public void saveDocument(Task task) {
        
        try {
            String taskFileName = "";
            XStream xstream = new XStream();
            xstream.alias("Tasks", TasksResponse.class);
            xstream.alias("Task", Task.class);
           
            TasksResponse taskResponse = null;
            
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
                List<Task> lst = new ArrayList<Task>();
                lst.add(task);
                
                taskResponse.setTask(lst);
            }
            else {
                taskResponse.getTask().add(task);
            }

            String filePath = AppConstants.STORAGE_REPO + taskFileName;
            FileOutputStream fs = new FileOutputStream(filePath);
            xstream.toXML(taskResponse, fs);
        } 
        catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }
    
    
    private void reshuffleTasksOnLoad() {
        
        TasksResponse current = mapDirectory.get(TaskType.CURRENT.toString());
        TasksResponse today = mapDirectory.get(TaskType.TODAY.toString());
        TasksResponse tomorrow = mapDirectory.get(TaskType.TOMORROW.toString());
        TasksResponse scheduled = mapDirectory.get(TaskType.SCHEDULED.toString());
        TasksResponse someDay = mapDirectory.get(TaskType.SOMEDAY.toString());
        
        for (Task t : today.getTask()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.TODAY.toString()).getTask().remove(t);
                }
            }
        }
        
        //tomorrow enteries
        for (Task t : tomorrow.getTask()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.TOMORROW.toString()).getTask().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getTask().add(t);
                    
                    //remove entry
                     mapDirectory.get(TaskType.TOMORROW.toString()).getTask().remove(t);
                }
            }
        }
        
        
        //schedule enteries
        for (Task t : scheduled.getTask()) {
            if (!DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getTask().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getTask().remove(t);
                }
                else if (DateUtils.isWithinDaysFuture(t.getStartDateTime(), 1)) {
                    t.setTaskType(TaskType.TOMORROW);
                    mapDirectory.get(TaskType.TOMORROW.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SCHEDULED.toString()).getTask().remove(t);
                }
            }
        }
        
        //someday enteries
        for (Task t : someDay.getTask()) {
            if (t.getStartDateTime() != null && !DateUtils.isBeforeDay(new Date(), t.getStartDateTime())) {
                if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                    t.setTaskType(TaskType.CURRENT);
                    mapDirectory.get(TaskType.CURRENT.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getTask().remove(t);
                }
                else if (DateUtils.isToday(t.getStartDateTime())) {
                    t.setTaskType(TaskType.TODAY);
                    mapDirectory.get(TaskType.TODAY.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getTask().remove(t);
                }
                else if (DateUtils.isWithinDaysFuture(t.getStartDateTime(), 1)) {
                    t.setTaskType(TaskType.TOMORROW);
                    mapDirectory.get(TaskType.TOMORROW.toString()).getTask().add(t);
                    
                    //remove entry
                    mapDirectory.get(TaskType.SOMEDAY.toString()).getTask().remove(t);
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
