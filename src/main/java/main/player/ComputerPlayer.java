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
		int maxLength = Main.LENGTH;
		int maxHeight = Main.HEIGHT;
		int posX, posY;
		Position pos = new Position();
		do {
			posY = ((int) (Math.random() * maxLength));
			posX = ((int) (Math.random() * maxHeight));
			pos.setPositionWithoutCorrect(posX, posY);
		} while (!Table.test(pos));
		pos.setPositionWithoutCorrect((posX + 1), (posY + 1));
		System.out.println("Set random\n" + pos.getAsString() );
		return pos;
	}
}
