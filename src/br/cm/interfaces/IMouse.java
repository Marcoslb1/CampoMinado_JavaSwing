package br.cm.interfaces;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface IMouse extends MouseListener {

	@Override
	public void mousePressed(MouseEvent e);
	
	@Override
	default void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	default void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	default void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	default void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
