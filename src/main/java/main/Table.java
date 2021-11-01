package main;

public class Table {
	private static final char SPACE = 32;
	private static char[][] table = new char[3][3];
	private static void updateTable(char[][] newTable){
		Table.table = newTable;
	}
	public static char[][] getTable(){
		return Table.table;
	}
	public static void maleEmptyTable(){
		char[][] table = getTable();
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				table[i][j] = SPACE;
			}
		}
	}

	public static void setSymbol(Position position, Player player){
		int[] pos = position.getPosition();
		char[][] table = getTable();
		if (!isBlockBusy(position)){
			System.out.println("This bloc is busy");
			return;
		}
		table[pos[0]][pos[1]] = player.getPlayer();
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

	private static boolean isBlockBusy(Position position){
		int[] pos = position.getPosition();
		return getTable()[pos[0]][pos[1]] == SPACE;
	}
}
