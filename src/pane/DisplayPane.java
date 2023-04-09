package pane;

import component.Menu;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DisplayPane extends VBox {
    
    public DisplayPane() {
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(20));
        setSpacing(10);
        Menu menu = new Menu();
        getChildren().add(menu);
    }
}
