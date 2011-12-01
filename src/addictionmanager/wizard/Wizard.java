/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.wizard;

/**
 *
 * @author Deminem
 */
public enum Wizard {

    NONE {

        public String toString() {
            return "NONE";
        }
    },
        
    STEP1 {

        public String toString() {
            return "STEP1";
        }
    },
    
    STEP2 {

        public String toString() {
            return "STEP2";
        }
    },
    
    STEP3 {

        public String toString() {
            return "STEP3";
        }
    }
}
