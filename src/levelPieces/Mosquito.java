package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Mosquito extends GamePiece implements Moveable {
	public Mosquito(char symbol, String label, int location) {
		super(symbol, label, location);
		System.out.println("M: Mosquito (take damage if within 4 spaces of it)");
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int current = getLocation();
		int next = current;
		if (playerLocation > current) next = current + 1;
		else if (playerLocation < current) next = current - 1;

		// only move into an empty square that's on the board
		if (next != current && next >= 0 && next < gameBoard.length && gameBoard[next] == null) {
			gameBoard[current] = null;   // clear the old spot
			setLocation(next);
			gameBoard[next] = this;      // take the new spot
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(getLocation() - playerLocation) <= 3)
			return InteractionResult.HIT;
		return InteractionResult.NONE;
	}
}
