package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Cliff;

class CliffTest {

	@Test
	public void testCliff() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Cliff c = new Cliff('L', "Cliff", 7);
		gameBoard[7] = c;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, c.interact(gameBoard, 7));
		
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<7; i++)
			assertEquals(InteractionResult.NONE, c.interact(gameBoard, i));
		for (int i=8; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, c.interact(gameBoard, i));
	}	

}
