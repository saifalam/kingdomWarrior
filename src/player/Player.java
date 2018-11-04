package player;

/**
 * Used to provide a very simple player
 */
public class Player {
	
	private String name;
	private int points;
	
	//More fields can be added according to the demand
	
	
	public Player(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}
	public String getName() {
		return name;
	}
	
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
}
