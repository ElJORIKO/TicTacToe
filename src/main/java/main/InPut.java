package main;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InPut {
	private static final Scanner scan = new Scanner(System.in);
	public static void closeScanner(){
		scan.close();
	}
	public static int[] getPosition(){
		System.out.print("enter position: ");
		String value = scan.nextLine();
		char[] b = value.toCharArray();
		if (b.length > 2) {
			System.out.println("You can`t use more 2 position (X and Y)");
			System.exit(1);
		}
		int[] result = new int[b.length];
		for (int i = 0; i < b.length; i++){
			result[i] = (int) b[i];
		}
		return result;
	}
	public static char getPlayer(){
		System.out.print("Enter Player: ");
		char[] chars;
		chars = scan.nextLine().toCharArray();

		return chars[0];
	}
}
