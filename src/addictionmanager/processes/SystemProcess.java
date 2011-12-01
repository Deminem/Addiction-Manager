/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.processes;

import java.util.Date;

/**
 *
 * @author Deminem
 */
public class SystemProcess {
 
    private String pid;
    private String name;
    private String description;
    private Date startDateAndTime;

    public SystemProcess(String pid, String name, String description, Date startDateAndTime) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        this.startDateAndTime = startDateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPid() {
        return pid;
    }

    public Date getStartDateAndTime() {
        return startDateAndTime;
    }      
}
