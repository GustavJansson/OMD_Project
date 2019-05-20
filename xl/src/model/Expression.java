package model;

import java.io.IOException;

import expr.*;

public class Expression implements Slot{
	
	private Expr expr;
	
	public Expression(String s) {
		ExprParser parser = new ExprParser();
		try {
			expr = parser.build(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getSlotData() {
		// TODO Auto-generated method stub
		return expr.toString();
	}

	@Override
	public void setSlotData(String s) {
       ExprParser parser = new ExprParser();
        try {
			expr = parser.build(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
