package main.table;

public class Position {
	private int x;
	private int y;
	public Position (int x, int y){
		this.x = x;
		this.y = y;
	}
	public Position (){}
	public void setPosition(int x, int y){
		this.x = x - 1;
		this.y = y - 1;
	}
	public void setPositionWithoutCorrect(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setPositionWithoutCorrect(Position position){
		int x = position.getPosition()[0];
		int y = position.getPosition()[1];
		this.x = x;
		this.y = y;
	}
	public void setPosition(Position position){
		int x = position.getPosition()[0] - 1;
		int y = position.getPosition()[1] - 1;
		this.x = x;
		this.y = y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void decreaseY(){
		this.y = y - 1;
	}
	public void decreaseX(){
		this.x = x - 1;
	}
	public void decreaseYBy(int decreaseValue){
		this.y = y - decreaseValue;
	}
	public void decreaseXBy(int decreaseValue){
		this.x = x - decreaseValue;
	}
	public void increaseY(){
		this.y = y + 1;
	}
	public void increaseX(){
		this.x = x + 1;
	}
	public void increaseYBy(int increaseValue){
		this.y = y + increaseValue;
	}
	public void increaseXBy(int increaseValue){
		this.x = x + increaseValue;
	}
	public int[] getPosition(){
		return new int[]{x, y};
	}
	public String getAsString(){
		return "X - " + this.x + " Y - " + this.y;
	}
}
