package application;

import java.util.LinkedList;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.base.KeyInput;
import logic.base.Map;
import logic.container.Knife;
import logic.container.PinkBlock;
import logic.person.Criminal;
import logic.person.Player;
import tile.TileManager;
import utilz.LoadSave;

import static utilz.Constants.Screen.*;

public class Game extends Application {

	public static final int WIDTH = S_WIDTH_DEFAULT;
	public static final int HEIGHT = S_HEIGHT_DEFAULT;
	public static final int FPS = 600;
	
	private long lastUpdateTime;
	private Thread thread;
	private boolean isRunning = false;

	private Handler handler;
	private KeyInput input = new KeyInput();
	private Camera cam;
	
	public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 110;
    public final int maxScreenRow = 60;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    TileManager tileM = new TileManager(this);

	private Map map = new Map(100, 100, ID.Map);

	private void initial() {
		handler = new Handler();
		cam = new Camera(0, 0, handler);

		handler.Player = new Player(500, 480, ID.Player, handler, input);
		handler.addObject(new Criminal(700, 720, ID.Criminal, handler, 2, 2, 100));
	}

	public void start(Stage stage) throws Exception {
		Canvas canvas = new Canvas(960, 640);
		Scene scene = new Scene(new StackPane(canvas));
		GraphicsContext gc = canvas.getGraphicsContext2D();
//		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> run(gc)));
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
		run(gc);
		stage.setScene(scene);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			input.keyPressed(key);
		});
		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			input.keyReleased(key);
		});
		stage.setTitle("Ship Hide");
		initial();
		stage.show();
	}
	
	private void run(GraphicsContext gc) {
		AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentUpdateTime) {
                // Calculate the time elapsed since the last update
                long delta = currentUpdateTime - lastUpdateTime;

                // Update the lastUpdateTime
                lastUpdateTime = currentUpdateTime;

                // Calculate the frames per second (fps)
                double fps = 1_000_000_000.0 / delta;

                // Check if the elapsed time is greater than or equal to the target time per frame
                if (delta >= 1_000_000_000 / FPS) {
                    update();
                }
                render(gc);
                return ;
            }
        };

        // Start the AnimationTimer
        timer.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	// Updates the game
	private void update() {
		handler.update();
		cam.update();
		return;
	}

	// Render the game
	private void render(GraphicsContext gc) {

		gc.setFill(Color.CYAN);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
//
		gc.translate(-cam.getX(), -cam.getY());

		map.render(gc);
//		tileM.draw(g2d);
		
		handler.render(gc);
//
		gc.translate(cam.getX(), cam.getY());
//
//		bs.show();
//		g.dispose();

	}

}
