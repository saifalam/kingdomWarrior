
import java.util.Scanner;

import board.BoardFactory;
import board.IBoard;
import game.GameInitializer;
import player.IPlayer;
import player.PlayerFactory;
import utility.BoardSize;
import utility.ConsoleLogger;

public class Main {
	// Used to run the game
	public static void main(String[] args) {
		ConsoleLogger logger = ConsoleLogger.getConsoleLogger();
		logger.logln("");
		
		logger.logln(GameInitializer.ANSI_YELLOW + "Welcome to the KINGDOM WARRIOR" + GameInitializer.ANSI_RESET);
		logger.logln(GameInitializer.ANSI_RED+"--------------------------------------");
		logger.logln("--------------------------------------");
		logger.logln("Rules of this game:");
		logger.logln("    =>To rule the seven kingdoms as a warrior, "
				+ "you need to conquer seven different levels/kingdoms one by one. ");
		
		logger.logln("    =>To travese the board/area you must need to move "
				+ "north (up), south(down), east(right) and west (left).");
		
		logger.logln("    =>To move north, south, east and west you can use 4 keys from your keyboard ");
		
		logger.logln("    # West (left) = H ");
		logger.logln("    # East(right) = L ");
		logger.logln("    # South(down) = K ");
		logger.logln("    # North (up) = J ");
		logger.logln("    (If you are a vim user then you know what I mean ;) .... )");
		
		logger.logln("");
		logger.logln("    # As a warrior you will be represented by @ sign within a kingdom");
		
		logger.logln("    # To conquer a kingdom you need to reach the $ sign, "
				+ "representing the flag of the kingdom");
		
		logger.logln("");

		logger.logln(" So, don't wait, go and take the challenge to collect all flags to rule seven kingdoms.");
		
		
		logger.logln("--------------------------------------");
		logger.logln("--------------------------------------" + GameInitializer.ANSI_RESET);
		

		// Extensible part of the code
		// Here IBoard, IPalyer, ILogger gives the extensibility of the code
		IBoard kingdom = BoardFactory.getBoardFactory().getBoard(BoardSize.getSizeByLevel(1));
		
		logger.log("Please enter the name of the warrior: ");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		IPlayer warrior = PlayerFactory.getPlayerFactory().getPlayer(name, 0);
		
		// Here 1 and 7 denotes the start and end level of the game
		// Still the GameInitializer class contains some game dependent logics,
		// which can easily be separated into a new class with the option of 
		// extensibility (This is the plan, but the time is short)  
		GameInitializer gameInitializer = new GameInitializer(kingdom, warrior, 1, 7);
		gameInitializer.play();
		scanner.close();
	}
}
