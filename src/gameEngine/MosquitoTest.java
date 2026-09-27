package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import levelPieces.Mosquito;

class MosquitoTest {

	@Test
	public void testMosquito() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Mosquito m = new Mosquito('M', "Mosquito", 16);
		gameBoard[16] = m;
		// Hit points if player on same space
		//assertEquals(InteractionResult.HIT, m.interact(gameBoard, 12));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 13));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 14));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 15));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 16));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 17));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 18));
		assertEquals(InteractionResult.HIT, m.interact(gameBoard, 19));
		//assertEquals(InteractionResult.HIT, m.interact(gameBoard, 20));
		// These loops ensure no interaction if not on same space
		
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, m.interact(gameBoard, i));
		for (int i=20; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, m.interact(gameBoard, i));
	}	

}
