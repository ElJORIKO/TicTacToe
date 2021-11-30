package main.wins;

import main.player.Player;
import main.start.Main;
import main.table.Position;

public class Win {
	General general = new General();
	private int winCount = 0;
	private Player actualPlayer;
	public boolean isVin(Position position, Player player){
		general.setXY(position);
		general.setTABLE();
		actualPlayer = player;
		return isVinAnyVector();
	}
	private boolean isVinAnyVector(){
		return  horizontal("left") |
				horizontal("right") |
				diagonal("downRight") |
				diagonal("downLeft") |
				diagonal("upRight") |
				diagonal("upLeft") |
				vertical("up") |
				vertical("down");
	}
	private boolean horizontal(String vector){
		Position pos = new Position();
		pos.setPositionWithoutCorrect(general.getX(), general.getY());
		switch (vector.toUpperCase()){
			case ("LEFT"):
				for (int horizontalLeft = 1; horizontalLeft <= 2; horizontalLeft++){
					pos.setY(general.getY() - horizontalLeft);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
			case ("RIGHT"):
				for (int horizontalRight = 1; horizontalRight <=2; horizontalRight++){
					pos.setY(general.getY() + horizontalRight);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
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
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
			case ("DOWN"):
				for (int verticalUp = 1; verticalUp <= 2; verticalUp++){
					pos.setX(general.getX() - verticalUp);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
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
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
			case ("DOWNLEFT"):
				for (int downLeft = 1; downLeft <= 2; downLeft++){
					pos.setX(general.getX() + downLeft);
					pos.setY(general.getY() + downLeft);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}

			case ("UPLEFT"):
				for (int upLeft = 1; upLeft <= 2; upLeft++){
					pos.setX(general.getX() - upLeft);
					pos.setY(general.getY() - upLeft);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
			case ("UPRIGHT"):
				for (int upRight = 1; upRight <= 2; upRight++){
					pos.setY(general.getY() + upRight);
					pos.setX(general.getX() - upRight);
					if (isPosEqualPlayer(pos,actualPlayer)){
						winCount++;
					} else {
						winCount = 0;
					}
					if (winCount == 2) { return true; }
				}
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
