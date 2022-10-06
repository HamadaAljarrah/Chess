package com.example.chessgame.model.movement;

import com.example.chessgame.model.Index;

public class MoveManager {
    private final IMove moveStrategy;

    public MoveManager(IMove moveStrategy) {
        this.moveStrategy = moveStrategy;
    }


    public boolean check(Index source, Index destination){
        return moveStrategy.check(source, destination);
    }
}
