package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer{
    public SlotLabel() {
        super("                    ", Color.WHITE, RIGHT);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		this.setText((String)arg);
	}
}