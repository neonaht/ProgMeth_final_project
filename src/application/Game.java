package application;

// Hello World
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javafx.scene.image.Image;
import logic.base.GameObject;
import logic.base.Handler;
import logic.base.ID;
import logic.base.KeyInput;
import logic.base.Map;
import logic.container.Knife;
import logic.container.PinkBlock;
import logic.person.Criminal;
import logic.person.Player;
import utilz.LoadSave;

import static utilz.Constants.Screen.*;

public class Game extends Canvas implements Runnable {

	public static int WIDTH = S_WIDTH_DEFAULT;
	public static int HEIGHT = S_HEIGHT_DEFAULT;
	private Thread thread;
	private boolean isRunning = false;

	private Handler handler;
	private KeyInput input;
	private Camera cam;

	private Map map = new Map(100, 100, ID.Map);

	public Game() {
		new Window(WIDTH, HEIGHT, TITLE, this);
		initial();

		start();
	}

	private void initial() {
		input = new KeyInput();
		handler = new Handler(new LinkedList<GameObject>(), new Player(500, 520, ID.Player, input));
		cam = new Camera(0, 0, handler);
		addKeyListener(input);

		handler.addObject(new Criminal(700, 720, ID.Criminal, handler, 2.5, 2.5, 100));
	}

	private synchronized void start() {
		if (isRunning)
			return;

		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}

	private synchronized void stop() {
		if (!isRunning)
			return;
		isRunning = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new Game();
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}

	// Updates the game
	private void update() {
		handler.update();
		cam.update();
		return;
	}

	// Render the game
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g2d.translate(-cam.getX(), -cam.getY());

		map.render(g2d);
		handler.render(g2d);

		g2d.translate(cam.getX(), cam.getY());

		bs.show();
		g.dispose();

	}

}
