/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager;

import addictionmanager.proxy.BlockSite;
import addictionmanager.proxy.jProxy;
import addictionmanager.storage.Task;
import addictionmanager.storage.TaskType;
import addictionmanager.storage.TasksResponse;
import addictionmanager.storage.XmlStorageUtility;
import java.util.Date;
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
        proxyServer = new jProxy(AppConstants.PROXY_SERVER_PORT);
        proxyServer.setDebug(MIN_PRIORITY, System.out);
        proxyServer.start();
        
        this.running = Boolean.TRUE;
    }
    
    public void run () {
        
        AddictionManagerApp app = (AddictionManagerApp)AddictionManagerApp.getApplication();
        XmlStorageUtility storageUtil = (XmlStorageUtility) app.getStorageUtility();
        
        try {
            if(app != null) {
                Thread thisThread = Thread.currentThread();
                while (running) {
                    
                    if (!storageUtil.getDocument(TaskType.CURRENT).getList().isEmpty()) {
                        for (Task t : storageUtil.getDocument(TaskType.CURRENT).getList()) {
                          if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                            
                            //send to the block list
                            for (String site : t.getRestrictedApplications()) {
                                
                                //Add in the bucket
                                proxyServer.addInWatcher(getBlockSite(t, site));
                            }
                          }
                        }
                    }
                    
                    if (!storageUtil.getDocument(TaskType.TODAY).getList().isEmpty()) {
                        for (Task t : storageUtil.getDocument(TaskType.TODAY).getList()) {
                            if (DateUtils.isCurrentDate(t.getStartDateTime())) {
                            
                            //send to the block list
                            for (String site : t.getRestrictedApplications()) {
                                
                                //Add in the bucket
                                proxyServer.addInWatcher(getBlockSite(t, site));
                            }
                          }
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
    
    private BlockSite getBlockSite(Task t, String site) {
        BlockSite blockSite = proxyServer.getBlockSiteFromWacther(site);

        if (blockSite != null && DateUtils.isAfterDay(blockSite.getEndtime(), t.getEndDateTime())) {
            blockSite.setTaskName(t.getName());
            blockSite.setEndtime(t.getEndDateTime());
        } else {
            blockSite = new BlockSite(t.getName(), site, t.getStartDateTime(), t.getEndDateTime());
        }
        
        return blockSite;
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
