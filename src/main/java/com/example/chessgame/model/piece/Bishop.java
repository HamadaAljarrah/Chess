package com.example.chessgame.model.piece;

import com.example.chessgame.model.movement.BishopMove;

public class Bishop extends Piece{
    public Bishop(Color color) {

        super(color, new BishopMove());
        if (getColor() == Color.BLACK) {
            setImagePath("assets/BLACK_BISHOP.png");
        } else {
            setImagePath("assets/WHITE_BISHOP.png");
        }
    }
    @Override
    public String toString(){
        return "[" + getColor() + " Bishop]";
    }
}
