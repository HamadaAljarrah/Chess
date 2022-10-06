package com.example.chessgame.model.piece;

import com.example.chessgame.model.movement.IMove;
import com.example.chessgame.model.movement.PawnMove;

public class NonePiece extends Piece{
    private String type;
    public NonePiece() {
        super(Color.BLACK, new PawnMove());
    }

    @Override
    public String toString() {
        return "NonePiece";
    }
}
