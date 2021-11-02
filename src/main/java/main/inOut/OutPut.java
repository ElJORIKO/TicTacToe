package main.inOut;

import main.table.Table;
import main.start.Main;

public class OutPut {
	public static void outPutTable(){
		char[][] table = Table.getTable();
		System.out.println("Table:");
		for (int i = 1; i <= Main.LENGTH; i++){
			System.out.print("\t " + i);
		}
		System.out.print("\n");
		for (int i = 0; i < Main.HEIGHT; i++){
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < Main.LENGTH; j++){
				System.out.print("[" + table[i][j]+ "] ");
			}
			System.out.println("");
		}
	}
}
