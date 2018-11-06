package board;

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
