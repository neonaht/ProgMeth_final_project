package utilz;

import logic.base.GameObject;

public class Obj {
	
	public static void getClose(GameObject A, GameObject B) {
		boolean setX = false;
		boolean setY = false;
		
		if(Math.abs(A.getxPos() - B.getxPos()) < A.getxVelo()) {
			A.setxPos(B.getxPos());
			setX = true;
		}
		if(Math.abs(A.getyPos() - B.getyPos()) < A.getyVelo()) {
			A.setyPos(B.getyPos());
			setY = true;
		}
		
		if(!setX)
			if(A.getxPos() < B.getxPos()) A.setxPos(A.getxPos() + Math.abs(A.getxVelo()));
			else if(A.getxPos() > B.getxPos()) A.setxPos(A.getxPos() - Math.abs(A.getxVelo()));
		if(!setY)
			if(A.getyPos() < B.getyPos()) A.setyPos(A.getyPos() + Math.abs(A.getyVelo()));
			else if(A.getyPos() > B.getyPos()) A.setyPos(A.getyPos() - Math.abs(A.getyVelo()));
		
		return ;
	}
	
	public static void follow(GameObject A, GameObject B) {
		// More Function
		getClose(A, B);
	}
	
	public static double distance(GameObject A, GameObject B) {
		double disX = disX(A, B);
		double disY = disY(A, B);
		return Math.sqrt(disX * disX + disY * disY);
	}
	
	public static double disX(GameObject A, GameObject B) {
		return Math.abs(A.getxPos() - B.getxPos());
	}
	
	public static double disY(GameObject A, GameObject B) {
		return Math.abs(A.getyPos() - B.getyPos());
	}
	
	public static String getDirection(GameObject A, GameObject B) {
		if(A.getxPos() - B.getxPos() > 0) {
			if(disX(A, B) >= disY(A, B)) return "L";
			if(A.getyPos() - B.getyPos() > 0) return "U";
			return "D";
		}
		if(disX(A, B) >= disY(A, B)) return "R";
		if(A.getyPos() - B.getyPos() > 0) return "U";
		return "D";
	}
	
}
