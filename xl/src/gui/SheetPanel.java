package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.XLSheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentSlot slot, XLSheet sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, slot, sheet));
    }
}