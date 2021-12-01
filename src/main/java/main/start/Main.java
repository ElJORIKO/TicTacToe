package main.start;

import main.inOut.InPut;
import main.inOut.OutPut;
import main.player.ComputerPlayer;
import main.player.Player;
import main.table.*;
import main.wins.Win;

public class Main {
	public static int HEIGHT = 4;
	public static int LENGTH = 4;
	public static void main(String[] args) {
		Table.makeEmptyTable();
		OutPut.outPutTable();
		ComputerPlayer computerPlayer = new ComputerPlayer('X');
//		ComputerPlayer computerPlayer2 = new ComputerPlayer('O');
//		Player player = new Player(InPut.getPlayer());
//		Player player2 = new Player(InPut.getPlayer());
		Player player = new Player('O');
		Player player2 = new Player('X');
		Position position = new Position();
		Win win = new Win();
		computerPlayer.setAnotherPlayer(player);
		int count = 0;
		while (Table.hasEmptyBlockAtTable()){
			count++;
			System.out.println("Turn " + player.getPlayer());
			int[] s;
			do {
				s = InPut.getPosition();
				position.setPosition(s[0],s[1]);
			} while (!Table.setSymbol(position,player));
			if (win.isWin(player, position)){
				OutPut.outPutTable();
				System.out.println(player.getPlayer() + " win");
				break;
			}
			OutPut.outPutTable();
			if (!Table.hasEmptyBlockAtTable()) { break; }
			System.out.println("Turn " + computerPlayer.getPlayer());
//			s = ConvertCodeToInt.codeToInt(InPut.getPosition());
			do {
				position.setPosition(computerPlayer.actionDoStep(position));
			} while (!Table.setSymbol(position,player2));
			if (win.isWin(player2, position)){
				OutPut.outPutTable();
				System.out.println(player2.getPlayer() + " win");
				break;
			}
			OutPut.outPutTable();
		}
		System.out.println(count);
		InPut.closeScanner();
	}
}
