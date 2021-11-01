package main;

public class OutPut {
	public static void outPutTable(){
		char[][] table = Table.getTable();
		System.out.println("Table:");
		System.out.println("\t1\t2\t3");
		for (int i = 0; i <= 2; i++){
			System.out.print(i + 1 + "\t");
			for (int j = 0; j <= 2; j++){
				System.out.print("|" + table[i][j]+ "|");
			}
			System.out.println("");
		}
	}
}
