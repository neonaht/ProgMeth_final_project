package utilz;

import logic.base.Keys;

public class Checker {
	public static String KeyDirection(Keys key) {
		if(key.A) return "L"; 
		if(key.D) return "R"; 
		if(key.W) return "U"; 
		if(key.S) return "D";
		return "Z";
	}
}
