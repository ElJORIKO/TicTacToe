package ru.ElJORIKO.main;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InPut {
	public static int[] getPosition(){
		Scanner scan = new Scanner(System.in);
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
}
