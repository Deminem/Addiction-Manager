package addictionmanager.proxy;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hnocleland
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BlackList{
    static Map blacklist = Collections.synchronizedMap(new HashMap<String, String>());
    
    public BlackList(ArrayList<String> sites){
        for(String x: sites){
            if(!blacklist.containsKey(x))
            blacklist.put(x, "");
        }
    }
    
    public static synchronized void remove(String site){
        blacklist.remove(site);
    }
    
    public static synchronized void add(String site){
        if (!blacklist.containsKey(site))
            blacklist.put(site, "");
    }

}
