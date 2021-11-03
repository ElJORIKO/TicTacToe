package main.inOut;

import java.util.Scanner;

public class InPut {
	private static final Scanner scan = new Scanner(System.in);
	public static void closeScanner(){
		scan.close();
	}
	public static int[] getPosition(){
		System.out.print("enter position(Like \"1 1\"): ");
		String value = scan.nextLine();
		char[] b = value.toCharArray();
		String[] s = value.split(" ");
		int[] result = new int[2];
		for (int i = 0; i < result.length; i++){
			result[i] = Integer.parseInt(s[i]);
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
