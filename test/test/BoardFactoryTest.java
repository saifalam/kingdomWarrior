package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.BoardFactory;
import board.IBoard;

class BoardFactoryTest {

	@Test
	void getBoard() {
		int size = 10;
		IBoard board = BoardFactory.getBoardFactory().getBoard(size);
		
		assertTrue(board instanceof Board);
		assertEquals(41, board.getGridDimensionX());
		assertEquals(21, board.getGridDimensionY());
	}

}
