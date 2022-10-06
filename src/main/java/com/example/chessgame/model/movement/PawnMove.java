package com.example.chessgame.model.movement;

import com.example.chessgame.model.Index;
import com.example.chessgame.model.piece.Color;

public class PawnMove implements IMove{
    private boolean isFirstMove;
    private Color color;
    public PawnMove() {
        this.isFirstMove = true;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean check(Index source, Index destination) {

        int srcCol = source.getColumn();
        int srcRow = source.getRow();
        int destCol = destination.getColumn();
        int destRow = destination.getRow();

        //boolean roleOne = Math.abs(srcCol-destCol) == 1 && Math.abs(srcRow-destRow) == 1;
        boolean roleTow = (Math.abs(srcCol-destCol)  * Math.abs(srcRow-destRow) == 0)
                && (srcRow - destRow ==1 && Math.abs(destCol - srcCol) ==0);

        return roleTow;

    }
}
