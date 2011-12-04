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

public class BlackList {
    static Map<String, BlockSite> blacklist = Collections.synchronizedMap(new HashMap<String, BlockSite>());
    
    public BlackList(ArrayList<BlockSite> sites){
        for(BlockSite x: sites){
            if(!blacklist.containsKey(x))
            blacklist.put(x.getStieName(), x);
        }
    }
    
    public static synchronized void remove(String site){
        blacklist.remove(site);
    }
    
    public static synchronized void add(BlockSite site){
        if (!blacklist.containsKey(site.getStieName()))
            blacklist.put(site.getStieName(), site);
    }

}
