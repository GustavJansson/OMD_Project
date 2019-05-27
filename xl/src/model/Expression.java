package model;

import java.io.IOException;

import expr.*;

public class Expression implements Slot{
	
	private Expr expr;
	
	public Expression(Expr expr) {
		this.expr = expr;
	}
	/*
	public Expression(String expr) throws IOException {
		ExprParser parser = new ExprParser();
		this.expr = parser.build(expr);
	}
	*/

	@Override
	public double getSlotData(Environment e) {
		// TODO Auto-generated method stub
		try {
			return expr.value(e);
		}
		catch(Exception e1) {
			throw e1;
		}
	}
	
	@Override
	public String toString() {
		return  expr.toString();
	}
	
	@Override
	public String calc(Environment e) {
		String value = Double.toString(getSlotData(e));
    	return value;
    }

}
