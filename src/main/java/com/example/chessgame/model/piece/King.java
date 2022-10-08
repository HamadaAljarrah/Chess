package com.example.chessgame.model.piece;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.movement.KingMove;

public class King extends Piece{
    public King(Color color) {
        super(color, new KingMove());
        if (getColor() == Color.BLACK) {
            setImagePath("assets/BLACK_KING.png");
        } else {
            setImagePath("assets/WHITE_KING.png");
        }
    }
    public String toString(){
        return "[" + getColor() + " King]";
    }

}
