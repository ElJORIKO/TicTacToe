package main.start;

import main.*;

public class Main {
	public static int HEIGHT = 8;
	public static int LENGTH = 8;
	public static void main(String[] args) {
		Table.maleEmptyTable();
		OutPut.outPutTable();
//		Player player = new Player(InPut.getPlayer());
//		Player player2 = new Player(InPut.getPlayer());
		Player player = new Player('X');
		Player player2 = new Player('O');
		Position position = new Position();
		CheckWins ifWin = new CheckWins();
		for (;;){
			System.out.println("Turn " + player.getPlayer());
			int[] s = ConvertCodeToInt.codeToInt(InPut.getPosition());
			position.setPosition(s[0],s[1]);
			Table.setSymbol(position,player);
			if (ifWin.ifPlayerWin(player, position)){
				OutPut.outPutTable();
				System.out.println(player + "win");
				break;
			}
			OutPut.outPutTable();
			if (!Table.hasEmptyBlockAtTable()) { break; }
			System.out.println("Turn " + player2.getPlayer());
			s = ConvertCodeToInt.codeToInt(InPut.getPosition());
			position.setPosition(s[0],s[1]);
			Table.setSymbol(position,player2);
			if (ifWin.ifPlayerWin(player2, position)){
				OutPut.outPutTable();
				System.out.println(player + "win");
				break;
			}
			OutPut.outPutTable();
			if (!Table.hasEmptyBlockAtTable()) { break; }
		}
		InPut.closeScanner();
	}
}
