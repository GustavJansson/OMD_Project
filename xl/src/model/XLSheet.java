package model;

import java.util.HashMap;
import java.util.Observable;

import javax.swing.JOptionPane;

import gui.CurrentLabel;



public class XLSheet extends Observable {

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
			if (text.charAt(0)=='#') {
				String value = text.substring(1);
				val = new Comment(value);
			}
			else {
				val = SlotCreator.toSlot(text);
			}
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
}
