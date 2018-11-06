package game;

import board.IBoard;
import player.IPlayer;

public abstract class AbstractGameFactory {
	
	/** used  to initialize Board object */
	public abstract IBoard getBoard(int size);
	
	/** used  to initialize Player object */
	public abstract IPlayer getPlayer(String name, int points);
}
