package com.example.chessgame.model.piece;

import com.example.chessgame.model.movement.IMove;
import com.example.chessgame.model.movement.KnightMove;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color, new KnightMove());
        if (getColor() == Color.BLACK) {
            setImagePath("assets/BLACK_KNIGHT.png");
        } else {
            setImagePath("assets/WHITE_KNIGHT.png");
        }
    }
    @Override
    public String toString(){
        return "[" + getColor() + " Knight]";
    }
}
