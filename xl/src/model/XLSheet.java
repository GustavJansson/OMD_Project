package model;

import java.util.HashMap;
import java.util.Observable;

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
				val = new Expression(text);
			}
				sheet.put(key, val);
		}
	}
	private void remove(String key) {
		sheet.remove(key);
	}

    public void clear() {
        sheet = new HashMap<String, Slot>();
        setChanged();
        notifyObservers();
    }
}
