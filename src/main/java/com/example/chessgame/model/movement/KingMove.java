package com.example.chessgame.model.movement;

import com.example.chessgame.model.Index;

public class KingMove implements IMove{

    @Override
    public boolean check(Index source, Index destination) {
        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        boolean roleOne = Math.abs(srcCol-destCol) == 1 && Math.abs(srcRow-destRow) == 1;
        boolean roleTow = (Math.abs(srcCol-destCol)  * Math.abs(srcRow-destRow) == 0)
                && (Math.abs(destRow - srcRow) ==1 || Math.abs(srcCol - destCol) ==1);

        return roleOne ||  roleTow;
    }
}
