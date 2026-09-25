package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Jedi wanders one step left or right at random each turn. Getting within
 * 2 spaces of the Jedi advances the player to the next level.
 */
public class Jedi extends GamePiece implements Moveable {

	private Random rand = new Random();

	public Jedi(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int current = getLocation();
		int next = rand.nextBoolean() ? current + 1 : current - 1;

		// only move into an empty square that's on the board
		if (next >= 0 && next < gameBoard.length && gameBoard[next] == null) {
			gameBoard[current] = null;
			setLocation(next);
			gameBoard[next] = this;
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(getLocation() - playerLocation) < 3)
			return InteractionResult.ADVANCE;
		return InteractionResult.NONE;
	}

}
