package main;

import main.player.ComputerPlayer;
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
	public boolean ifPlayerWin(Player player, Position position){
		setXY(position);
		setTABLE();
		return horizontal(player) | vertical(player) | diagonal(player);
	}
	private boolean horizontal(Player player){
		int winCount = 0;
		for (int i = 0; i <= 3; i++){
			Position pos = new Position();
			pos.setPositionWithoutCorrect(x, y);
			for (int horizontalLeft = 1; horizontalLeft <= 2; horizontalLeft++){
				pos.setPositionWithoutCorrect(x - horizontalLeft, y);
				if (!isEndOfTable(pos) & TABLE[x - i][y] == player.getPlayer()){
					winCount++;
				} else {
					winCount = 0;
				}
				if (winCount == 2) { return true; }
			}

			pos.setPositionWithoutCorrect(x, y);
		}
//		for (int i = 0; i < TABLE.length; i++){
//			if (TABLE[x][i] == player.getPlayer()){
//				winCount++;
//			} else {
//				winCount = 0;
//			}
//			if (winCount == 3){
//				System.out.println("Horizontal");
//				return true;}
//		}
		return false;
	}
	private boolean vertical(Player player){
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[i][y] == player.getPlayer()){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 3){
				System.out.println("Vertical");
				return true;}
		}
		return false;
	}

	private boolean diagonal(Player player){
		int winCount = 0, verticalTable = Main.HEIGHT, horizontalTable = Main.LENGTH;
		int xPos = x;
		int yPos = y;
		if (xPos == 0 && yPos == 0){
				while (xPos != verticalTable | yPos != horizontalTable){
					if (TABLE[xPos++][yPos++] == player.getPlayer()){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 3) {return true; }
				}
			}
		xPos = x;
		yPos = y;
		if (xPos == --verticalTable && yPos == --horizontalTable) {
				while (xPos != 0 | yPos != 0){
					if (TABLE[xPos--][yPos--] == player.getPlayer()){
						winCount++;
					} else {
						winCount =0;
					}
					if (winCount == 3) {return true; }
				}
			}
		xPos = x;
		yPos = y;
		if (xPos == 0 & yPos == --horizontalTable){
			System.out.println("x - 0 y - 3");
			while (xPos >= verticalTable && yPos >= 0) {
					if (TABLE[xPos++][yPos--] == player.getPlayer()) {
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 3) {return true; }
				}
			}
		xPos = x;
		yPos = y;
		if (xPos <= --horizontalTable && yPos == 0){
			System.out.println("x - 3 y - 0");
				while (xPos >= 0 & yPos <= horizontalTable){
					if (TABLE[xPos--][yPos++] == player.getPlayer()){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 3) {return true; }
				}
			}
		return false;
	}

	private boolean isEndOfTable(Position position){
		int x = position.getPosition()[0];
		int y = position.getPosition()[1];
		if (x < 0 & y < 0){
			return false;
		} else if (x > Main.HEIGHT & y > Main.LENGTH){
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