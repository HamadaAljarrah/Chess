package com.example.chessgame.tests;

import com.example.chessgame.model.Game;
import com.example.chessgame.model.Index;

public class GameTest {
    private Game game;

    public GameTest() {
        this.game = new Game();
    }

    public void testMovePiece(){
        game.movePiece(new Index(1,1));
        game.movePiece(new Index(2,2));

    }

    public void print(){
        game.print();
    }
    public static void main (String args[]){
        GameTest test = new GameTest();
        test.print();
        test.testMovePiece();
        System.out.println("\n");
        test.print();

    }
}
