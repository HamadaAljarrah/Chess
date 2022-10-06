package com.example.chessgame.controller;


import com.example.chessgame.model.Block;
import com.example.chessgame.model.Game;
import com.example.chessgame.model.Index;
import com.example.chessgame.view.GameUI;
import javafx.scene.input.MouseEvent;

public class Controller {
    private Game model;
    private GameUI view;

    public Controller(Game model, GameUI view) {
        this.model = model;
        this.view = view;
    }
    public void handleClickOnPieceEvent(MouseEvent mouseEvent) {
        int column = (int) Math.floor(mouseEvent.getSceneX() / 100);
        int row = (int) Math.floor(mouseEvent.getSceneY() / 100);
        model.movePiece(new Index(row,column));
        view.drawBoard();
    }
}
