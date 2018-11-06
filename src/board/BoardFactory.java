package board;

/**
 * singleton class, used to generate game board,
 * with given size.
 * 
 *  Part of factory object pattern for Board
 *  
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public class BoardFactory {
	
	private static BoardFactory boardFactory = null;
	private BoardFactory() {}
	
	public static BoardFactory getBoardFactory() {
		if(boardFactory == null) {
			boardFactory = new BoardFactory();
		}
		return boardFactory;
	}
	
	public IBoard getBoard(int size) {
		return new Board(size);
	}

}
