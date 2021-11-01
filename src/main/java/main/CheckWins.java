package main;

public class CheckWins {
	public boolean ifPlayerWin(Player player,Position position){
		int x = position.getPosition()[0];
		int y = position.getPosition()[1];
		char[][] TABLE = Table.getTable();
		int winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[x][i] == player.getPlayer()){
				winCount++;
			}
			if (winCount == 3){ return true;}
		}
		winCount = 0;
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[i][y] == player.getPlayer()){
				winCount++;
			}
		}
		System.out.println(winCount);
		return winCount == 3;
	}
}
/*
|p|X|X|
|O|O|X|
| | |O|
 */