package com.example.chessgame.model.piece;


import com.example.chessgame.model.Index;
import com.example.chessgame.model.movement.IMove;
import com.example.chessgame.model.movement.MoveManager;

public abstract class Piece {
    private final Color color;
    private final MoveManager moveManager;
    private String imagePath;


    public Piece(Color color, IMove moveStrategy) {
        this.color = color;
        this.moveManager = new MoveManager(moveStrategy);

    }

    public Color getColor() {
        return color;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }



    public boolean isLegalMove(Index source, Index destination){
        return this.moveManager.check(source, destination);
    }


}
