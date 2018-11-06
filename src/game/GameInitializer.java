package game;

import java.util.Scanner;

import board.BoardFactory;
import board.IBoard;
import player.IPlayer;
import utility.BoardSize;
import utility.ConsoleLogger;

public class GameInitializer {
	
	ConsoleLogger logger = ConsoleLogger.getConsoleLogger();

	// Used to print different colors of letters on command line
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";

	// kingdom reference of Interface IBoard type 
	private IBoard kingdom;
	
	// warrior reference of Interface IPlayer type
	private IPlayer warrior;

	// used to take single move from a warrior, when traversing a kingdom
	private Scanner input = new Scanner(System.in);
	
	// used to take further decision from a warrior
	private Scanner decesion = new Scanner(System.in);
	
	// indicates the level of the running game 
	private int currentLevel = 0;
	
	// indicates the level of the running game 
	private int finalLevel = 0;
	
	// true only when a warrior conquer a kingdom
	private boolean isWin = false;
	
	public GameInitializer() {}

	public GameInitializer(IBoard kingdom, IPlayer warrior, int currentLevel, int finalLevel) {
		this.kingdom = kingdom;
		this.warrior = warrior;
		this.currentLevel = currentLevel;
		this.finalLevel = finalLevel;
	}

	/** used to initialize the necessary objects of this game */
	public void initGame() {
		currentLevel++;
		initKingdom();
		play();
	}
	
	/** used to initialize the game board or map of a kingdom */
	private void initKingdom() {
		
		if(kingdom != null) {
			kingdom = null; 
			isWin = false;
		}
		
		updateBoard();
	}
	

	/** Initialize a kingdom from BoardFactory */
	public void updateBoard() {
		kingdom = BoardFactory.getBoardFactory().getBoard(BoardSize.getSizeByLevel(currentLevel));
	}
	
	/** 
	 * used to start the game 
	 * 
	 * This method contains game dependent logics, which should be 
	 * removed with to other class with extensibility (future plan) 
	 * 
	 */
	public void play() {
		logger.logln(warrior.getName() + ", you have " + warrior.getPoints() + " points");
		logger.logln("Start kingdom: " + currentLevel);
		
		kingdom.draw();
		char[][] grid = kingdom.getGrid();
		
		int x = 1;
		int y = 1;

		logger.logln("Enter a valid move (H(left),J(down),K(up),L(right))");
		
		String move = null;
		
		try {
			while (!(move= input.nextLine()).equalsIgnoreCase("quit")) {
				
				if (move.equalsIgnoreCase("h")) {
					//logger.log("left");

					if (grid[y - 1][x] == '#') {
						logger.logln("wall");
						logger.logln(grid[y - 1][x]+"");
					} 
					else if (grid[y - 1][x] == ' ' || grid[y - 1][x] == '@' 
							|| grid[y - 1][x] == '$' || grid[y - 1][x] == '*') {
						//logger.log("blank");
						logger.logln(grid[y - 1][x]+"");
						y--;
					}

					updateSingleMove(x, y, grid);
				} 
				else if (move.equalsIgnoreCase("j")) {

					if (grid[y][x + 1] == '#') {
						logger.logln("wall");
					} 
					else if (grid[y][x + 1] == ' ' || grid[y][x + 1] == '@' 
							|| grid[y][x + 1] == '$' || grid[y][x + 1] == '*') {
						x++;
					}

					updateSingleMove(x, y, grid);
				} 
				else if (move.equalsIgnoreCase("k")) {
					
					if (grid[y][x - 1] == '#') {
						logger.logln("wall");
					} 
					else if (grid[y][x - 1] == ' ' || grid[y][x - 1] == '@' 
							|| grid[y][x - 1] == '$' || grid[y][x - 1] == '*') {
						x--;
					}

					updateSingleMove(x, y, grid);
				} 
				else if (move.equalsIgnoreCase("l")) {

					if (grid[y + 1][x] == '#') {
						logger.logln("wall");
					} 
					else if (grid[y + 1][x] == ' ' || grid[y + 1][x] == '@' 
							|| grid[y + 1][x] == '$' || grid[y + 1][x] == '*') {
						y++;
					}

					updateSingleMove(x, y, grid);
				} 
				else {
					logger.logln("Invalid move: "+ move);
					logger.logln("Enter a valid move (H(left),J(down),K(up),L(right))");
				}
			}
			
			logger.logln("Mission is given up by the warrior:  "+ move);
			
			decesion.close();
			input.close();
			System.exit(0);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * used to update single move of a warrior
	 * and check necessary conditions to continue the game
	 * 
	 * should be removed with to other class with extensibility (future plan)
	 * 
	 */
	private void updateSingleMove(int x, int y, char[][] grid) {

		for (int i = 0; i < kingdom.getGridDimensionY(); i++) {
			for (int j = 0; j < kingdom.getGridDimensionX(); j++) {

				if (i == kingdom.getGridDimensionY() - 2 && j == kingdom.getGridDimensionX() - 2) {
					grid[j][i] = '$';
					logger.log(ANSI_YELLOW + grid[j][i] + ANSI_RESET);
				} 
				else if (i == x && j == y) {
					grid[j][i] = '@';
					logger.log(ANSI_YELLOW + grid[j][i] + ANSI_RESET);	
				} 
				else {
					logger.log(grid[j][i]+"");
				}
				
				if (x == kingdom.getGridDimensionY() - 2 && y == kingdom.getGridDimensionX() - 2) {
					grid[j][i] = '$';
					logger.log(ANSI_RED + grid[j][i] + ANSI_RESET);
					isWin = true;
				} 
			}
			logger.logln("");
		
		if(isWin) 
			progressMission();	
	}
}

	/** this method is used when a warrior win/conquer a kingdom */
	private void progressMission() {
		
		logger.logln("");
		logger.logln("       ================================      ");
		logger.logln("");
		
		if(currentLevel < finalLevel ) {
			
			logger.logln("Congratulation warrior "+ warrior.getName() + 
					" you win "+ currentLevel + (currentLevel== 1 ? " knigdom" :" knigdoms"));
			
			warrior.setPoints(warrior.getPoints()+100);
			logger.logln(warrior.getName() + " you earn "+ warrior.getPoints()+ " points");
			
			logger.logln("Do you want to win the next kingdom to rule the whole seven kingdom ?");
			
			logger.logln("");
			logger.logln(ANSI_RED+"For next mission enter \"yes\" or to quit the game write \"quit\" "+ANSI_RESET);
			
			String decision = decesion.nextLine();
			
			while(!decision.equalsIgnoreCase("yes")) {
				
				logger.logln(ANSI_RED+"For next mission enter \"yes\" or to quit the game write \"quit\" "+ANSI_RESET);
				decision = input.nextLine();
				
				if(decision.equalsIgnoreCase("yes")) {
					break;
				}
				else if(decision.equalsIgnoreCase("quit")) {
					input.close();
					System.exit(0);
				}
			}
			
			logger.logln("       ================================      ");
			initGame();
			decesion.close();	
		}
		else {
			
			logger.logln("Congratulation warrior "+ warrior.getName() + 
					" you win all "+ currentLevel +" kingdoms");
			
			logger.logln(ANSI_YELLOW+"Now you are the ruler of Seven kingdom, the throne is yours..."+ ANSI_RESET);
			input.close();
			decesion.close();
			System.exit(0);
		}
	}
}

