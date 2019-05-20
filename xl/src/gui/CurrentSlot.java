package gui;

import java.util.*;

public class CurrentSlot extends Observable {

	private String address;

	public CurrentSlot(String address) {
		this.address = address;

	}

	public String getAddress() {
		return address;
	}




}
