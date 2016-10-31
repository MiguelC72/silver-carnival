package game.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseMotionListener, MouseListener{
	
	public boolean left, right;
	private int x, y;
	
	public MouseManager() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Nothing needed here
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Nothing needed here
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			left = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			right = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			left = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			right = false;
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//Getters and setters WOW NICE
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
