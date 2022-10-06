package com.example.chessgame.model.movement;

import com.example.chessgame.model.Block;
import com.example.chessgame.model.Index;

public class QueenMove implements IMove{
    @Override
    public boolean check(Index source, Index destination) {

        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        boolean roleOne = Math.abs(srcCol-destCol) == Math.abs(srcRow-destRow) ;
        boolean roleTow = Math.abs(srcCol-destCol)  * Math.abs(srcRow-destRow) == 0;

        return roleOne ||  roleTow;
    }
}
