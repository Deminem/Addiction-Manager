/*
 * AddictionManagerApp.java
 */

package addictionmanager;

import addictionmanager.processes.MacProcessUtility;
import addictionmanager.processes.OSType;
import addictionmanager.processes.ProcessUtility;
import addictionmanager.processes.WindowsProcessUtility;
import addictionmanager.wizard.WizardManager;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class AddictionManagerApp extends SingleFrameApplication {

    private ProcessUtility processUtility;
    private WizardManager wizardMngr;
    
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        
        String OS = System.getProperty("os.name");
        System.out.print("OS >> " + OS);
        
        try {
            if (OS != null) {
                //Get the process info
                processUtility = getProcessUtility(OS);
                processUtility.getAllProcessInfo();
                
                //initialize the wizard stuff.
                wizardMngr = new WizardManager();
            
                
                //Show the application
                show(new AddictionManagerView(this));
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
    
    public WizardManager getWizardManager() {
        return this.wizardMngr;
    }
    
    public ProcessUtility getProcessUtility(String os) throws NoSuchFieldException {
        ProcessUtility utility = null;
        
        if (os.equalsIgnoreCase(OSType.MAC.toString())) { 
            utility = new MacProcessUtility();
        }
        else if (os.equalsIgnoreCase(OSType.WINDOWS.toString())) {
            utility = new WindowsProcessUtility();
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
    }
    
    
}
