package com.example.chessgame.model.piece;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.movement.IMove;
import com.example.chessgame.model.movement.RookMove;

public class Rook extends Piece{

    public Rook(Color color) {
        super(color, new RookMove());
        if (getColor() == Color.BLACK) {
            setImagePath("assets/BLACK_ROOK.png");
        } else {
            setImagePath("assets/WHITE_ROOK.png");
        }
    }
    @Override
    public String toString(){
        return "[" + getColor() + " Rook]";
    }
}
