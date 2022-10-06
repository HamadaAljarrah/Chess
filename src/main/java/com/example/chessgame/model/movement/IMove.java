package com.example.chessgame.model.movement;

import com.example.chessgame.model.Block;
import com.example.chessgame.model.Index;

public interface IMove {
    boolean check(Index source, Index destination);
}
