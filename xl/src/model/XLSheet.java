package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;
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
				error="";
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
    
    public String printSlot(String key) {
    	if (sheet.containsKey(key)) {
    		try {
    			return sheet.get(key).toString();
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
    public void load(HashMap<String, Slot> map) {
    	Map<String, Slot> temp = new HashMap<String, Slot>();
    	temp = sheet;
    	sheet = map;
    	/*
    	Iterator<Entry<String, Slot>> itr = map.entrySet().iterator();
         while (itr.hasNext() ) {
             Entry<String, Slot> entry = itr.next();
             if (checkCircular(entry.getKey(), entry.getValue())) {
                 error= "fel i filen!";
                 sheet = (HashMap<String, Slot>) temp;
                 return;
             }
             
         }
         */
    	error="";
     	setChanged();
     	notifyObservers();
     	
   
    }

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		if (sheet.containsKey(name))
			return sheet.get(name).getSlotData(this);
		else {
			throw new XLException("Denna plats finns ej");
		}
	}
    
    
    private boolean checkCircular(String key, Slot value) {
    	sheet.put(key, new Circular());
    	boolean circular = false;
    	
    	try {
    		value.getSlotData(this);
    		circular = false;
    	}
    	catch (XLException e) {
    		error="fel";
    		circular = true;
    	}
    	catch (StackOverflowError e) {
			error = "fel";
			circular = true;
		}
    	return circular; 
    }
    
    public String error() {
    	return error;
    }
    
}
