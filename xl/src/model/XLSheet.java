package model;

import java.util.HashMap;
import java.util.Observable;



public class XLSheet extends Observable {
	
	private HashMap<String, Slot> sheet = new HashMap<String, Slot>();
	
	
	public XLSheet() {
		
	}
	
	public void modify(String string, Slot slot) {
		sheet.put(string, slot);
	}


}
