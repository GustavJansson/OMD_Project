package gui;

import java.awt.Color;
import java.util.*;

public class CurrentSlot extends Observable {

	private String address;
	private CurrentLabel cl;
	private SlotLabel sl;

	public CurrentSlot(String address) {
		this.address = address;
		this.addObserver(cl);
		this.notifyObservers(this);
		
	}
	
	public CurrentSlot(SlotLabel sl) {
		this.sl = sl;
	}

	public void reset() {
		sl.setBackground(Color.WHITE);
	}
}
