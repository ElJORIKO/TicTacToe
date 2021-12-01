package main.table;

import main.player.ComputerPlayer;
import main.player.Player;
import main.start.Main;

import java.util.Arrays;

public class Table {
	private static final char SPACE = 32;
	private static char[][] table = new char[Main.HEIGHT][Main.LENGTH];
	private static void updateTable(char[][] newTable){
		Table.table = newTable;
	}
	public static char[][] getTable(){
		return Table.table;
	}
	public static void makeEmptyTable(){
		char[][] table = getTable();
		for (int i = 0; i < Main.HEIGHT; i++){
			for (int j = 0; j < Main.LENGTH; j++){
				table[i][j] = SPACE;
			}
		}
	}

	public static void setSymbol(Position position, ComputerPlayer player){
		int[] pos = position.getPosition();
		char[][] table = getTable();
		if (!isBlockBusy(position)){
			return;
		}
		table[pos[0]][pos[1]] = player.getPlayer();
	}
	public static boolean setSymbol(Position position, Player player){
		int[] pos = position.getPosition();
		char[][] table = getTable();
		if (!isBlockBusy(position)){
			System.out.println("This bloc is busy");
			return false;
		}
		table[pos[0]][pos[1]] = player.getPlayer();
		return true;
	}
	public static void removeSymbol(Position position){
		int[] pos = position.getPosition();
		char[][] table = getTable();
		table[pos[0]][pos[1]] = SPACE;
	}

	public static boolean hasEmptyBlockAtTable(){
		char[][] table = getTable();
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (table[i][j] == SPACE){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean test(Position position){
		return isBlockBusy(position);
	}
	private static boolean isBlockBusy(Position position){
		int[] pos = position.getPosition();
		return getTable()[pos[0]][pos[1]] == SPACE;
	}
}
