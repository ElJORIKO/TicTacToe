package main.wins;

import main.table.*;

public class General {
	private int x, y;
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	private char[][] TABLE;
	public char[][] getCurrentTable(){
		return this.TABLE;
	}
	public void setXY(Position position){
		this.x = position.getPosition()[0];
		this.y = position.getPosition()[1];
	}
	public void setTABLE(){
		this.TABLE = Table.getTable();
	}
	public char getSymbolAtTable(Position position){
		return TABLE[position.getPosition()[0]][position.getPosition()[1]];
	}
	public Position getPosition(){
		Position pos = new Position();
		pos.setPosition(this.x,this.y);
		return pos;
	}
}