package gui;

import java.awt.Color;
import java.util.*;

public class CurrentSlot extends Observable {

	private SlotLabel sl;

	public CurrentSlot(SlotLabel sl) {
		this.sl = sl;
		setChanged();
		notifyObservers();
        addObserver(sl);
	}

	public String toString() {
		return sl.toString();
	}
	
	public void reset() {
		sl.setBackground(Color.WHITE);
	}

}
