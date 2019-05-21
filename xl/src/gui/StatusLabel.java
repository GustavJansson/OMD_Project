package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.XLSheet;

public class StatusLabel extends ColoredLabel implements Observer {
	private XLSheet sheet;
    public StatusLabel(XLSheet sheet) {
        super("", Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);

    }

    public void update(Observable observable, Object object) {
        this.setText(sheet.error());
    }
}