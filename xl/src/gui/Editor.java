package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLSheet;

public class Editor extends JTextField implements ActionListener, Observer {
	
	
	private CurrentLabel cl;
	private XLSheet sheet;
	
    public Editor(CurrentLabel cl, XLSheet sheet) {
    	this.cl = cl;
    	this.sheet = sheet;
        setBackground(Color.WHITE);
        addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("hej");
		

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
