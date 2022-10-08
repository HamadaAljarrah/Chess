package com.example.chessgame.model.movement;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.Index;
import com.example.chessgame.model.piece.Color;

public class PawnMove implements IMove{
    private boolean isFirstMove;
    private final Board board;
    public PawnMove(Board board) {
        this.board = board;
        this.isFirstMove = true;
    }



    @Override
    public boolean check(Index source, Index destination) {
        if(source.equals(destination)) return false;

        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        Color color = board.getPieceByIndex(source).getColor();

        boolean sameCol = Math.abs(srcCol - destCol) * Math.abs(srcRow - destRow) == 0;
        boolean oneStepBlack = (srcRow - destRow == -1 && Math.abs(destCol - srcCol) ==0);
        boolean oneStepWhite = (srcRow - destRow == 1 && Math.abs(destCol - srcCol) == 0);
        boolean twoStepBlack = (srcRow - destRow == -2 && Math.abs(destCol - srcCol) ==0);
        boolean twoStepWhite = (srcRow - destRow == 2 && Math.abs(destCol - srcCol) == 0);


        boolean theMove = false;
        if(isFirstMove){
            boolean roleWhite = (sameCol && oneStepWhite) || (sameCol && twoStepWhite);
            boolean roleBlack =  (sameCol && oneStepBlack) || (sameCol && twoStepBlack);
            theMove = color == Color.WHITE ? roleWhite: roleBlack;
            isFirstMove = false;
        }
        else{
            boolean roleWhite = sameCol && oneStepWhite;
            boolean roleBlack =  sameCol && oneStepBlack;
            theMove = color == Color.WHITE ? roleWhite: roleBlack;
        }

        return theMove;


    }
}
