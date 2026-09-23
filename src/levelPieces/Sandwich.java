package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sandwich extends GamePiece{

	public Sandwich(char symbol, String label, int location) {
		super(symbol, label, location);
		symbol = '<';
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation)
		return InteractionResult.GET_POINT;
	return InteractionResult.NONE;
	}

}
