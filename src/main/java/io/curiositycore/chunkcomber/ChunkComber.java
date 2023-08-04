package io.curiositycore.chunkcomber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChunkComber extends Application {
    private static Stage mainWindowStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChunkComber.class.getResource("ComberMainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 636, 452);
        stage.setTitle("ChunkComber");
        stage.setScene(scene);
        stage.show();

    }
     public static Stage getMainWindowStage(){
        if(mainWindowStage == null){
            return null;
        }
        return mainWindowStage;
    }

    public static void main(String[] args) {
        launch();
    }
}