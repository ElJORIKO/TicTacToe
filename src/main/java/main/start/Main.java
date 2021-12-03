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
	private static final Win win = new Win();
	public static void initialization(){
		Table.makeEmptyTable();
		OutPut.outPutTable();
	}
	public static void main(String[] args) {
		initialization();
		ComputerPlayer computerPlayer = new ComputerPlayer('O');
//		ComputerPlayer computerPlayer2 = new ComputerPlayer('O');
//		Player player = new Player(InPut.getPlayer());
//		Player player2 = new Player(InPut.getPlayer());
		Player player = new Player('X');
		Player player2 = new Player('0');
		Position position = new Position();
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
		System.out.println("Total steps" + count);
		InPut.closeScanner();
	}
}
