package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLSheet;

public class Editor extends JTextField implements ActionListener, Observer {

	private CurrentSlot cs;
	private XLSheet sheet;


    public Editor(XLSheet sheet, CurrentSlot cs) {
    	this.cs = cs;
    	this.sheet = sheet;
        setBackground(Color.WHITE);
        addActionListener(this);
        cs.addObserver(this);

    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//works when pressing enter
		System.out.println("hej");
		String value = this.getText();
		String key = cs.toString();
		if (!value.equals("")) {
			sheet.add(key, value);
		}
		

        
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//setBackground(Color.YELLOW);
		setText(sheet.print(cs.toString()));
	}
}
