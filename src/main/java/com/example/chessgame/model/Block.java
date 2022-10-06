package com.example.chessgame.model;

import com.example.chessgame.model.piece.Color;
import com.example.chessgame.model.piece.Piece;

public class Block {
    private final Index index;
    private  Color color;
    private Piece piece;


    public Block(Index index, Color color) {
        this.index = index;
        this.color = color;
    }

    public int getColumn() {
        return index.getColumn();
    }


    public int getRow() {
        return index.getRow();
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public void removePiece(){this.piece = null;}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {this.color = color;}
    public boolean hasPiece(){return this.piece != null;}

    public Index getIndex(){
        return this.index;
    }

    @Override
    public String toString() {
        return "[b: " +index.getRow() +" "+  index.getColumn() + " " +piece+"]";
    }
}
