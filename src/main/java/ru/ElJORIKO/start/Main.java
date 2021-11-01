package ru.ElJORIKO.start;

import ru.ElJORIKO.main.ConvertCodeToInt;
import ru.ElJORIKO.main.InPut;

import java.util.Arrays;

import static ru.ElJORIKO.main.ConvertCodeToInt.codeToInt;

public class Main {
	public static void main(String[] args){
		int [] s = InPut.getPosition();
		System.out.println(Arrays.toString(codeToInt(s)));

	}
}
