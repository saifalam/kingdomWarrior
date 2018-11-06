package player;

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
