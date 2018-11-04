package board;

import game.AbstractGameFactory;
import player.IPlayer;

public class BoardFactory extends AbstractGameFactory {

	@Override
	public IBoard getBoard(int size) {
		return new Board(size);
	}

	@Override
	public IPlayer getPlayer(String name, int points) {
		// implementation available for player initialization 
		return null;

	}
	
	

}
