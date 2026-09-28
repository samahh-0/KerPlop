package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Aura;

class AuraTest {

	@Test
	public void testAura() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Aura a = new Aura('A', "Aura", 17);
		gameBoard[17] = a;
		// Hit points if player on same space
		assertEquals(InteractionResult.GET_POINT, a.interact(gameBoard, 15));
		assertEquals(InteractionResult.GET_POINT, a.interact(gameBoard, 16));
		assertEquals(InteractionResult.GET_POINT, a.interact(gameBoard, 17));
		assertEquals(InteractionResult.GET_POINT, a.interact(gameBoard, 18));
		assertEquals(InteractionResult.GET_POINT, a.interact(gameBoard, 19));
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<15; i++)
			assertEquals(InteractionResult.NONE, a.interact(gameBoard, i));
		for (int i=20; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, a.interact(gameBoard, i));
	}	

}
