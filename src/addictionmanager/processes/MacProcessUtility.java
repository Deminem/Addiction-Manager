/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addictionmanager.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deminem
 */
public class MacProcessUtility implements ProcessUtility {

    public MacProcessUtility() {
    
    }
    
    @Override
    public List<SystemProcess> getAllProcessInfo() {
               Process p;
        Runtime runTime;
        String process = null;
        List<SystemProcess> processList = null;

        try {
            processList = new ArrayList<SystemProcess>();
            System.out.println("Processes Reading is started...");
            
            //Get Runtime environment of System
            runTime = Runtime.getRuntime();

            //Execute command thru Runtime
            //p = runTime.exec("tasklist");      // For Windows
            p= runTime.exec("ps ux");              //For Linux


            //Create Inputstream for Read Processes
            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            //Read the processes from sysrtem and add & as delimeter for tokenize the output
            String line = bufferedReader.readLine();
            process = "&";
            while (line != null) {
                line = bufferedReader.readLine();
            System.out.println("Process data: " + line);
                process += line + "&";
            }

            
            
            //Close the Streams
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            
            System.out.println("Processes are read.");
 
        }
        catch (IOException e) {
            System.out.println("Exception arise during the read process");
        }
   
        return processList;
    }

    @Override
    public boolean stopProcess(String pid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String checkProcessStatus(String pid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
