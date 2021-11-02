package main.player;

import main.ConvertCodeToInt;
import main.table.Position;
import main.table.Table;


public class ComputerPlayer {
	private char player;
	public ComputerPlayer(char player){
		this.player = player;
	}
	public char getPlayer(){
		return player;
	}
	public void setPlayer(char player){
		this.player = player;
	}
	public int[] actionDoStep() {
		int min = 49, max = 51;
		max -= min;
		int result, result2;
		Position pos;
		do {
			result = ((int) (Math.random() * max) + min);
			result2 = ((int) (Math.random() * max) + min);
			System.out.println("res 1 - " + result + " res 2 - " + result2);
			pos = new Position();
			char c = (char) result;
			char c1 = (char) result2;
			pos.setPosition(ConvertCodeToInt.codeToInt(c), ConvertCodeToInt.codeToInt(c1));
		} while (!Table.test(pos));
		Position pos2;
		pos2 = pos;
		return pos2.getPosition();
	}
	private void checkStepBefore(Position position){
		int posX = position.getPosition()[0],
				posY = position.getPosition()[1];

	}
}
