package utilz;

import logic.base.GameObject;

public class Obj {
	
	public static void follow(GameObject A, GameObject B) {
		boolean setX = false;
		boolean setY = false;
		
		if(Math.abs(A.getxPos() - B.getxPos()) < A.getxVelo()) {
			A.setxVelo(0);
			setX = true;
		}
		if(Math.abs(A.getyPos() - B.getyPos()) < A.getyVelo()) {
			A.setyVelo(0);
			setY = true;
		}
		
		if(!setX)
			if(A.getxPos() < B.getxPos()) A.setxVelo(Math.abs(A.getxVelo()));
			else if(A.getxPos() > B.getxPos()) A.setxVelo(-Math.abs(A.getxVelo()));
		if(!setY)
			if(A.getyPos() < B.getyPos()) A.setyVelo(Math.abs(A.getyVelo()));
			else if(A.getyPos() > B.getyPos()) A.setyVelo(-Math.abs(A.getyVelo()));
		
		return ;
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
	
}
