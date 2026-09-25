package levelPieces;

import gameEngine.Drawable;

/**
 * Brick is a plain obstacle. It is drawn on the board and blocks moving
 * pieces, but does not interact with the player.
 */
public class Brick implements Drawable {

	private char symbol;
	private int location;

	public Brick(int location) {
		symbol = '-';
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}

}
