package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.XLException;
import model.XLSheet;

public class StatusLabel extends ColoredLabel implements Observer {
	private XLSheet sheet;
	private String message;
	
    public StatusLabel(XLSheet sheet) {
        super("", Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);
        message = "";
        
    }

    public void update(Observable observable, Object object) {
        setText(message);

    }
    public void setString(String text) {
    	message = text;
    }
}