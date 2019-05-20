package gui;

import java.awt.Color;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer{
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.setText((String)arg);
		
	}

}