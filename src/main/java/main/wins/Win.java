package main.wins;

import main.player.Player;
import main.start.Main;
import main.table.Position;

public class Win {
	General general = new General();
	private Player actualPlayer;
	public boolean isWin(Player player, Position position){
		general.setXY(position);
		general.setTABLE();
		actualPlayer = player;
		return isWinAnyVector();
	}
	private boolean isWinAnyVector(){
		return  horizontal() |
				diagonal() |
				vertical();
	}
	private boolean horizontal(){
		int x = general.getX();
		int y = general.getY();
		if (isPosEqualPlayer((new Position(x, y - 2))) &&
			isPosEqualPlayer((new Position(x, y - 1)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x, y + 2))) &&
				   isPosEqualPlayer((new Position(x, y + 1)))){
			return true;
		} else
			return isPosEqualPlayer((new Position(x, y - 1))) &&
					isPosEqualPlayer((new Position(x, y + 1)));
	}
	private boolean vertical(){
		int x = general.getX();
		int y = general.getY();
		if (isPosEqualPlayer((new Position(x - 2, y))) &&
			isPosEqualPlayer((new Position(x - 1, y)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x + 2, y))) &&
					isPosEqualPlayer((new Position(x + 1, y)))){
			return true;
		} else
			return isPosEqualPlayer((new Position(x + 1, y))) &&
					isPosEqualPlayer((new Position(x - 1, y)));
	}
	private boolean diagonal(){
		int x = general.getX();
		int y = general.getY();
		if (isPosEqualPlayer((new Position(x - 2, y - 2))) &&
			isPosEqualPlayer((new Position(x - 1, y - 1)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x + 2, y - 2))) &&
					isPosEqualPlayer((new Position(x + 1, y - 1)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x + 2, y + 2))) &&
					isPosEqualPlayer((new Position(x + 1, y + 1)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x - 2, y + 2))) &&
				isPosEqualPlayer(new Position(x - 1, y + 1))) {
			return true;
		} else if (isPosEqualPlayer((new Position(x - 2, y - 2))) &&
					isPosEqualPlayer((new Position(x - 1, y - 1)))){
			return true;
		} else if (isPosEqualPlayer((new Position(x - 1,y - 1))) &&
					isPosEqualPlayer((new Position(x + 1, y + 1)))){
			return true;
		} else
			return isPosEqualPlayer((new Position(x + 1, y - 1))) &&
					isPosEqualPlayer((new Position(x - 1, y + 1)));
	}
	public boolean isPosEqualPlayer(Position position){
		return (isEndOfTable(position)) && general.getSymbolAtTable(position) == actualPlayer.getPlayer();
	}
	public boolean isEndOfTable(Position pos){
		return !( (pos.getX() < 0 | pos.getY() < 0) |
				(pos.getX() > Main.HEIGHT - 1 | pos.getY() > Main.LENGTH - 1) );
	}
}
