package com.example.chessgame.model.movement;

import com.example.chessgame.model.Block;
import com.example.chessgame.model.Board;
import com.example.chessgame.model.Collision;
import com.example.chessgame.model.Index;

public class BishopMove implements IMove{


    @Override
    public boolean check(Index source, Index destination) {
        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        boolean moveDiagonally = Math.abs(srcCol-destCol) == Math.abs(srcRow-destRow);
        boolean noDiagonalBlocking = Collision.getNumOfDiagonalBlockingPieces(source,destination, Board.getInstance()) == 0;
        boolean tryingToEat = Collision.canEat(source,destination,Board.getInstance());

        return moveDiagonally && (noDiagonalBlocking || tryingToEat);
    }
}
