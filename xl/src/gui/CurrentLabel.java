package gui;

import java.awt.Color;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class CurrentLabel extends ColoredLabel implements Observable{
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}
}