/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

import java.util.List;

/**
 *
 * @author Deminem
 */
public class TasksResponse {
    
    private List<Task> Task;

    public TasksResponse() {
     
    }

    public TasksResponse(List<Task> Task) {
        this.Task = Task;
    }

    public List<Task> getTask() {
        return Task;
    }

    public void setTask(List<Task> task) {
        this.Task = task;
    }
}
