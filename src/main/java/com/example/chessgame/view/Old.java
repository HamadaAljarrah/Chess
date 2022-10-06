package com.example.chessgame.view;


import com.example.chessgame.model.Block;
import com.example.chessgame.model.Board;
import com.example.chessgame.model.piece.Color;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Old {

    private static Old ui;
    private final GridPane grid;
    private final Board board;
    private final BorderPane root;


    private Old(Stage stage) {
        this.root = new BorderPane();
        this.grid = new GridPane();
        this.board = new Board();
        root.setCenter(grid);
        stage.setScene(new Scene(root, 800,800));
        stage.setResizable(false);
        stage.show();
    }


    public static Old getInstance(Stage stage) {
        if(ui == null){
            ui =  new Old(stage);
        }
        return ui;
    }
    public void drawBoard() throws FileNotFoundException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Block block = board.getBlocks().get(i).get(j);
                Rectangle blockUI = createBlockUI(block);
                ImageView pieceUI = createPieceUI(block);
                grid.add(blockUI,j,i);
                if(pieceUI != null)
                    grid.add(pieceUI,j,i);
            }
        }
    }
    private Rectangle createBlockUI(Block block){
        var rect = new Rectangle(100, 100);
        if (block.getColor() == Color.BLACK) {
            rect.setFill(javafx.scene.paint.Color.web("#333333"));
        } else {
            rect.setFill(javafx.scene.paint.Color.web("#f5f5f5"));
        }
        if(block.hasPiece()){
            rect.addEventHandler(MouseEvent.MOUSE_CLICKED, MouseHandler.handlePieceClick);
        }
        return rect;
    }
    private ImageView createPieceUI(Block block) throws FileNotFoundException {
        if(!block.hasPiece()) return null;
        ImageView imageView = new ImageView();
        Image pieceImg = new Image(new FileInputStream("./" +block.getPiece().getImagePath()));
        imageView.setImage(pieceImg);
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, MouseHandler.handlePieceClick);
        return imageView;
    }

    private void makeMove(){

    }

    public GridPane getGrid() {
        return grid;
    }

    public Board getBoard() {
        return board;
    }

    public BorderPane getRoot() {
        return root;
    }


    private static class MouseHandler {
        private MouseHandler(){};
        public static EventHandler<MouseEvent> handlePieceClick = mouseEvent -> {
            int column = (int) Math.floor(mouseEvent.getSceneX() / 100);
            int row = (int) Math.floor(mouseEvent.getSceneY() / 100);
            System.out.println(column + " " + row);
        };
    }


}