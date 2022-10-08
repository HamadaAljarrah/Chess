package com.example.chessgame.model.movement;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.Index;

public class KnightMove implements IMove{


    @Override
    public boolean check(Index source, Index destination) {
        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        return Math.abs(srcCol-destCol) * Math.abs(srcRow-destRow) == 2 ;
    }
}
