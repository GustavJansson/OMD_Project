package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLSheet;

public class Editor extends JTextField implements ActionListener, Observer {

	XLSheet sheet = new XLSheet();

    public Editor() {
        setBackground(Color.WHITE);
        addActionListener(this);

    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//works when pressing enter
		System.out.println("Enter pressed " + this.getText());
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setBackground(Color.YELLOW);
	}
}
