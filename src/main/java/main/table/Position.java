package main.table;

public class Position {
	private int x;
	private int y;
	public void setPosition(int x, int y){
		this.x = x - 1;
		this.y = y - 1;
	}
	public void setPositionWithoutCorrect(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int[] getPosition(){
		return new int[]{x, y};
	}
}
