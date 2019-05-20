package model;

import java.util.HashMap;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class XLSheet implements Observable {
	
	private HashMap<String, Slot> sheet = new HashMap<String, Slot>();
	
	
	public XLSheet() {
		
	}
	
	public void modify(String string, Slot slot) {
		sheet.put(string, slot);
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

}
