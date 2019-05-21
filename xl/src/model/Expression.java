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
		return expr.value(e);
	}
	
	@Override
	public String toString() {
		return  expr.toString();
	}
	
	public String print(Environment e) {
		String value = Double.toString(getSlotData(e));
    	return value;
    }

}
