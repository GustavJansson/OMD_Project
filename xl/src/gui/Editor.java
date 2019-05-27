package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLException;
import model.XLSheet;

public class Editor extends JTextField implements ActionListener, Observer {

	private CurrentSlot cs;
	private XLSheet sheet;
	private StatusLabel sl;

    public Editor(XLSheet sheet, CurrentSlot cs, StatusLabel sl) {
    	this.cs = cs;
    	this.sheet = sheet;
        setBackground(Color.WHITE);
        addActionListener(this);
        cs.addObserver(this);
        this.sl = sl;

    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//works when pressing enter
		String value = this.getText();
		String key = cs.toString();

		try {
			sheet.add(key, value);
			sl.setString("");
		} catch (XLException e) {
		//	throw e;
			sl.setString(e.getMessage());
		}  
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		try {
			setText(sheet.printSlot(cs.toString()));
		}
		catch (XLException e) {
			setText("FEL!");
		}
	}
}
