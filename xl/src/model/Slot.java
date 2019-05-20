package model;

import expr.Environment;
import expr.ExprParser;

public interface Slot {
	
	public double getSlotData(Environment e);
	public String toString();
	

}
