package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Jedi extends GamePiece{

	public Jedi(char symbol, String label, int location) {
		super(symbol, label, location);
		symbol = 'J';
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) < 3)
		return InteractionResult.ADVANCE;
	return InteractionResult.NONE;
	}

}
