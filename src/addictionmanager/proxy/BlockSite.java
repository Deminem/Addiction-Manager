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
    
    private String stieName;
    private Date startTime;
    private Date endtime;

    public BlockSite(String stieName, Date startTime, Date endtime) {
        this.stieName = stieName;
        this.startTime = startTime;
        this.endtime = endtime;
    }
    
    public Date getEndtime() {
        return endtime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStieName() {
        return stieName;
    }
}
