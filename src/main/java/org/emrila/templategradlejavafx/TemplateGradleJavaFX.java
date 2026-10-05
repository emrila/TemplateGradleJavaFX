/**
 *
 */
package org.emrila.templategradlejavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.emrila.templategradlejavafx.sample.SimpleCounter;

public class TemplateGradleJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(SimpleCounter.build());

        primaryStage.setTitle("Template");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setOnCloseRequest(_ ->  Platform.exit());
        primaryStage.show();
    }
}
