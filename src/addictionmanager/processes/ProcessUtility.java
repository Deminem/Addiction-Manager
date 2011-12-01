/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.processes;

import java.util.List;


/**
 *
 * @author Deminem
 */
public interface ProcessUtility {
    
    public List<SystemProcess> getAllProcessInfo();
    public boolean stopProcess(String pid);
    public String checkProcessStatus(String pid);
    
}
