package levelPieces;
// Sandwich GamePiece
// Player gets a point if it is on the same space
// Does not move
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sandwich extends GamePiece{

	public Sandwich(char symbol, String label, int location) {
		super(symbol, label, location);
		System.out.println("<: Sandwich (get point if on same space)");
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation)
		return InteractionResult.GET_POINT;
	return InteractionResult.NONE;
	}

}
