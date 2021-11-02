package main;

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
	public boolean ifPlayerWin(Player player,Position position){
		setXY(position);
		setTABLE();
		return horizontal(player) | vertical(player);
	}
	private boolean horizontal(Player player){
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[x][i] == player.getPlayer()){
				winCount++;
			} else {
				winCount = 0;
			}
			if (winCount == 3){ return true;}
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
			if (winCount == 3){ return true;}
		}
		return false;
	}
}

/*
|p|X|X|
|O|O|X|
| | |O|
 */