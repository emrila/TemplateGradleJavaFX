/**
 *
 */
package org.emrila.templategradlejavafx.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.evaicons.Evaicons;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter {

    public static Pane build() {
        AtomicInteger counter = new AtomicInteger(0);
        Label label = new Label(String.valueOf(counter.get()));

        Button incrementButton = buildButton(
                toFontIcon(Evaicons.PLUS, "increment"),
                ignored -> label.setText(String.valueOf(counter.incrementAndGet()))
        );

        Button decrementButton = buildButton(
                toFontIcon(Evaicons.MINUS, "decrement"),
                ignored -> label.setText(String.valueOf(counter.decrementAndGet()))
        );

        HBox hBox = new HBox(decrementButton, label, incrementButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(16);
        HBox.setHgrow(label, Priority.ALWAYS);

        return hBox;
    }

    private static FontIcon toFontIcon(Ikon ikon, String id){
        FontIcon fontIcon = FontIcon.of(ikon);
        fontIcon.setId(id);
        return fontIcon;
    }

    private static Button buildButton(Node graphic, EventHandler<ActionEvent> actionHandler) {
        Button button = new Button("", graphic);
        button.setOnAction(actionHandler);
        button.setId("button-" + graphic.getId());
        return button;
    }

}
