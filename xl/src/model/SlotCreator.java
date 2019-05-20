package model;

import expr.ExprParser;

public class SlotCreator {

	public static Slot toSlot(String s) {
		if (s.length() > 0 && s.charAt(0) == '#') {
			return new Comment(s);
		}
		else {
			ExprParser parser = new ExprParser();
			try {
				return new Expression(parser.build(s));
			} catch (Exception e) {
				return null;
			}
		}
	}
	
}
