package gui;

import java.awt.Color;
import java.util.*;

public class CurrentSlot extends Observable {

	private SlotLabel current;

	
	public void set(SlotLabel sl) {
		current = sl;
		setChanged();
        notifyObservers();
        addObserver(sl);
	}

	public void reset() {
		current.setBackground(Color.WHITE);
	}
	public String toString() {
		return current.toString();
	}
}
