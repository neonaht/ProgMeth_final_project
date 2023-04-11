package utilz;

import logic.base.Keys;

public class Checker {
	
	public static String KeyDirection(Keys key) {
		if(key.LEFT) return "LEFT";
		if(key.RIGHT) return "RIGHT";
		if(key.UP) return "UP";
		if(key.DOWN) return "DOWN";
		if(key.A) return "L"; 
		if(key.D) return "R"; 
		if(key.W) return "U"; 
		if(key.S) return "D";
		return "Z";
	}
	public static String KeyWalkDirection(Keys key) {
		if(key.A) return "L"; 
		if(key.D) return "R"; 
		if(key.W) return "U"; 
		if(key.S) return "D";
		return "Z";
	}
	
	public static String KeyHitDirection(Keys key) {
		if(key.LEFT) return "LEFT";
		if(key.RIGHT) return "RIGHT";
		if(key.UP) return "UP";
		if(key.DOWN) return "DOWN";
		return "Z";
	}
	
	public static boolean UnpressedWalkDirection(Keys key) {
		return !(key.W || key.A || key.S || key.D);
	}
	
	public static boolean UnpressedHitDirection(Keys key) {
		return !(key.LEFT || key.RIGHT || key.UP || key.DOWN);
	}
	
	public static String GetDirectionByVelo(double xVelo, double yVelo) {
		if(xVelo < 0) return "L";
		if(xVelo > 0) return "R";
		if(yVelo < 0) return "U";
		if(yVelo > 0) return "D";
		return "Z";
	}
	
}
