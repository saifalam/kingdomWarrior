package game;

import java.util.Scanner;

import board.IBoard;
import player.IPlayer;
import utility.BoardSize;

public class GameInitializer {

	// Used to print different colors of letters on command line
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";

	private IBoard kingdom;
	private IPlayer warrior;

	private Scanner input = new Scanner(System.in);
	private Scanner decesion = new Scanner(System.in);
	private int level = 0;
	private boolean isWin = false;

	/** 
	 * used to initialize the necessary objects of this game 
	 */
	public void initGame() {
		if(warrior == null) {
			initPlayer();
		}
		
		level++;
		initKingdom();
		play();
	}
	
	/** 
	 * used to initialize the game board or map of a kingdom 
	 */
	private void initKingdom() {
		
		if(kingdom != null) {
			kingdom = null; 
			isWin = false;
		}
		
		initBoard();
	}
	
	public void initPlayer() {
		AbstractGameFactory playerFactory = GameObjectInitializer.getFactoryObject("player");
		System.out.print("Please enter the name of the warrior: ");
		warrior = playerFactory.getPlayer(input.nextLine(), 0);
	}

	public void initBoard() {
		AbstractGameFactory boardFactory = GameObjectInitializer.getFactoryObject("board");
		kingdom = boardFactory.getBoard(BoardSize.getSizeByLevel(level));
	}
	
	/** used to start the game */
	public void play() {
		System.out.println(warrior.getName() + ", you have " + warrior.getPoints() + " points");
		System.out.println("Start kingdom: " + level);
		//kingdom.solve();
		kingdom.draw();
		char[][] grid = kingdom.getGrid();
		
		int x = 1;
		int y = 1;
		String move;

		System.out.println("Enter a valid move (H(left),J(down),K(up),L(right))");
		while (!(move = input.nextLine()).equalsIgnoreCase("quit")) {
			
			if (move.equalsIgnoreCase("h")) {
				//System.out.println("left");

				if (grid[y - 1][x] == '#') {
					System.out.println("wall");
					System.out.println(grid[y - 1][x]);
				} 
				else if (grid[y - 1][x] == ' ' || grid[y - 1][x] == '@' || grid[y - 1][x] == '$') {
					//System.out.println("blank");
					System.out.println(grid[y - 1][x]);
					y--;
				}

				updateSingleMove(x, y, grid);

			} 
			else if (move.equalsIgnoreCase("j")) {
				//System.out.println("down");

				if (grid[y][x + 1] == '#') {
					System.out.println("wall");
					//System.out.println(grid[y][x + 1]);
				} 
				else if (grid[y][x + 1] == ' ' || grid[y][x + 1] == '@' || grid[y][x + 1] == '$') {
					//System.out.println("Blank");
					//System.out.println(grid[y][x + 1]);
					x++;
				}

				updateSingleMove(x, y, grid);
			} 
			else if (move.equalsIgnoreCase("k")) {

				//System.out.println("up");
				if (grid[y][x - 1] == '#') {
					System.out.println("wall");
				} 
				else if (grid[y][x - 1] == ' ' || grid[y][x - 1] == '@' || grid[y][x - 1] == '$') {
					//System.out.println("Blank");
					x--;
				}

				updateSingleMove(x, y, grid);
			} 
			else if (move.equalsIgnoreCase("l")) {

				if (grid[y + 1][x] == '#') {
					System.out.println("wall");
				} 
				else if (grid[y + 1][x] == ' ' || grid[y + 1][x] == '@' || grid[y + 1][x] == '$') {
					//System.out.println("Blank");
					//System.out.println("value of po sitions: " + (y + 1) + " " + x);
					y++;
				}

				updateSingleMove(x, y, grid);
			} 
			else {
				System.out.println("Invalid move: "+ move);
				System.out.println("Enter a valid move (H(left),J(down),K(up),L(right))");
			}
			
		}
		
		System.out.println("Mission is given up by the warrior "+ move);
		input.close();
	}

	/**
	 * used to update single move of a warrior
	 * and check necessary conditions to continue the game
	 */
	public void updateSingleMove(int x, int y, char[][] grid) {

		for (int i = 0; i < kingdom.getGridDimensionY(); i++) {
			for (int j = 0; j < kingdom.getGridDimensionX(); j++) {

				if (i == kingdom.getGridDimensionY() - 2 && j == kingdom.getGridDimensionX() - 2) {
					grid[j][i] = '$';
					System.out.print(ANSI_YELLOW + grid[j][i] + ANSI_RESET);
				} 
				else if (i == x && j == y) {
					grid[j][i] = '@';
					System.out.print(ANSI_YELLOW + grid[j][i] + ANSI_RESET);	
				} 
				else {
					System.out.print(grid[j][i]);
				}
				
				if (x == kingdom.getGridDimensionY() - 2 && y == kingdom.getGridDimensionX() - 2) {
					grid[j][i] = '$';
					System.out.print(ANSI_RED + grid[j][i] + ANSI_RESET);
					isWin = true;
				} 
			}
			System.out.println();
		}
		System.out.println();
		if(isWin){
			System.out.println();
			System.out.println("       ================================      ");
			System.out.println();
			if(level < 7) {
				System.out.println("Congratulation warrior "+ warrior.getName() + 
						" you win "+ level + (level== 1 ? " knigdom" :" knigdoms"));
				
				warrior.setPoints(warrior.getPoints()+100);
				System.out.println(warrior.getName() + " you earn "+ warrior.getPoints()+ " points");
				
				System.out.println("Do you want to win the next kingdom to rule the whole seven kingdom ?");
				
				System.out.println();
				System.out.println(ANSI_RED+"For next mission enter \"yes\" or to quit the game write \"quit\" "+ANSI_RESET);
				
				String decision = decesion.nextLine();
				
				while(!decision.equalsIgnoreCase("yes")) {
					System.out.println(ANSI_RED+"For next mission enter \"yes\" or to quit the game write \"quit\" "+ANSI_RESET);
					decision = input.nextLine();
					
					if(decision.equalsIgnoreCase("yes")) {
						break;
					}
					else if(decision.equalsIgnoreCase("quit")) {
						input.close();
						System.exit(0);
					}
				}
				
				System.out.println("       ================================      ");
				initGame();
				decesion.close();	
			}
			else {
				System.out.println("Congratulation warrior "+ warrior.getName() + 
						" you win all "+ level +" knigdoms");
				
				System.out.println(ANSI_YELLOW+"Now you are the ruler of Seven kingdom, the throne is yours..."+ ANSI_RESET);
				input.close();
				decesion.close();
				System.exit(0);
			}	
		}
	}
}
