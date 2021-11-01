package main;

public class Position {
	private int x;
	private int y;
	public void setPosition(int x, int y){
		this.x = x - 1;
		this.y = y - 1;
	}
	public int[] getPosition(){
		return new int[]{x, y};
	}
}
