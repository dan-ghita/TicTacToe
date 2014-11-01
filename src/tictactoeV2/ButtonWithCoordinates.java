package tictactoeV2;

import javax.swing.JButton;

public class ButtonWithCoordinates extends JButton {
	private int coordX, coordY;

	public ButtonWithCoordinates(int ix, int iy, String text) {
		super(text);
		coordX = ix;
		coordY = iy;
	}

	public int getXCoordinate() {
		return coordX;
	}

	public int getYCoordinate() {
		return coordY;
	}

}
