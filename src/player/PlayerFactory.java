package player;

import board.IBoard;
import game.AbstractGameFactory;

public class PlayerFactory extends AbstractGameFactory {

	@Override
	public IBoard getBoard(int size) {
		//Implementation available for board initialization
		return null;
	}

	@Override
	public IPlayer getPlayer(String name, int points) {		
		return new Player(name, points);
	}

}
