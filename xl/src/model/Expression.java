package model;

import expr.Expr;

public class Expression implements Slot{
	
	private Expr expr;

	@Override
	public String getSlotData() {
		// TODO Auto-generated method stub
		return expr.toString();
	}

	@Override
	public void setSlotData(String s) {
		// TODO Auto-generated method stub
		
	}

}
