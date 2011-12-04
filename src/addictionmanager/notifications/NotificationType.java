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
            return "None";
        }
    },
       
    ALERT_ONLY {

        public String toString() {
            return "Alert once";
        }
    },
        
    ALERT_ONE_TIME_AND_CLOSE {

        public String toString() {
            return "Alert one time and close the restricted program";
        }
    },
    
    ALERT_THREE_TIME_AND_CLOSE {

        public String toString() {
            return "Alert three times and close the restricted program";
        }
    },
        
    ALERT_AND_CLOSE_FORCEFULLY {

        public String toString() {
            return "Alert once and close forcefully.";
        }
    }
}
