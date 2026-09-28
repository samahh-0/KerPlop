package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Troll;

class TrollTest {

	@Test
	public void testTroll() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Troll t = new Troll('T', "Troll", 9);
		gameBoard[9] = t;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, t.interact(gameBoard, 8));
		assertEquals(InteractionResult.KILL, t.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<8; i++)
			assertEquals(InteractionResult.NONE, t.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, t.interact(gameBoard, i));
	}	

}
