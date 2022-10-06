package com.example.chessgame.model.piece;


import com.example.chessgame.model.movement.QueenMove;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color, new QueenMove());
        if (getColor() == Color.BLACK) {
            setImagePath("assets/BLACK_QUEEN.png");
        } else {
            setImagePath("assets/WHITE_QUEEN.png");
        }
    }
    public String toString(){
        return "[" + getColor() + " Queen]";
    }

}
