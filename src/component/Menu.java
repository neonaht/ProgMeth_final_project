package component;

import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utilz.LoadSave;

public class Menu extends StackPane {
	
	private Rectangle bounds;
	
	public Menu() {
		bounds = new Rectangle();
		bounds.setWidth(120);
		bounds.setHeight(50);  
		bounds.setFill(Color.LIGHTGRAY);
		
		Image img = new Image("D:\\GitHub\\ProgMeth\\ShipHide\\res\\button_test.jpg");
		bounds.setFill(new ImagePattern(img));
		
		Text text = new Text();
		text.setText("Play");
		text.setFont(new Font(25));

		setCursor(Cursor.HAND);
//		setOnMouseClicked(new EventHandler<MouseEvent>() {
//    		public void handle(MouseEvent arg) {
//    			RootPane.getNavigationPane().setCurrentPage(PageNumber);
//    		}
//    	});
		getChildren().add(bounds);
		getChildren().add(text);
	}
}
