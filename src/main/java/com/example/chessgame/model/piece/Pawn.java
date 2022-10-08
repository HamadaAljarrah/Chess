package com.example.chessgame.model.piece;


import com.example.chessgame.model.Board;
import com.example.chessgame.model.movement.PawnMove;

public class Pawn extends Piece{


    public Pawn(Color color, Board board) {
        super(color, new PawnMove(board));
        if (getColor() == Color.BLACK) {

            setImagePath("assets/BLACK_PAWN.png");
        } else {
            setImagePath("assets/WHITE_PAWN.png");
        }
    }

    @Override
    public String toString(){
        return "[" + getColor() + " Pawn]";
    }

}
