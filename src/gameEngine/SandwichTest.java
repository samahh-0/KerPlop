package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Sandwich;

class SandwichTest {

	@Test
	public void testTroll() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Sandwich s = new Sandwich('<', "Sandwich", 12);
		gameBoard[12] = s;
		// Hit points if player on same space
		assertEquals(InteractionResult.GET_POINT, s.interact(gameBoard, 12));
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, s.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, s.interact(gameBoard, i));
	}	

}
