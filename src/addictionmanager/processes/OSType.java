/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.processes;

/**
 *
 * @author Deminem
 */
public enum OSType {

    MAC {

        public String toString() {
            return "Mac OS X";
        }
    },
    
    WINDOWS {

        public String toString() {
            return "windows";
        }
    }
}
