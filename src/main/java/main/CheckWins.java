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
	public boolean ifPlayerWin(ComputerPlayer player, Position position){
		setXY(position);
		setTABLE();
		return horizontal(player) | vertical(player) | diagonal(player);
	}
	private boolean horizontal(Player player){
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[x][i] == player.getPlayer()){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 3){
				System.out.println("Horizontal");
				return true;}
		}
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
	private boolean horizontal(ComputerPlayer player){
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if ((TABLE[x][i]) == player.getPlayer()){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 3){
				System.out.println("Horizontal");
				return true;
			}
		}
		return false;
	}
	private boolean vertical(ComputerPlayer player){
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[i][y] == player.getPlayer()){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 3){
				System.out.println("Vertical ");
				return true;
			}
		}
		return false;
	}

	private boolean diagonal(ComputerPlayer player){
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
}

/*
|X|X|X|
|O|P|X|
| | |O|
 */