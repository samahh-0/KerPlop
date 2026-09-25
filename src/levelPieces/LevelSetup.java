package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;
import java.util.Random;

/**
 * LevelSetup builds the board, the list of moving pieces and the list of
 * interacting pieces for each level.
 */
public class LevelSetup {

	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;

	public LevelSetup() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		playerStartLoc = 0;
	}

	public void createLevel(int levelNum) {
		clearAll();
		if (levelNum == 1) {
			level1();
		} else if (levelNum == 2) {
			level2();
		}
	}

	public Drawable[] getBoard() {
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return playerStartLoc;
	}

	/**
	 * Level 1: every piece at a random location.
	 */
	private void level1() {
		UniqueRandomPool roller = new UniqueRandomPool(0, board.length - 1);

		// reserve the player's square first so no piece starts on top of them
		playerStartLoc = roller.drawNumber();

		Jedi jedi = new Jedi('J', "Jedi", roller.drawNumber());
		Troll troll = new Troll('T', "Troll", roller.drawNumber());
		Mosquito mosquito = new Mosquito('M', "Mosquito", roller.drawNumber());
		Aura aura = new Aura('A', "Aura", roller.drawNumber());
		Cliff cliff = new Cliff('L', "Cliff", roller.drawNumber());
		Sandwich sandwich = new Sandwich('<', "Sandwich", roller.drawNumber());
		Brick brick = new Brick(roller.drawNumber());

		addMoving(jedi);
		addMoving(troll);
		addMoving(mosquito);
		addStatic(aura);
		addStatic(cliff);
		addStatic(sandwich);
		board[brick.getLocation()] = brick;
	}

	/**
	 * Level 2: fixed layout with bricks walling off the Jedi and two Mosquitos.
	 */
	private void level2() {
		playerStartLoc = 10;

		Brick leftWall = new Brick(3);
		Brick rightWall = new Brick(17);
		board[leftWall.getLocation()] = leftWall;
		board[rightWall.getLocation()] = rightWall;

		addMoving(new Jedi('J', "Jedi", 0));
		addMoving(new Troll('T', "Troll", 14));
		addMoving(new Mosquito('M', "Mosquito", 6));
		addMoving(new Mosquito('M', "Mosquito", 19));
		addStatic(new Sandwich('<', "Sandwich", 8));
		addStatic(new Sandwich('<', "Sandwich", 12));
		addStatic(new Cliff('L', "Cliff", 5));
		addStatic(new Aura('A', "Aura", 20));
	}

	/**
	 * Place a piece that moves and interacts on the board and in both lists.
	 */
	private <T extends GamePiece & Moveable> void addMoving(T piece) {
		board[piece.getLocation()] = piece;
		movingPieces.add(piece);
		interactingPieces.add(piece);
	}

	/**
	 * Place a piece that interacts but never moves.
	 */
	private void addStatic(GamePiece piece) {
		board[piece.getLocation()] = piece;
		interactingPieces.add(piece);
	}

	private void clearAll() {
		board = new Drawable[board.length];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		playerStartLoc = 0;
	}

	/**
	 * Simple UniqueRandomPool implementation to supply non-repeating ints in a range.
	 */
	private static class UniqueRandomPool {
		private final int min;
		private final boolean[] used;
		private final Random rand = new Random();
		private int remaining;

		UniqueRandomPool(int min, int max) {
			this.min = min;
			int size = Math.max(0, max - min + 1);
			used = new boolean[size];
			remaining = size;
		}

		public int drawNumber() {
			if (remaining <= 0)
				throw new IllegalStateException("No numbers remaining in pool");
			int idx;
			// find random unused index
			do {
				idx = rand.nextInt(used.length);
			} while (used[idx]);
			used[idx] = true;
			remaining--;
			return min + idx;
		}
	}
}
