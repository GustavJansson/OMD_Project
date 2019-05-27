package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.XLException;
import model.XLSheet;

public class StatusLabel extends ColoredLabel implements Observer {
	private CurrentSlot cs;
	private String message;
	
    public StatusLabel(CurrentSlot cs) {
        super("", Color.WHITE);
        this.cs = cs;
        cs.addObserver(this);
        message = "";
        
    }

    public void update(Observable observable, Object object) {
        setText("");

    }
    public void setString(String text) {
    	setText(text);
    }
}