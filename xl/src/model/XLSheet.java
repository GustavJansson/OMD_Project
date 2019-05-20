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

	}
	

    public void clear() {
        sheet = new HashMap<String, Slot>();
        setChanged();
        notifyObservers();
    }
}
