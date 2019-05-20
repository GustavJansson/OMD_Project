package gui;

import java.awt.Color;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer{
	
	private CurrentSlot current;
	
    public CurrentLabel(CurrentSlot cs) {
        super("A1", Color.WHITE);
        current = cs;
        cs.addObserver(this);
    }

	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
		setText(current.toString());
		
	}

}