package levelPieces;

// Aura GamePiece 
// If the player is 2 spaces away or less, gives a point
// Does not move
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Aura extends GamePiece{

	public Aura(char symbol, String label, int location) {
		super(symbol, label, location);
		System.out.println("A: Aura (gives points if within 2 spaces)");
	}
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) < 3)
		return InteractionResult.GET_POINT;
	return InteractionResult.NONE;
	}

}
