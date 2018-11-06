package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import board.Board;

class BoardTest {
	
	int getData(String data) {
		int size = 0;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		// Ask for the size of the kingdom
		Scanner scan = new Scanner(System.in);
		size = Integer.parseInt(scan.nextLine());
		scan.close();
		return size;
	}

	@Test
	void getGrid() {

		Board board1 = new Board(getData("4"));
		Board board2 = new Board(getData("4"));
		
		board1.solve();
		board2.solve();
		
		board1.draw();
		System.out.println();
		board2.draw();

		// Check for the grids inside cells of a board. This must not be equal 
		// for different boards as unique random board is generated 
		assertNotEquals(board1.getGrid(), board2.getGrid());

		System.out.println();
		System.out.println("======================");
		System.out.println("getGrid test Completed!");
		System.out.println("======================");

	}
	
	@Test
	void getGridDimensionTest() {

		Board board1 = new Board(getData("5"));
		Board board2 = new Board(getData("5"));
		
		board1.solve();
		board2.solve();
		
		board1.draw();
		System.out.println();
		board2.draw();
		
		

		// Shows different unique random kingdom for same size
		// As the size is same, the dimension for both X & Y axis should be equal 
		assertEquals(board1.getGridDimensionX(), board2.getGridDimensionX());
		assertEquals(board1.getGridDimensionY(), board2.getGridDimensionY());

		System.out.println();
		System.out.println("======================");
		System.out.println("getGridDimension test Completed!");
		System.out.println("======================");
	}
}
