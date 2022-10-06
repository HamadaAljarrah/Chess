package com.example.chessgame;



import com.example.chessgame.model.Game;
//import com.example.chessgame.view.GameUI;
import com.example.chessgame.view.GameUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Game model = new Game();
        GameUI view = new GameUI(model);
        root.getChildren().add(view);
        stage.setTitle("Chess Game");
        stage.setScene(new Scene(root,800,800));
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String args[]){
        launch();
    }


}