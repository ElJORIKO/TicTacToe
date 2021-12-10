package main.player;

import main.start.Main;
import main.table.*;


public class ComputerPlayer {
	private final char player;
	private Player anotherPlayer;
	public void setAnotherPlayer(Player player){
		this.anotherPlayer = player;
	}
	public ComputerPlayer(char player){
		this.player = player;
	}
	public char getPlayer(){
		return player;
	}
	public Position actionDoStep(Position opponentStep) {
		ComputerBrain computerBrain = new ComputerBrain();
		computerBrain.setAnotherPlayer(anotherPlayer);
		if (computerBrain.isCanDoStep(opponentStep)){
			return computerBrain.getPositionCorrect();
		}
		int max = Main.LENGTH;
		int result, result2;
		Position pos;
		do {
			result = ((int) (Math.random() * max));
			result2 = ((int) (Math.random() * max));
			pos = new Position();
			pos.setPositionWithoutCorrect(result,result2);
		} while (!Table.test(pos));
		pos.setPositionWithoutCorrect((result + 1), (result2 + 1));
		System.out.println("Set random\n" + pos.getAsString() );
		return pos;
	}
}
