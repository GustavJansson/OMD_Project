package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Slot;
import model.XLBufferedReader;
import model.XLException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;


class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
    	XLBufferedReader read = null;
    	Map<String, Slot> sheet = new HashMap<String, Slot>();
    	
    	try {
    		read = new XLBufferedReader(path);
    	}
    	catch (FileNotFoundException e) {
    		statusLabel.setText(e.getMessage());
    	}

         read.load(sheet);


    	 xl.setXL((HashMap<String, Slot>) sheet);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}