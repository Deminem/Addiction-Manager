/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.storage;

/**
 *
 * @author Deminem
 */
public enum TaskType {
 
    NONE {

        public String toString() {
            return "NONE";
        }
    },
        
    CURRENT {

        public String toString() {
            return "CURRENT";
        }
    },
    
    TODAY {

        public String toString() {
            return "TODAY";
        }
    },
    
    TOMORROW {

        public String toString() {
            return "TOMORROW";
        }
    },
    
    SOMEDAY {

        public String toString() {
            return "SOMEDAY";
        }
    },
    
    SCHEDULED {

        public String toString() {
            return "SCHEDULED";
        }
    },
    
    LOGGED {

        public String toString() {
            return "LOGGED";
        }
    },
    
    TRASHED {

        public String toString() {
            return "TRASHED";
        }
    }
}
