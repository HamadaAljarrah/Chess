package com.example.chessgame.model.piece;


import com.example.chessgame.model.movement.PawnMove;

public class Pawn extends Piece{


    public Pawn(Color color) {
        super(color, new PawnMove());
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
