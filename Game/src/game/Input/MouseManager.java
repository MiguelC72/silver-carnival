package game.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener{
	
	public boolean left, right;
	int x, y;

	@Override
	public void mouseClicked(MouseEvent e) {
		//Nothing needed here
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Nothing needed here
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Nothing needed here
	}
	
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			left = true;
		} if (e.getButton() == MouseEvent.BUTTON3){
			right = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			left = false;
		} if (e.getButton() == MouseEvent.BUTTON3){
			right = false;
		}
	}

	//Getters and setters WOW NICE
	
	public boolean isLeft() {
		return left;
	}
	
	public boolean isRight() {
		return right;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
