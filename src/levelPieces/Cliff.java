package levelPieces;
// Cliff GamePiece
// If the player is on the same space as the cliff, it hits
// Does not move

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Cliff extends GamePiece{

	public Cliff(char symbol, String label, int location) {
		super(symbol, label, location);
		System.out.println("L: Cliff (take damage if on same space)");
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation)
		return InteractionResult.HIT;
	return InteractionResult.NONE;
	}

}
