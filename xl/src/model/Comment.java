package model;

import expr.Environment;

public class Comment implements Slot{
	private String comment;
	
	public Comment(String s) {
		comment = s;
	}

	@Override
	public double getSlotData(Environment e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(Environment e) {
		return comment;
	}

}
