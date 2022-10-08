package com.example.chessgame.view;

import com.example.chessgame.controller.Controller;
import com.example.chessgame.model.Block;
import com.example.chessgame.model.Game;
import com.example.chessgame.model.piece.Color;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameUI extends GridPane {
    private final Game model;
    private final Controller controller;
    private final EventHandlers eventHandler;

    public GameUI(Game model) {
        this.model = model;
        this.controller = new Controller(model, this);
        this.eventHandler = new EventHandlers(controller);
        drawBoard();

    }



    public void drawBoard() {
        try {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Block block = model.getBlocks().get(i).get(j);
                    Rectangle blockUI = createBlockUI(block);
                    ImageView pieceUI = createPieceUI(block);
                    this.add(blockUI,j,i);
                    if(pieceUI != null)
                        this.add(pieceUI,j,i);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Image file was not found drawBoard");
        }

    }


    private Rectangle createBlockUI(Block block){
        var rect = new Rectangle(100, 100);
        if (block.getColor() == Color.BLACK) {
            rect.setFill(javafx.scene.paint.Color.web("#333333"));
        }
        else {
            rect.setFill(javafx.scene.paint.Color.web("#f5f5f5"));
        }

        rect.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler.clickOnPieceHandler);
        return rect;
    }
    private ImageView createPieceUI(Block block) throws FileNotFoundException {
        if(!block.hasPiece()) return null;
        ImageView imageView = null;

        try {
            Image pieceImg = new Image(new FileInputStream("./" +block.getPiece().getImagePath()));
            imageView = new ImageView();
            imageView.setImage(pieceImg);
        }
        catch (FileNotFoundException e){
            System.out.println("Image file was not found drawBoard");
        }

        if(imageView != null )imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler.clickOnPieceHandler);
        return imageView;
    }


    private class EventHandlers{
        private final Controller controller;

        public EventHandlers(Controller controller) {
            this.controller = controller;
        }

        public EventHandler<MouseEvent> clickOnPieceHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.handleClickOnPieceEvent(mouseEvent);
            }
        };




    }
}
