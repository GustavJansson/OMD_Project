package model;

import java.io.IOException;

import expr.ExprParser;

public class SlotCreator {

	public static Slot toSlot(String s) throws IOException {
		
		Expression expr;
		
		if (s.length() > 0 && s.charAt(0) == '#') {
			return new Comment(s.substring(1));
		}
		else {
			ExprParser parser = new ExprParser();
			try {
				expr = new Expression(parser.build(s));
				
			} catch (XLException e) {
				throw e;
			}
			
			return expr;
		}
	}
	
}
