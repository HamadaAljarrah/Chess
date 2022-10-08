package com.example.chessgame.tests;

import com.example.chessgame.model.Block;
import com.example.chessgame.model.Board;
import com.example.chessgame.model.Index;
import com.example.chessgame.model.piece.Color;
import com.example.chessgame.model.piece.King;

public class BoardTest {
    private Board board;

    public BoardTest() {
        this.board = Board.getInstance();
    }

    public void testPrint(){this.board.print();}
    public void testAddAndRemovePiece(){
        board.addPieceToBlock(new Index(3, 3), new King(Color.BLACK));
        board.print();
        System.out.println("\n\n");
        board.removePieceFromBlock(new Index(3, 3));
        board.removePieceFromBlock(new Index(1, 1));

        board.print();

    }

    public static void main(String args[]){
        BoardTest test = new BoardTest();
        test.testAddAndRemovePiece();
    }
}
