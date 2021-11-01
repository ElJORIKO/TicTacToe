package main.start;

import main.*;

public class Main {
	public static void main(String[] args) {
		Table.maleEmptyTable();
		OutPut.outPutTable();
		Player player = new Player(InPut.getPlayer());
		Position position = new Position();
		while (Table.hasEmptyBlockAtTable()){
			int[] s = ConvertCodeToInt.codeToInt(InPut.getPosition());
			position.setPosition(s[0],s[1]);
			Table.setSymbol(position,player);
			OutPut.outPutTable();
		}
		InPut.closeScanner();
	}
}
