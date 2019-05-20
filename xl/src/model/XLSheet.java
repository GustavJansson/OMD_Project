package model;

import java.util.HashMap;
import java.util.Observable;

import gui.CurrentLabel;



public class XLSheet extends Observable {
	
	private HashMap<String, Slot> sheet = new HashMap<String, Slot>();
	
	CurrentLabel cl;
	
	public XLSheet() {
		
	}
	
	public void modify(String string, Slot slot) {
		sheet.put(string, slot);
		notifyObservers(string);
	}

	

}
