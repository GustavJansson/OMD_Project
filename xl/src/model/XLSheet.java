package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import expr.Environment;

public class XLSheet extends Observable implements Environment {

	private HashMap<String, Slot> sheet;

	public XLSheet() {
		sheet = new HashMap<String, Slot>();
	}

	public void add(String key, String text) {
			if (sheet.containsKey(key)) {
				remove(key);
			}
				
				try {
					Slot val;
					try {
						val = SlotCreator.toSlot(text);
					}
					catch (XLException e) {
						throw e;
					}
					checkCircular(key, val);
					sheet.put(key, val);
				}
				catch (XLException e) {
					throw e;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		setChanged();
		notifyObservers();
	}
	
	public void remove(String key) {
		sheet.remove(key);
	}
	

    public void clear() {
        sheet = new HashMap<String, Slot>();
        setChanged();
        notifyObservers();
    }
    
    public String print(String key) {
    	if (sheet.containsKey(key)) {
    		try {
    			return sheet.get(key).calc(this);
    		}
    		catch(XLException e) {
    			throw e;
    		}
    	}
    	return "";
    }
    
    public Set<Entry<String, Slot>> toSet() {
    	return sheet.entrySet();
    }
    public void load(Map<String, Slot> map) {
    	Map<String, Slot> temp = new HashMap<String, Slot>();
    	
    	for (Entry<String, Slot> entry : map.entrySet()) {
    			temp.put(entry.getKey(), entry.getValue());
    	}
    	
        sheet = (HashMap<String, Slot>) temp;
     	setChanged();
     	notifyObservers();
    }

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		if (!sheet.containsKey(name)) {
            throw new XLException(name + " saknar värde");
        }
        return sheet.get(name).getSlotData(this);
	}
    
    
    private boolean checkCircular(String key, Slot value) {
 
    	sheet.put(key, new Circular());
    	try {
    		value.getSlotData(this);
    	}
    	catch (XLException e) {
    		throw e;
    	}

    	return false;
    }
    
}
