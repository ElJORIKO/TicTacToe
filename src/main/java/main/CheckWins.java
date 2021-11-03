package main;

import main.player.Player;
import main.start.Main;
import main.table.Position;
import main.table.Table;

public class CheckWins {
	private int x, y;
	private int getX(){
		return this.x;
	}
	private int getY(){
		return this.y;
	}
	private char[][] TABLE;
	private void setXY(Position position){
		this.x = position.getPosition()[0];
		this.y = position.getPosition()[1];
	}
	private void setTABLE(){
		this.TABLE = Table.getTable();
	}
	private char getSymbolAtTable(Position position){
		return TABLE[position.getPosition()[0]][position.getPosition()[1]];
	}
	public boolean ifPlayerWin(Player player, Position position){
		setXY(position);
		setTABLE();
		return horizontal(player) | vertical(player) | diagonal(player);
	}
	private boolean horizontal(Player player){
		int winCount = 0;
		Position pos = new Position();
		pos.setPositionWithoutCorrect(x, y);
		for (int horizontalLeft = 1; horizontalLeft <= 2; horizontalLeft++){
			pos.setPositionWithoutCorrect(x, y - horizontalLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		pos.setPositionWithoutCorrect(x, y);
		for (int horizontalRight = 1; horizontalRight <=2; horizontalRight++){
			pos.setPositionWithoutCorrect(x, y + horizontalRight);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		return false;
	}
	private boolean vertical(Player player){
		int winCount = 0;
		Position pos = new Position();
		pos.setPositionWithoutCorrect(x, y);
		for (int verticalUp = 1; verticalUp <= 2; verticalUp++){
			pos.setPositionWithoutCorrect(x + verticalUp, y);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		pos.setPositionWithoutCorrect(x, y);
		for (int verticalDown = 1; verticalDown <=2; verticalDown++){
			pos.setPositionWithoutCorrect(x - verticalDown, y);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		return false;
	}

	private boolean diagonal(Player player){
		int winCount = 0;
		Position pos = new Position();
		pos.setPositionWithoutCorrect(x,y);
		for (int downRight = 1; downRight <= 2; downRight++){
			System.out.println("\tx = " + (x + downRight) + " y = " + (y - downRight));
			pos.setPositionWithoutCorrect(x + downRight, y - downRight);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int downLeft = 1; downLeft <= 2; downLeft++){
			System.out.println("\tx = " + (x + downLeft) + " y = " + (y + downLeft));
			pos.setPositionWithoutCorrect(x + downLeft, y + downLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int upLeft = 1; upLeft <= 2; upLeft++){
			System.out.println("\tx = " + (x - upLeft) + " y = " + (y - upLeft));
			pos.setPositionWithoutCorrect(x - upLeft, y - upLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int upRight = 1; upRight <= 2; upRight++){
			System.out.println("\tx = " + (x - upRight) + " y = " + (y + upRight));
			pos.setPositionWithoutCorrect(x - upRight, y + upRight);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		return false;
	}

	private boolean isPosEqualPlayer(Position position, Player player){
		return (isEndOfTable(position)) && getSymbolAtTable(position) == player.getPlayer();
	}
	private boolean isEndOfTable(Position position){
		int x = position.getPosition()[0];
		int y = position.getPosition()[1];
		if (x < 0 | y < 0){
			return false;
		} else if (x > Main.HEIGHT - 1 | y > Main.LENGTH - 1){
			return false;
		} else {
			return true;
		}
	}
}

/*
|X|X|X|
|O|P|X|
| | |O|
 */