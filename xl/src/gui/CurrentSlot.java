package gui;

import java.util.*;

public class CurrentSlot extends Observable {

	private String address;
	private CurrentLabel cl;

	public CurrentSlot(String address) {
		this.address = address;
		this.addObserver(cl);
		this.notifyObservers(address);

	public CurrentSlot(String address) {
		this.address = address;

	}

	public void reset() {
		sl.setBackground(Color.WHITE);
	}
}
