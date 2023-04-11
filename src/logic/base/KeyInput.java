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
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = true;
		
//		switch(keyInt) {
//			case KeyEvent.VK_W : key.W = true; break;
//			case KeyEvent.VK_A : key.A = true; break;
//			case KeyEvent.VK_S : key.S = true; break;
//			case KeyEvent.VK_D : key.D = true; break;
//			case KeyEvent.VK_SHIFT : key.SHIFT = true; break;
//			default : break;
//		}
		
	}
	
	public void keyReleased(KeyEvent x) {
		int keyInt = x.getKeyCode();
		
		if(keyInt == KeyEvent.VK_W) key.W = false;
		if(keyInt == KeyEvent.VK_A) key.A = false;
		if(keyInt == KeyEvent.VK_S) key.S = false;
		if(keyInt == KeyEvent.VK_D) key.D = false;
		if(keyInt == KeyEvent.VK_SHIFT) key.SHIFT = false;
		
//		switch(keyInt) {
//			case KeyEvent.VK_W : key.W = false; break;
//			case KeyEvent.VK_A : key.A = false; break;
//			case KeyEvent.VK_S : key.S = false; break;
//			case KeyEvent.VK_D : key.D = false; break;
//			case KeyEvent.VK_SHIFT : key.SHIFT = false; break;
//			default : break;
//		}
		
	}
	
}
