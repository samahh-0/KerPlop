package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Brick;
import levelPieces.Jedi;
import levelPieces.Troll;

class MovementTests {

	@Test
	public void testJediMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=0;i<=4; i++)
			gameBoard[i] = new Brick(i);
		// Leave 6 open
		for (int i=10;i<=20; i++)
			gameBoard[i] = new Brick(i);
		// Place Sniper in an open space - 6
		// Note that Sniper location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Jedi j = new Jedi('J', "Jedi", 6);
		gameBoard[6] = j;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		for (int i=0; i<200; i++) {
			j.move(gameBoard, 13);
			int loc = j.getLocation();
			// ensure no other space is chosen
			if (loc <= 4 | loc >=10)
				fail("Invalid square selected");
			// counters to ensure valid options are chosen
			if (loc == 5) count5++;
			if (loc == 6) count6++;
			if (loc == 7) count7++;
			if (loc == 8) count8++;
			if (loc == 9) count9++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count5 > 1);
		assert(count6 > 1);
		assert(count7 > 1);
		assert(count8 > 1);
		assert(count9 > 1);
	}
	
	@Test
	public void testTrollMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=0;i<=4; i++)
			gameBoard[i] = new Brick(i);
		// Leave 6 open
		for (int i=10;i<=20; i++)
			gameBoard[i] = new Brick(i);
		// Place Sniper in an open space - 6
		// Note that Sniper location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Troll t = new Troll('T', "Troll", 6);
		gameBoard[6] = t;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		for (int i=0; i<200; i++) {
			t.move(gameBoard, 13);
			int loc = t.getLocation();
			// ensure no other space is chosen
			if (loc <= 4 | loc >=10)
				fail("Invalid square selected");
			// counters to ensure valid options are chosen
			if (loc == 5) count5++;
			if (loc == 6) count6++;
			if (loc == 7) count7++;
			if (loc == 8) count8++;
			if (loc == 9) count9++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count5 > 1);
		assert(count6 > 1);
		assert(count7 > 1);
		assert(count8 > 1);
		assert(count9 > 1);
		// Should be moving in the middle the most
		assert(count7 > count9);
		assert(count7 > count5);
	}

}
