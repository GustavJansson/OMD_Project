package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.XLPrintStream;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
    	XLPrintStream print = new XLPrintStream(path);
    	print.save(xl.data());
    	print.close();
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}