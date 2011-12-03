/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

import addictionmanager.notifications.NotificationType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Deminem
 */
public class Task {
    
    private int id;
    private String name;
    private String description;
    private Date startDateTime;
    private Date endDateTime;
    private long startDateTimeLong;
    private long endDateTimeLong;
    private List<String> allowedApplications;
    private List<String> restrictedApplications;
    private NotificationType notificationType;
    private TaskType taskType;

    public Task() {}

    public Task(int id, String name, String description, Date startDateTime, Date endDateTime, List<String> allowedApplications, List<String> restrictedApplications, NotificationType notificationType, TaskType taskType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.allowedApplications = allowedApplications;
        this.restrictedApplications = restrictedApplications;
        this.notificationType = notificationType;
        this.taskType = taskType;
    }

    public long getEndDateTimeLong() {
        return endDateTimeLong;
    }

    public void setEndDateTimeLong(long endDateTimeLong) {
        this.endDateTimeLong = endDateTimeLong;
    }

    public long getStartDateTimeLong() {
        return startDateTimeLong;
    }

    public void setStartDateTimeLong(long startDateTimeLong) {
        this.startDateTimeLong = startDateTimeLong;
    }
    
    public List<String> getAllowedApplications() {
        return allowedApplications;
    }

    public void setAllowedApplications(List<String> allowedApplications) {
        this.allowedApplications = allowedApplications;
    }

    public List<String> getRestrictedApplications() {
        return restrictedApplications;
    }

    public void setRestrictedApplications(List<String> restrictedApplications) {
        this.restrictedApplications = restrictedApplications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notiicationType) {
        this.notificationType = notiicationType;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }
    
    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}
