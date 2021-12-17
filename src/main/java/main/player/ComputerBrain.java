package main.player;

import main.inOut.OutPut;
import main.table.Position;
import main.table.Table;
import main.wins.Win;

import java.util.Arrays;

public class ComputerBrain {
	private final Win win = new Win();
	public Position position;
	private Player anotherPlayer;
	public void setAnotherPlayer(Player player) {
		this.anotherPlayer = player;
	}
	public Position getPositionCorrect() {
		position.increaseX();
		position.increaseY();
		return position;
	}
	public boolean isCanDoStep(Position anotherPlayerStep){
		return (checkStepBefore(anotherPlayerStep));
	}
	private boolean checkStepBefore(Position pos){
		Position startPosition = new Position();
		startPosition.setPositionWithoutCorrect(pos);
		if (!win.isEndOfTable(pos)){
			return false;
		}
		pos.decreaseX();
		pos.decreaseY();
		int yPos = pos.getY();
		byte shiftVertical = 0, shiftHorizontal = 0;
		while (shiftVertical < 3){
			while (shiftHorizontal < 3){
				System.out.printf("V - %s, H - %s\n",shiftVertical,shiftHorizontal);
				if (anotherPlayerCanWinAtXLine(pos, startPosition)) {
					return true;
				}
				pos.increaseYBy(1);
				shiftHorizontal++;
			}
			pos.setY(yPos);
			pos.increaseXBy(1);
			shiftVertical++;
			shiftHorizontal = 0;
		}
		return false;
	}

	private boolean anotherPlayerCanWinAtXLine(Position pos, Position positionPlayer){
		if (Arrays.equals(pos.getPosition(), positionPlayer.getPosition())) {
			pos.increaseYBy(1);
		}
		if (win.isEndOfTable(pos) && Table.setSymbol(pos,anotherPlayer)){
			OutPut.outPutTable();
			if (win.isWin(anotherPlayer,pos)){
				System.out.println("Player must win\nAt " + pos.getAsString());
				Table.removeSymbol(pos);
				position = pos;
				return true;
			}
			Table.removeSymbol(pos);
		} else {
			System.out.println(pos.getAsString());
			if (win.isEndOfTable(pos) && anotherPlayer.getPlayer() == Table.getSymbolAtTable(pos)){
				System.out.println("This block is busy by another player");
			}
		}
		return false;
	}
}