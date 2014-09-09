package de.hszg.datenpannen;

import de.hszg.datenpannen.main.view.main.MainView;
import de.hszg.datenpannen.utils.ResourceBundleWrapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * Einstiegspunkt in die Applikation.
 */
public class Main extends Application {

    public static void main(String... args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ResourceBundleWrapper resourceBundleWrapper = new ResourceBundleWrapper();
        ResourceBundle bundle = resourceBundleWrapper.getResourceBundleFor(MainView.class);

        stage.setTitle(bundle.getString("main.title"));

        MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getView());

        stage.setScene(scene);
        stage.show();
    }
}
