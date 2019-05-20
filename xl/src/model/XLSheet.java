package model;

import java.util.HashMap;

public class XLSheet {
	
	private HashMap<String, Slot> sheet = new HashMap<String, Slot>();
	
	
	public XLSheet() {
		
	}
	
	public void modify(String string, Slot slot) {
		sheet.put(string, slot);
	}

}
