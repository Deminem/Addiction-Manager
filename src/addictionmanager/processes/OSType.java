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

    NONE {

        public String toString() {
            return "NONE";
        }
    },
        
    MAC {

        public String toString() {
            return "mac";
        }
    },
    
    WINDOWS {

        public String toString() {
            return "win";
        }
    },
    
    UNIX {

        public String toString() {
            return "nix";
        }
    }
}
