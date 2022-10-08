package com.example.chessgame.model;

import com.example.chessgame.model.piece.Piece;

import java.util.List;

public class Game {
    private final Board board;
    private final MoveState moveState;

    public Game() {
        this.board = Board.getInstance();
        this.moveState = new MoveState();
    }

    private void holdPiece(Index index){
        Piece pieceToHold = board.getPieceByIndex(index);
        moveState.setSrc(index);
        moveState.setPieceHeld(pieceToHold);
    }

    private Piece dropPiece(Index index){

            Piece pieceToDrop = moveState.getPieceHeld();
            moveState.removePieceHeld();
            moveState.setDest(index);
            return pieceToDrop;

    }

    public void movePiece(Index index){

        if(moveState.getPieceHeld() == null){
            holdPiece(index);
        }
        else {
            Piece pieceToDrop = dropPiece(index);
            if(pieceToDrop.isLegalMove(moveState.getSrc(), moveState.getDest())){
                board.removePieceFromBlock(moveState.getSrc());
                board.addPieceToBlock(moveState.getDest(), pieceToDrop);
            }
            else {
                System.out.println("Illegal Move, PieceHeld: " + moveState.getPieceHeld());
            }
        }
    }

    public void print(){
        board.print();
    }
    public List<List<Block>> getBlocks() {
        return board.getBlocks();
    }

}
