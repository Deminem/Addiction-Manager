/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deminem
 */
public class TasksResponse {
    
    private List<Task> list;

    public TasksResponse() {
        list = new ArrayList<Task>();
    }

    public void add(Task t) {
        this.list.add(t);
    }
    
    public List<Task> getList() {
        return this.list;
    }
}
