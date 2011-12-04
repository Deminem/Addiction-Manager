/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.proxy;

import java.util.Date;

/**
 *
 * @author Deminem
 */
public class BlockSite {
    
    private String taskName;
    private String stieName;
    private Date startTime;
    private Date endtime;

    public BlockSite(String taskName, String stieName, Date startTime, Date endtime) {
        this.taskName = taskName;
        this.stieName = stieName;
        this.startTime = startTime;
        this.endtime = endtime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStieName() {
        return stieName;
    }

    public void setStieName(String stieName) {
        this.stieName = stieName;
    }
    

}
