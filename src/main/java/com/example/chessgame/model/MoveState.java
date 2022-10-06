package com.example.chessgame.model;

import com.example.chessgame.model.movement.PawnMove;
import com.example.chessgame.model.piece.Color;
import com.example.chessgame.model.piece.NonePiece;
import com.example.chessgame.model.piece.Pawn;
import com.example.chessgame.model.piece.Piece;

public class MoveState {
    private Index src, dest;
    private Piece pieceHeld;

    public MoveState() {
        pieceHeld = null;
    }

    public Index getSrc() {
        return src;
    }

    public void setSrc(Index src) {
        this.src = src;
    }

    public Index getDest() {
        return dest;
    }

    public void setDest(Index dest) {
        this.dest = dest;
    }

    public Piece getPieceHeld() {
        return pieceHeld;
    }

    public void setPieceHeld(Piece pieceHeld) {
        if(this.pieceHeld == null){
            this.pieceHeld = pieceHeld;
        }
    }
    public void removePieceHeld() {
        this.pieceHeld = null;
    }
}
