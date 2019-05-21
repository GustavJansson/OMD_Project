package model;

import expr.Environment;

public class Circular implements Slot{

	public Circular() {
	//	throw new XLException("Circular");
	}

	@Override
	public double getSlotData(Environment e) {
		throw new XLException("Circular");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		throw new XLException("Ruta saknar värde");
	}

	@Override
	public String calc(Environment e) {
		// TODO Auto-generated method stub
		throw new XLException("Ruta saknar värde");
	}
	


}
