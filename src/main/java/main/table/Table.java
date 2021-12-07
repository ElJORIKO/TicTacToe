package main.table;

import main.player.ComputerPlayer;
import main.player.Player;
import main.start.Main;
import main.wins.Win;

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

	public static void setSymbol(Position pos, ComputerPlayer player){
		char[][] table = getTable();
		if (!isBlockBusy(pos)){
			return;
		}
		table[pos.getX()][pos.getY()] = player.getPlayer();
	}
	public static boolean setSymbol(Position pos, Player player){
		char[][] table = getTable();
		if (!new Win().isEndOfTable(pos)){
			System.out.println("Is out of table");
			return false;
		}
		if (!isBlockBusy(pos)){
			System.out.println("This bloc is busy");
			return false;
		}
		table[pos.getX()][pos.getY()] = player.getPlayer();
		return true;
	}
	public static void removeSymbol(Position pos){
		char[][] table = getTable();
		table[pos.getX()][pos.getY()] = SPACE;
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
	private static boolean isBlockBusy(Position pos){
		return getTable()[pos.getX()][pos.getY()] == SPACE;
	}
}
