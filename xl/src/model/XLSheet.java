package model;

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
	private String error;

	public XLSheet() {
		sheet = new HashMap<String, Slot>();
		error="";
	}

	public void add(String key, String text) {
			if (sheet.containsKey(key)) {
				remove(key);
			}
			Slot val;
				val = SlotCreator.toSlot(text);
				

			if (!checkCircular(key, val)) {
				sheet.put(key, val);
			}	
			
			else {
				error = "Felaktig inmatning i ruta: "+key;
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
    			return "Fel";
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
    			
    			String key = entry.getKey();
    			String value = entry.getKey();
    			if (checkCircular(key, SlotCreator.toSlot(value))) {
    				error="Kan inte läsa in filen!";
    			}
    			else {
    				temp.put(entry.getKey(), entry.getValue());
    			}
    	}
    	
        sheet = (HashMap<String, Slot>) temp;
     	setChanged();
     	notifyObservers();
    }

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		if (sheet.containsKey(name)) return sheet.get(name).getSlotData(this);
		else {
			throw new XLException("Denna plats finns ej");
		}
	}
    
    
    private boolean checkCircular(String key, Slot value) {
 
    	sheet.put(key, new Circular());
    	try {
    		value.getSlotData(this);
    	}
    	catch (XLException e) {
    		error="fel";
    		return true;
    	}
    	return false;
    }
    public String error() {
    	return error;
    }
    
}
