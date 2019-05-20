package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements Observer, MouseListener{
	private CurrentLabel cl;
	
    public SlotLabel() {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.setText((String)arg);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setBackground(Color.YELLOW);
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}