package com.example.chessgame.model;

import com.example.chessgame.model.piece.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Block>> blocks;

    public Board() {
        this.blocks = new ArrayList<>(8);
        resetBoard();
    }

    public void resetBoard(){
        blocks.clear();
        fillWithBlocks();
        fillWithPieces();
    }
//    public void movePiece(Index src, Index dest){
//        Index srcIndex = new Index(src.getRow(), src.getColumn());
//        Index destIndex = new Index(dest.getRow(), dest.getColumn());
//        Piece pieceToMove = getPieceByIndex(srcIndex);
//        if(pieceToMove != null){
//            getBlockByIndex(destIndex).setPiece(pieceToMove);
//            getBlockByIndex(srcIndex).removePiece();
//        }
//    }

    public void removePieceFromBlock(Index index){
        blocks.get(index.getRow()).get(index.getColumn()).removePiece();
    }
    public void addPieceToBlock(Index index, Piece piece){
        blocks.get(index.getRow()).get(index.getColumn()).setPiece(piece);
    }
    public Piece getPieceByIndex(Index index){
        return blocks.get(index.getRow()).get(index.getColumn()).getPiece();
    }
    public List<List<Block>> getBlocks() {
        List<List<Block>> copy = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            copy.add(new ArrayList<>(8));
            for (int j = 0; j < 8; j++) {
                copy.get(i).add(this.blocks.get(i).get(j));
            }
        }
        return copy;
    }

    private Color toggleColor(Color color){
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }
    private void fillWithBlocks(){
        Color lastColor = Color.BLACK;
        for (int i = 0; i < 8; i++) {
            lastColor = toggleColor(lastColor);
            ArrayList<Block> row = new ArrayList<>(8);
            for (int j = 0; j < 8; j++) {
                Block block = new Block(new Index(i,j), lastColor);
                row.add(block);
                lastColor = toggleColor(lastColor);
            }
            blocks.add(row);
        }
    }
    private void fillWithPieces(){
        for (int i = 0; i < 8; i++) {
            blocks.get(1).get(i).setPiece(new Pawn(Color.BLACK));
            blocks.get(6).get(i).setPiece(new Pawn(Color.WHITE));
            if(i == 0 || i == 7) {
                blocks.get(0).get(i).setPiece(new Rook(Color.BLACK));
                blocks.get(7).get(i).setPiece(new Rook(Color.WHITE));
            }
            if(i == 1 || i == 6){
                blocks.get(0).get(i).setPiece(new Knight(Color.BLACK));
                blocks.get(7).get(i).setPiece(new Knight(Color.WHITE));
            }
            if(i == 2 || i == 5){
                blocks.get(0).get(i).setPiece(new Bishop(Color.BLACK));
                blocks.get(7).get(i).setPiece(new Bishop(Color.WHITE));
            }
            if(i == 4){
                blocks.get(0).get(i).setPiece(new Queen(Color.BLACK));
                blocks.get(7).get(i).setPiece(new King(Color.WHITE));
            }
            if(i == 3 ){
                blocks.get(0).get(i).setPiece(new King(Color.BLACK));
                blocks.get(7).get(i).setPiece(new Queen(Color.WHITE));
            }
        }
    }

    public void print() {
        for (List<Block> list: blocks){
            System.out.println(list);
        }
    }
}
