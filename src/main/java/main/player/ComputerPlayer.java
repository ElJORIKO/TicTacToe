package main.player;

import main.table.*;

import java.util.Arrays;


public class ComputerPlayer {
	private final char player;
	public ComputerPlayer(char player){
		this.player = player;
	}
	public char getPlayer(){
		return player;
	}
	public Position actionDoStep(Position opponentStep) {
		checkStepBefore(opponentStep);
		int min = 0, max = 4;
		max -= min;
		int result, result2;
		Position pos;
		do {
			result = ((int) (Math.random() * max) + min);
			result2 = ((int) (Math.random() * max) + min);
			System.out.println("res 1 - " + result + " res 2 - " + result2);
			pos = new Position();
			pos.setPositionWithoutCorrect(result,result2);
		} while (!Table.test(pos));
		pos.setPositionWithoutCorrect((result + 1), (result2 + 1));
		Position pos2 = pos;
		return pos2;
	}

	private void checkStepBefore(Position position){
		System.out.println(Arrays.toString(position.getPosition()));
	}
}
