package gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class CurrentSlot implements Observable {
	
	private String address;
	
	public CurrentSlot(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
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
