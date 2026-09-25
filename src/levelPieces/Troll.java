package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Troll patrols back and forth, turning around when it hits the edge of the
 * board or another piece. Standing right next to the Troll kills the player.
 */
public class Troll extends GamePiece implements Moveable {

	// +1 = moving right, -1 = moving left
	private int direction = 1;

	public Troll(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int current = getLocation();
		int next = current + direction;

		// blocked, so turn around and try the other way
		if (next < 0 || next >= gameBoard.length || gameBoard[next] != null) {
			direction = -direction;
			next = current + direction;
		}

		if (next >= 0 && next < gameBoard.length && gameBoard[next] == null) {
			gameBoard[current] = null;
			setLocation(next);
			gameBoard[next] = this;
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(getLocation() - playerLocation) == 1)
			return InteractionResult.KILL;
		return InteractionResult.NONE;
	}

}
