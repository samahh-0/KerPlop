package levelPieces;


import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Troll extends GamePiece{

	public Troll(char symbol, String label, int location) {
		super(symbol, label, location);
		symbol = 'T';
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) == 1)
		return InteractionResult.KILL;
	return InteractionResult.NONE;
	}

}
