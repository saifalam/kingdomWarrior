package board;

public interface IBoard {
	
	public int getGridDimensionX();
	public int getGridDimensionY();
	public char[][] getGrid();
	public void solve();
	public void draw();

}
