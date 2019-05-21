package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import expr.Environment;
import gui.CurrentLabel;



public class XLSheet extends Observable implements Environment {

	private HashMap<String, Slot> sheet;
	CurrentLabel cl;

	public XLSheet() {
		sheet = new HashMap<String, Slot>();
	}

	public void modify(String string, Slot slot) {
		sheet.put(string, slot);
		notifyObservers(string);
	}
	public void add(String key, String text) {
		if (text.length()>0){
			if (sheet.containsKey(key)) {
				remove(key);
			}
			Slot val;
				val = SlotCreator.toSlot(text);
			
					if (val != null) {
						sheet.put(key, val);
					}
					else {
//						throw new XLException("Fel inmatning i: "+key);
						JOptionPane.showMessageDialog(null, "Felaktig inmatning i ruta "+key);
					}
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
    		return sheet.get(key).toString();
    	}
    	return "";
    }
    
    public Set<Entry<String, Slot>> toSet() {
    	return sheet.entrySet();
    }
    public void load(Map<String, Slot> map) {
    	sheet.clear();
        sheet = (HashMap<String, Slot>) map;
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
    
    
}
