package main.start;

import main.*;
import main.inOut.InPut;
import main.inOut.OutPut;
import main.player.ComputerPlayer;
import main.player.Player;
import main.table.Position;
import main.table.Table;

public class Main {
	public static int HEIGHT = 3;
	public static int LENGTH = 3;
	public static void main(String[] args) {
		Table.maleEmptyTable();
		OutPut.outPutTable();
		ComputerPlayer computerPlayer = new ComputerPlayer('X');
//		ComputerPlayer computerPlayer2 = new ComputerPlayer('O');
//		Player player = new Player(InPut.getPlayer());
//		Player player2 = new Player(InPut.getPlayer());
		Player player = new Player('O');
		Player player2 = new Player('X');
		Position position = new Position();
		CheckWins ifWin = new CheckWins();
		int count = 0;
		while (Table.hasEmptyBlockAtTable()){
			count++;
			System.out.println("Turn " + player.getPlayer());
			int[] s;
			do {
				s = ConvertCodeToInt.codeToInt(InPut.getPosition());
				position.setPosition(s[0],s[1]);
			} while (!Table.setSymbol(position,player));
			if (ifWin.ifPlayerWin(player, position)){
				OutPut.outPutTable();
				System.out.println(player.getPlayer() + " win");
				break;
			}
//			System.out.println("Turn - " + computerPlayer2);
//			int[] s = computerPlayer2.actionDoStep();
//			position.setPosition(s[0],s[1]);
//			Table.setSymbol(position,computerPlayer2);
//			if (ifWin.ifPlayerWin(computerPlayer2,position)){
//				OutPut.outPutTable();
//				System.out.println(computerPlayer.getPlayer() + " win");
//				break;
//			}

			OutPut.outPutTable();
			if (!Table.hasEmptyBlockAtTable()) { break; }
			System.out.println("Turn " + computerPlayer.getPlayer());
//			s = ConvertCodeToInt.codeToInt(InPut.getPosition());
			do {
				s = computerPlayer.actionDoStep();
				position.setPosition(s[0],s[1]);
			} while (!Table.setSymbol(position,player));
			if (ifWin.ifPlayerWin(player2, position)){
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
