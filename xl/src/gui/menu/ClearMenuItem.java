package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.XLSheet;
	
	
class ClearMenuItem extends JMenuItem implements ActionListener {
	
	private XLSheet sheet;
	private CurrentSlot currentslot;
	
    public ClearMenuItem(XLSheet sheet,CurrentSlot currentslot) {
        super("Clear");
        this.sheet = sheet;
        this.currentslot = currentslot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO
    	this.sheet.remove(this.currentslot.toString());
    }
}