package de.hszg.datenpannen;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{


    public static void main (String...args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Datenpannen-Kosten-Kalkulator");

        Group main = new Group();

        Label helloWorld = new Label("Hello World");

        main.getChildren().add(helloWorld);


        Scene scene = new Scene(main, 400,300, Color.WHITESMOKE);

        stage.setScene(scene);

        stage.show();
    }
}
