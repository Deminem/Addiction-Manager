/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager;

import addictionmanager.proxy.jProxy;
import addictionmanager.storage.Task;
import addictionmanager.storage.TaskType;
import addictionmanager.storage.TasksResponse;
import addictionmanager.storage.XmlStorageUtility;
import java.util.Map;

/**
 *
 * @author Deminem
 */
public class TaskManager extends Thread {
    
    private static jProxy proxyServer;
    private boolean running = false;
    private int checkingInterval = 10 * 1000;   //10 secs
    
    public TaskManager() {
        //proxyServer = new jProxy(AppConstants.PROXY_SERVER_PORT);
        //proxyServer.setDebug(MIN_PRIORITY, System.out);
        //proxyServer.start();
        
        this.running = Boolean.TRUE;
    }
    
    public void run () {
        
        AddictionManagerApp app = (AddictionManagerApp)AddictionManagerApp.getApplication();
        XmlStorageUtility storageUtil = (XmlStorageUtility) app.getStorageUtility();
        
        try {
            if(app != null) {
                Thread thisThread = Thread.currentThread();
                while (running) {
                    
                    for (Task t : storageUtil.getDocument(TaskType.CURRENT).getList()) {
                        if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                            
                            //send to the monitor list
                        }
                    }
                    
                    for (Task t : storageUtil.getDocument(TaskType.TODAY).getList()) {
                        if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                            
                            //send to the monitor list
                        }
                    }
                    

                    Thread.sleep(checkingInterval);
                }
            }
        } 
        catch (InterruptedException e) {
             System.out.println("Error in ProxyThread: " + e);
        }
    }
    
    public void startTaskManager() {
        this.start();
    }
    
    public void stopTaskManager() {
        running = false;
    }
    
    public static void main(String args[]) {
        TaskManager t = new TaskManager();
        t.start();
    }
}
