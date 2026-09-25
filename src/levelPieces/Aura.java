package levelPieces;


import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Aura extends GamePiece{

	public Aura(char symbol, String label, int location) {
		super(symbol, label, location);
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) < 3)
		return InteractionResult.GET_POINT;
	return InteractionResult.NONE;
	}

}