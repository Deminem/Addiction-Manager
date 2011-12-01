/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author Deminem
 */
public class WizardManager {
    
    private Wizard currentStep;
    private String currentStepName; 
    private List<JPanel> stepsViewList;
    private List<Map<String, Object>> stepsDataList;
    private WizardView wizardView;

    public WizardManager() {
        resetSettings();
        
        stepsViewList = new ArrayList<JPanel>();
        stepsDataList = new ArrayList<Map<String, Object>>();
        wizardView = new WizardView();
    }
    
    public Wizard getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Wizard currentStep) {
        this.currentStep = currentStep;
    }

    public String getCurrentStepName() {
        return currentStepName;
    }

    public void setCurrentStepName(String currentStepName) {
        this.currentStepName = currentStepName;
    }
    
    /*
     * private methods
     */
    private void preLoadSettings() {
        Step1 s1 = new Step1();
        //Step2 s2 = new Step2();
        //Step3 s3 = new Step3();
        
        stepsViewList.add(s1);
        //stepsViewList.add(s2);
        //stepsViewList.add(s3);
    }
    
    private void resetSettings() {
        currentStep = Wizard.NONE;
        currentStepName = null;
    }
    
    
   
    /**
     * At startup create and show the main frame of the wizard.
     */
    public void startWizard() {
        
        if (currentStep == Wizard.NONE) {
            wizardView.loadWizardView();
            
            //wizardView.stepPanel = 
        }
    }
    
    
    private void finishWizard() {
        
        
        
        // reset the settings before getting finished.
        resetSettings();
    }
}
