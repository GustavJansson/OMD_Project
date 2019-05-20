package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                // TODO
                
                String key = string.substring(0, i-1);
                Slot value = null;
                value.setSlotData(string.substring(i+1,string.length()-1));
                map.put(key, value);
              
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}


