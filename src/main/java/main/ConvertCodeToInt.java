package main;

public class ConvertCodeToInt {
	public static int codeToInt(int code){
		switch (code){
			case 48:
				return 0;
			case 49:
				return 1;
			case 50:
				return 2;
			case 51:
				return 3;
			case 52:
				return 4;
			case 53:
				return 5;
			case 54:
				return 6;
			case 55:
				return 7;
			case 56:
				return 8;
			case 57:
				return 9;
			default:
				System.err.println("non 0-9 number - " + (char) code);
				System.exit(2);
		}
		return -1;
	}
	public static int[] codeToInt(int[] code){
		int[] result = new int[code.length];
		for (int i = 0;i<code.length; i++){
			result[i] = codeToInt(code[i]);
		}
		return result;
	}
}
