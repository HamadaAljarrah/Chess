package com.example.chessgame.model.movement;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.Collision;
import com.example.chessgame.model.Index;

public class QueenMove implements IMove{




    @Override
    public boolean check(Index source, Index destination) {

        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        boolean moveDiagonally = Math.abs(srcCol-destCol) == Math.abs(srcRow-destRow) ;
        boolean moveStraight = Math.abs(srcCol-destCol)  * Math.abs(srcRow-destRow) == 0;
        boolean noStraightBlocking = Collision.getNumOfStraightBlockingPieces(source,destination, Board.getInstance()) == 0;
        boolean noDiagonalBlocking = Collision.getNumOfDiagonalBlockingPieces(source,destination, Board.getInstance()) == 0;
        boolean tryingToEat = Collision.canEat(source,destination,Board.getInstance());

        return (moveStraight && (noStraightBlocking || tryingToEat)) || (moveDiagonally && (noDiagonalBlocking || tryingToEat));
    }
}
