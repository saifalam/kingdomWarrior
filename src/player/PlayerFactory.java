package player;

/**
 * singleton class, used to generate game player,
 * with given name and points (initially 0).
 * 
 *  Part of factory object pattern for player
 *  
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public class PlayerFactory {
	
	private static PlayerFactory playerFactory = null;
	private PlayerFactory() {}
	
	public static PlayerFactory getPlayerFactory() {
		if(playerFactory == null) {
			playerFactory = new PlayerFactory();
		}
		return playerFactory;
	}
	public IPlayer getPlayer(String name, int points) {		
		return new Player(name, points);
	}

}
