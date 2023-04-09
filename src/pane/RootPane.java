package pane;

import component.Menu;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
    private static DisplayPane displayPane;
    private Menu menu;

    public RootPane() {
    	displayPane = new DisplayPane();
    	
    	this.setCenter(displayPane);
    	
    }

    public static DisplayPane getDisplayPane() {
        return displayPane;
    }

}
