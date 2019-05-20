package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.XLSheet;
class ClearAllMenuItem extends JMenuItem implements ActionListener {
	
	private XLSheet sheet;
	
    public ClearAllMenuItem(XLSheet sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO
    	sheet.clear();
    }
}