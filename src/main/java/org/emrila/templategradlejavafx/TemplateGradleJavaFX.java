/**
 *
 */
package org.emrila.templategradlejavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.kordamp.ikonli.evaicons.Evaicons;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.concurrent.atomic.AtomicInteger;

public class TemplateGradleJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        AtomicInteger counter = new AtomicInteger(0);
        Label counterLabel = new Label(String.valueOf(counter.get()));
        Pane pane = buildCounterControls(counter, counterLabel);

        BorderPane root = new BorderPane();
        root.setCenter(pane);

        primaryStage.setTitle("Template");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setOnCloseRequest(_ ->  Platform.exit());
        primaryStage.show();
    }

    private Pane buildCounterControls(AtomicInteger counter, Label label) {
        Button addButton = new Button("", FontIcon.of(Evaicons.PLUS));
        addButton.setOnAction(e -> label.setText(String.valueOf(counter.incrementAndGet())));

        Button substractButton = new Button("", FontIcon.of(Evaicons.MINUS));
        substractButton.setOnAction(e -> label.setText(String.valueOf(counter.decrementAndGet())));

        HBox hBox = new HBox(substractButton, label, addButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(16);
        HBox.setHgrow(hBox, Priority.ALWAYS);

        return hBox;
    }
}
