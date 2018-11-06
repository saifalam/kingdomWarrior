package player;

/**
 * provides extensibility to create new player 
 * 
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public interface IPlayer {
	public int getPoints();
	public String getName();
	public void setPoints(int points);
}
