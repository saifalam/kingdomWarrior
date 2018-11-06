package board;

/** 
 * provides extensibility to create new board
 * 
 *  <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public interface IBoard {
	
	public int getGridDimensionX();
	public int getGridDimensionY();
	public char[][] getGrid();
	public void solve();
	public void draw();

}
