package model;

import expr.Environment;

public class Circular implements Slot{

	public Circular() {
		throw new XLException("Circular");
	}

	@Override
	public double getSlotData(Environment e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
