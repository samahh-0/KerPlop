package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Cliff extends GamePiece{

	public Cliff(char symbol, String label, int location) {
		super(symbol, label, location);
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation)
		return InteractionResult.HIT;
	return InteractionResult.NONE;
	}

}
