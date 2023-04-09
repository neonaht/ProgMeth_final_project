package application;
// testttt
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import static utilz.Constants.Screen.*;

public class Game extends Canvas implements Runnable {

	private Thread thread;
	private boolean isRunning = false;
	
	public Game() {
		new Window(S_WIDTH_DEFAULT, S_HEIGHT_DEFAULT, TITLE, this);
		start();
		
	}
	
	private synchronized void start() {
		if(isRunning) return ;
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	private synchronized void stop() {
		if(!isRunning) return ;	
		
		try {
			thread.join();
		}
		catch(InterruptedException e) {
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
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	// Updates the game
	private void tick() {
		
	}
	
	// Render the game
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return ;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, S_WIDTH_DEFAULT, S_HEIGHT_DEFAULT);
		
		bs.show();
		g.dispose();
		
	}
	
}
