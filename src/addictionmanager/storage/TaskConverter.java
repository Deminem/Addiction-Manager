/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deminem
 */
public class TaskConverter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        
        
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        
        TasksResponse tasks = new TasksResponse();
        List<Task> lst = new ArrayList<Task>();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            Task t = (Task) uc.convertAnother(tasks, Task.class);
            lst.add(t);
            reader.moveUp();
        }
        tasks.setTask(lst);
        return tasks;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(TasksResponse.class);
    }
    
    
}
