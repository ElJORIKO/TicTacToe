package main.wins;

import main.player.Player;
import main.start.Main;
import main.table.Position;

public class Win {
	General general = new General();
	private int winCount = 0;
	private void winCountAdd(){
		winCount++;
	}
	private boolean isWinEqualTwo(){
		return winCount == 2;
	}
	private void resetWinCount(){
		winCount = 0;
	}
	private Player actualPlayer;
	public boolean isWin(Player player, Position position){
		general.setXY(position);
		general.setTABLE();
		actualPlayer = player;
		return isVinAnyVector();
	}
	public boolean isWin(Player player, Position position, String vector){
		general.setXY(position);
		general.setTABLE();
		actualPlayer = player;
		switch (vector.toUpperCase()){
			case ("LEFT"):
				return horizontal("left");
			case ("RIGHT"):
				return horizontal("right");
			case ("DOWNRIGHT"):
				return diagonal("downRight");
			case ("DOWNLEFT"):
				return diagonal("downLeft");
			case ("UPRIGHT"):
				return diagonal("upRight");
			case ("UPLEFT"):
				return diagonal("upLeft");
			case ("UP"):
				return vertical("up");
			case ("DOWN"):
				return vertical("down");
			default:
				return false;
		}
	}
	private boolean isVinAnyVector(){
		return  horizontal("left") |
				horizontal("right") |
				horizontal("any") |
				diagonal("downRight") |
				diagonal("downLeft") |
				diagonal("upRight") |
				diagonal("upLeft") |
				diagonal("any") |
				vertical("up") |
				vertical("down") |
				vertical("any");
	}
	private boolean horizontal(String vector){
		Position pos = new Position();
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		switch (vector.toUpperCase()){
			case ("LEFT"):
				for (int horizontalLeft = 1; horizontalLeft <= 2; horizontalLeft++){
					pos.setY(general.getY() - horizontalLeft);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("RIGHT"):
				for (int horizontalRight = 1; horizontalRight <=2; horizontalRight++){
					pos.setY(general.getY() + horizontalRight);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("ANY"):
				pos.setY(general.getY() + 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				pos.setY(general.getY() - 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				if (isWinEqualTwo()) {
					return true;
				} else {
					resetWinCount();
				}
				break;
		}
		return false;
	}
	private boolean vertical(String vector){
		Position pos = new Position();
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		switch (vector.toUpperCase()){
			case ("UP"):
				for (int verticalUp = 1; verticalUp <= 2; verticalUp++){
					pos.setX(general.getX() + verticalUp);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("DOWN"):
				for (int verticalUp = 1; verticalUp <= 2; verticalUp++){
					pos.setX(general.getX() - verticalUp);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("ANY"):
				pos.setX(general.getX() - 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				pos.setX(general.getX() + 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				if (isWinEqualTwo()) {
					return true;
				} else {
					resetWinCount();
				}
		}
		return false;
	}
	private boolean diagonal(String vector){
		Position pos = new Position();
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		switch (vector.toUpperCase()){
			case ("DOWNRIGHT"):
				for (int downRight = 1; downRight <= 2; downRight++){
					pos.setX(general.getX() + downRight);
					pos.setY(general.getY() - downRight);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("DOWNLEFT"):
				for (int downLeft = 1; downLeft <= 2; downLeft++){
					pos.setX(general.getX() + downLeft);
					pos.setY(general.getY() + downLeft);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}

				break;
			case ("UPLEFT"):
				for (int upLeft = 1; upLeft <= 2; upLeft++){
					pos.setX(general.getX() - upLeft);
					pos.setY(general.getY() - upLeft);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("UPRIGHT"):
				for (int upRight = 1; upRight <= 2; upRight++){
					pos.setY(general.getY() + upRight);
					pos.setX(general.getX() - upRight);
					if (isPosEqualPlayer(pos)){
						winCountAdd();
					} else {
						resetWinCount();
					}
					if (isWinEqualTwo()) { return true; }
				}
				break;
			case ("ANY"):
				pos.setX(general.getX() + 1);
				pos.setY(general.getY() + 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				pos.setX(general.getX() - 1);
				pos.setY(general.getY() - 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
					if (isWinEqualTwo()) {
						return true;
					} else {
						resetWinCount();
					}
				}
				pos.setX(general.getX() + 1);
				pos.setY(general.getY() - 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
				}
				pos.setX(general.getX() - 1);
				pos.setY(general.getY() - 1);
				if (isPosEqualPlayer(pos)){
					winCountAdd();
					if (isWinEqualTwo()){
						return true;
					} else {
						resetWinCount();
					}
				}
		}
		return false;
	}
	private boolean isPosEqualPlayer(Position position){
		return (isEndOfTable(position)) && general.getSymbolAtTable(position) == actualPlayer.getPlayer();
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
