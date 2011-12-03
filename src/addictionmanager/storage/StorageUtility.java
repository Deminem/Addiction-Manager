/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

/**
 *
 * @author Deminem
 */
public interface StorageUtility {
    
    public void loadAllDocuments();
    public boolean isDocumentExists();
    public TasksResponse getDocument(TaskType type);
    public void saveDocument(Task task);
}
