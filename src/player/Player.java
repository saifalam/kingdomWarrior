package player;

/**
 * Used to provide a very simple player
 * 
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public class Player implements IPlayer{
	
	private String name;
	private int points;
	
	//More fields can be added according to the demand
	
	
	public Player(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getPoints() {
		return points;
	}
	
	@Override
	public void setPoints(int points) {
		this.points = points;
	}
}
