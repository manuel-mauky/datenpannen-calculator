package de.hszg.datenpannen;

import com.airhacks.afterburner.injection.InjectionProvider;
import de.hszg.datenpannen.view.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Einstiegspunkt in die Applikation.
 */
public class Main extends Application {

    public static void main(String... args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Datenpannen-Kosten-Kalkulator");

        MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getView());

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        InjectionProvider.forgetAll();
    }
}
