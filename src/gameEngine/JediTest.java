package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Jedi;

class JediTest {

	@Test
	public void testJedi() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Jedi j = new Jedi('J', "Jedi", 10);
		gameBoard[10] = j;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, j.interact(gameBoard, 10));
		assertEquals(InteractionResult.ADVANCE, j.interact(gameBoard, 11));
		assertEquals(InteractionResult.ADVANCE, j.interact(gameBoard, 12));
		assertEquals(InteractionResult.ADVANCE, j.interact(gameBoard, 9));
		assertEquals(InteractionResult.ADVANCE, j.interact(gameBoard, 8));
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<8; i++)
			assertEquals(InteractionResult.NONE, j.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, j.interact(gameBoard, i));
	}	

}
