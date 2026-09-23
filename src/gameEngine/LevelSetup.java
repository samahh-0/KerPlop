package gameEngine;

import levelPieces.GamePiece;

/**
 * LevelSetup
 */
public interface LevelSetup {

    private Drawable[] board;
    
    public LevelSetup(){
        
    }
    public void createLevel(int levelNum);
    public Drawable[] getBoard();
    public java.util.ArrayList<Moveable> getMovingPieces();
    public java.util.ArrayList<GamePiece> getInteractingPieces();
    public int getPlayerStartLoc();
}
