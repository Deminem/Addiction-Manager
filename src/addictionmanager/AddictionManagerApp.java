/*
 * AddictionManagerApp.java
 */

package addictionmanager;

import addictionmanager.notifications.NotificationType;
import addictionmanager.processes.MacProcessUtility;
import addictionmanager.processes.OSType;
import addictionmanager.processes.ProcessUtility;
import addictionmanager.processes.WindowsProcessUtility;
import addictionmanager.proxy.jProxy;
import addictionmanager.storage.StorageUtility;
import addictionmanager.storage.Task;
import addictionmanager.storage.TaskType;
import addictionmanager.storage.XmlStorageUtility;
import addictionmanager.wizard.WizardView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class AddictionManagerApp extends SingleFrameApplication {

    private static ProcessUtility processUtility;
    private static WizardView wizardViewMngr;
    private static StorageUtility storageUtility;
    private static AddictionManagerView view;
    private static TaskManager taskManager;
    
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        
        String OS = System.getProperty("os.name").toLowerCase();
        System.out.print("OS >> " + OS);
        
        try {
            if (OS != null) {

                //Get the process info
                processUtility = getProcessUtility(OS);
                processUtility.getAllProcessInfo();
                
                //initialize the storage utility
                storageUtility = new XmlStorageUtility();
                storageUtility.loadAllDocuments();
                
                //Check all the previous enteries in today, tomorrow, and schedule.

                List<String> allowedApps = new ArrayList<String>();
                allowedApps.add("facebook");
                allowedApps.add("twitter");
                
                List<String> restrictedpps = new ArrayList<String>();
                restrictedpps.add("test1");
                restrictedpps.add("test2");

                Task t = new Task();
                t.setId(2);
                t.setName("ssss");
                t.setDescription("wasup !!");
                t.setStartDateTime(new Date());
                t.setEndDateTime(new Date());
                t.setNotificationType(NotificationType.ALERT_ONLY);
                t.setTaskType(TaskType.CURRENT);
                t.setAllowedApplications(allowedApps);
                t.setRestrictedApplications(restrictedpps);
                
                //storageUtility.saveDocument(t);
                
                
                view = new AddictionManagerView(this);
                
                //Show the application
                show(view);
            }
        } catch (Exception e) {
        
        }
    }
    
    
    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override 
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of AddictionManagerApp
     */
    public static AddictionManagerApp getApplication() {
        return Application.getInstance(AddictionManagerApp.class);
    }
    
    public AddictionManagerView getApplicationView() {
        return view;
    }
        
    public WizardView getWizardViewManager() {
        return wizardViewMngr;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
        
    public void setWizardViewManager(WizardView wv) {
        this.wizardViewMngr = wv;
    }
    
    public StorageUtility getStorageUtility() {
        return storageUtility;
    }
    
    public ProcessUtility getProcessUtility(String os) throws NoSuchFieldException {
        ProcessUtility utility = null;
        
        if (os.indexOf(OSType.MAC.toString()) >= 0) { 
            utility = new MacProcessUtility();
        }
        else if (os.indexOf(OSType.WINDOWS.toString()) >= 0) {
            utility = new WindowsProcessUtility();
        }
        else if (os.indexOf(OSType.UNIX.toString()) >= 0) {
            utility = new MacProcessUtility();      //TODO make the unix utility
        }
        else {
            throw new NoSuchFieldException();
        }
             
        return utility;
    }
    
    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(AddictionManagerApp.class, args); 
        
        //Start the task manager.
        taskManager = new TaskManager();
        taskManager.startTaskManager();        
    }
    
    
}
