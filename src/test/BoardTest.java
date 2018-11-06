package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import board.Board;

class BoardTest {

	@Test
	void test() {

		// Ask for the size of the kingdom
		Scanner scan = new Scanner(System.in);
		int size = 0;
		do {
			System.out.print("Input the size for the kingdom (>2): ");
			while (!scan.hasNextInt()) {
				// Repeat message when bad input is given
				System.out.println("Needs a valid integer for kingdom size (>2) ");
				System.out.print("Input the size for the kingdom (>2): ");
				scan.next();
			}
			size = scan.nextInt();
		} while (size <=2);
		scan.close();

		Board board1 = new Board(size);
		Board board2 = new Board(size);
		
		board1.draw();
		board2.draw();

		// Shows different unique random kingdom for same size
		// As the size is same, the dimension for both X & Y axis should be equal 
		assertEquals(board1.getGridDimensionX(), board2.getGridDimensionX());
		assertEquals(board1.getGridDimensionY(), board2.getGridDimensionY());

		// Check for the grids inside cells of a board. This must not be equal 
		// for different boards as unique random board is generated 
		assertNotEquals(board1.getGrid(), board2.getGrid());

		System.out.println();
		System.out.println("======================");
		System.out.println("Test Completed!");
		System.out.println("======================");

	}

}
