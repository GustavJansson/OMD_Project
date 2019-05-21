package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.XLSheet;

public class SlotLabel extends ColoredLabel implements Observer, MouseListener{
	private CurrentSlot slot;
	private String position;
	private XLSheet sheet;
	
    public SlotLabel(CurrentSlot slot, XLSheet sheet, String position) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.slot = slot;
        this.sheet = sheet;
        this.position = position;
        sheet.addObserver(this);
    }

    public String toString() {
    	return position;
    }
    
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//Vad som visas i rutan
		
		this.setText(sheet.print(position));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.getBackground() != Color.yellow) {
			this.setBackground(Color.LIGHT_GRAY);
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(this.getBackground() != Color.yellow) {
			this.setBackground(Color.WHITE);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		slot.reset();
		this.setBackground(Color.YELLOW);
		slot.set(this);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}