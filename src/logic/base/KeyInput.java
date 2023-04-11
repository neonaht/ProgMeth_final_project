package logic.base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public Keys key = new Keys();
	
	public void keyPressed(KeyEvent x) {
		int keyInt = x.getKeyCode();
		
		if(keyInt == KeyEvent.VK_W) key.W = true;
		if(keyInt == KeyEvent.VK_A) key.A = true;
		if(keyInt == KeyEvent.VK_S) key.S = true;
		if(keyInt == KeyEvent.VK_D) key.D = true;
		if(keyInt == KeyEvent.VK_LEFT) key.LEFT = true;
		if(keyInt == KeyEvent.VK_RIGHT) key.RIGHT = true;
		if(keyInt == KeyEvent.VK_UP) key.UP = true;
		if(keyInt == KeyEvent.VK_DOWN) key.DOWN = true;
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = true;
		if(keyInt == KeyEvent.VK_SPACE) key.SPACE = true;
		if(keyInt == KeyEvent.VK_0) key.ZERO = true;
		if(keyInt == KeyEvent.VK_1) key.ONE = true;
		if(keyInt == KeyEvent.VK_2) key.TWO = true;
		if(keyInt == KeyEvent.VK_3) key.THREE = true;
		if(keyInt == KeyEvent.VK_4) key.FOUR = true;
		if(keyInt == KeyEvent.VK_5) key.FIVE = true;
		if(keyInt == KeyEvent.VK_6) key.SIX = true;
		if(keyInt == KeyEvent.VK_7) key.SEVEN = true;
		if(keyInt == KeyEvent.VK_8) key.EIGHT = true;
		if(keyInt == KeyEvent.VK_9) key.NINE = true;
		
	}
	
	public void keyReleased(KeyEvent x) {
		int keyInt = x.getKeyCode();
		
		if(keyInt == KeyEvent.VK_W) key.W = false;
		if(keyInt == KeyEvent.VK_A) key.A = false;
		if(keyInt == KeyEvent.VK_S) key.S = false;
		if(keyInt == KeyEvent.VK_D) key.D = false;
		if(keyInt == KeyEvent.VK_LEFT) key.LEFT = false;
		if(keyInt == KeyEvent.VK_RIGHT) key.RIGHT = false;
		if(keyInt == KeyEvent.VK_UP) key.UP = false;
		if(keyInt == KeyEvent.VK_DOWN) key.DOWN = false;
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = false;
		if(keyInt == KeyEvent.VK_SPACE) key.SPACE = false;
		if(keyInt == KeyEvent.VK_0) key.ZERO = false;
		if(keyInt == KeyEvent.VK_1) key.ONE = false;
		if(keyInt == KeyEvent.VK_2) key.TWO = false;
		if(keyInt == KeyEvent.VK_3) key.THREE = false;
		if(keyInt == KeyEvent.VK_4) key.FOUR = false;
		if(keyInt == KeyEvent.VK_5) key.FIVE = false;
		if(keyInt == KeyEvent.VK_6) key.SIX = false;
		if(keyInt == KeyEvent.VK_7) key.SEVEN = false;
		if(keyInt == KeyEvent.VK_8) key.EIGHT = false;
		if(keyInt == KeyEvent.VK_9) key.NINE = false;
		
	}
	
}
