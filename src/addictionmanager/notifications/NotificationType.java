/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.notifications;

/**
 *
 * @author Deminem
 */
public enum NotificationType {
    
    NONE {

        public String toString() {
            return "NONE";
        }
    },
       
    ALERT_ONLY {

        public String toString() {
            return "ALERT_ONLY";
        }
    },
        
    ALERT_ONE_TIME_AND_CLOSE {

        public String toString() {
            return "ALERT_ONE_TIME_AND_CLOSE";
        }
    },
    
    ALERT_THREE_TIME_AND_CLOSE {

        public String toString() {
            return "ALERT_THREE_TIME_AND_CLOSE";
        }
    },
        
    ALERT_AND_CLOSE_FORCEFULLY {

        public String toString() {
            return "ALERT_AND_CLOSE_FORCEFULLY";
        }
    }
}
