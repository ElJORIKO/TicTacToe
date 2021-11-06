package main.wins;

import main.player.Player;
import main.start.Main;
import main.table.*;

public class CheckWins {
	General general = new General();
	private char getSymbolAtTable(Position position){
		return general.getCurrentTable()[position.getPosition()[0]][position.getPosition()[1]];
	}
	public boolean ifPlayerWin(Player player, Position position){
		general.setXY(position);
		general.setTABLE();
		return horizontal(player) | vertical(player) | diagonal(player);
	}
	private boolean horizontal(Player player){
		int winCount = 0;
		Position pos = new Position();
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		for (int horizontalLeft = 1; horizontalLeft <= 2; horizontalLeft++){
			pos.setPositionWithoutCorrect(general.getX(), general.getY() - horizontalLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		for (int horizontalRight = 1; horizontalRight <=2; horizontalRight++){
			pos.setPositionWithoutCorrect(general.getX(), general.getY() + horizontalRight);
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
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		for (int verticalUp = 1; verticalUp <= 2; verticalUp++){
			pos.setPositionWithoutCorrect(general.getX() + verticalUp, general.getY());
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		for (int verticalDown = 1; verticalDown <=2; verticalDown++){
			pos.setPositionWithoutCorrect(general.getX() - verticalDown, general.getY());
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
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		for (int downRight = 1; downRight <= 2; downRight++){
			System.out.println("\tx = " + (general.getX() + downRight) + " y = " + (general.getY() - downRight));
			pos.setPositionWithoutCorrect(general.getX() + downRight, general.getY() - downRight);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int downLeft = 1; downLeft <= 2; downLeft++){
			System.out.println("\tx = " + (general.getX() + downLeft) + " y = " + (general.getY() + downLeft));
			pos.setPositionWithoutCorrect(general.getX() + downLeft, general.getY() + downLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int upLeft = 1; upLeft <= 2; upLeft++){
			System.out.println("\tx = " + (general.getX() - upLeft) + " y = " + (general.getY() - upLeft));
			pos.setPositionWithoutCorrect(general.getX() - upLeft, general.getY() - upLeft);
			if (isPosEqualPlayer(pos,player)){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 2) { return true; }
		}
		for (int upRight = 1; upRight <= 2; upRight++){
			System.out.println("\tx = " + (general.getX() - upRight) + " y = " + (general.getY() + upRight));
			pos.setPositionWithoutCorrect(general.getX() - upRight, general.getY() + upRight);
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
		return (isEndOfTable(position)) && general.getSymbolAtTable(position) == player.getPlayer();
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