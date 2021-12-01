package main.player;

import main.inOut.OutPut;
import main.table.*;
import main.wins.General;
import main.wins.Win;

import java.util.Arrays;


public class ComputerPlayer {
	private final char player;
	private Player anotherPlayer;
	private Win win = new Win();
	public void setAnotherPlayer(Player player){
		this.anotherPlayer = player;
	}
	public ComputerPlayer(char player){
		this.player = player;
	}
	public char getPlayer(){
		return player;
	}
	General general = new General();
	public Position actionDoStep(Position opponentStep) {
		if (checkStepBefore(opponentStep)){
			System.out.println(general.getPosition().getAsString());
			Position pos = general.getPosition();
			pos.increaseX();
			pos.increaseY();
			return pos;
		}
		int min = 0, max = 4;
		max -= min;
		int result, result2;
		Position pos;
		do {
			result = ((int) (Math.random() * max) + min);
			result2 = ((int) (Math.random() * max) + min);
			pos = new Position();
			pos.setPositionWithoutCorrect(result,result2);
		} while (!Table.test(pos));
		System.out.println("Computer pos:\n" + pos.getAsString());
		pos.setPositionWithoutCorrect((result + 1), (result2 + 1));
		return pos;
	}

	private boolean checkStepBefore(Position position){
		System.out.println("Player pos:\n" + position.getAsString());
		System.out.println("Start check profitable step for player");
		general.setXY(position);
		Position tmpPos = new Position();
		tmpPos.setPosition(general.getX(),general.getY());
		int yPosition = tmpPos.getPosition()[1];
		if (!win.isEndOfTable(tmpPos)){
			//TODO Он возвращает false если точка игрока установлена в  крайнем верхнем положении
			// Необходимо дописать отдельный класс для этих ситуаций
			return false;
		}
		/**
		 * Проверяет область 3х3 вокруг точки игрока
		 * Если в вариации есть
		 */
		for (int shiftVertical = 1; shiftVertical <= 3; shiftVertical++){
			for (int shiftHorizontal = 1; shiftHorizontal <= 3; shiftHorizontal++){
				if (Arrays.equals(tmpPos.getPosition(), position.getPosition())) {
					tmpPos.increaseYBy(1);
					continue;
				}
				if (win.isEndOfTable(tmpPos) && Table.setSymbol(tmpPos,anotherPlayer)){
					OutPut.outPutTable();
					if (win.isWin(anotherPlayer,tmpPos)){
						System.out.println("Player must win");
						Table.removeSymbol(tmpPos);
						OutPut.outPutTable();
						return true;
					}
					Table.removeSymbol(tmpPos);
					tmpPos.increaseYBy(1);
				}
			}
			tmpPos.setY(yPosition);
			tmpPos.increaseXBy(1);
		}
		return false;
	}
}
