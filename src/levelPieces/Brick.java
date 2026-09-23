package levelPieces;
import gameEngine.Drawable;

public class Brick implements Drawable {
	
	private char symbol;
	private static int location = 5;
	
	public Brick() {
		symbol = '-';
	}
	
	public int getLocation() {
		return location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}

}
