
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
		logger.log("");
		
		logger.log(GameInitializer.ANSI_YELLOW + "Welcome to the KINGDOM WARRIOR" + GameInitializer.ANSI_RESET);
		logger.log(GameInitializer.ANSI_RED+"--------------------------------------");
		logger.log("--------------------------------------");
		logger.log("Rules of this game:");
		logger.log("    =>To rule the seven kingdoms as a warrior, "
				+ "you need to conquer seven different levels/kingdoms one by one. ");
		
		logger.log("    =>To travese the board/area you must need to move "
				+ "north (up), south(down), east(right) and west (left).");
		
		logger.log("    =>To move north, south, east and west you can use 4 keys from your keyboard ");
		
		logger.log("    # West (left) = H ");
		logger.log("    # East(right) = L ");
		logger.log("    # South(down) = K ");
		logger.log("    # North (up) = J ");
		logger.log("    (If you are a vim user then you know what I mean ;) .... )");
		
		logger.log("");
		logger.log("    # As a warrior you will be represented by @ sign within a kingdom");
		
		logger.log("    # To conquer a kingdom you need to reach the $ sign, "
				+ "representing the flag of the kingdom");
		
		logger.log("");

		logger.log(" So, don't wait, go and take the challenge to collect all flags to rule seven kingdoms.");
		
		
		logger.log("--------------------------------------");
		logger.log("--------------------------------------" + GameInitializer.ANSI_RESET);
		

		IBoard kingdom = BoardFactory.getBoardFactory().getBoard(BoardSize.getSizeByLevel(1));
		
		Scanner scanner = new Scanner(System.in);
		logger.print("Please enter the name of the warrior: ");
		IPlayer warrior = PlayerFactory.getPlayerFactory().getPlayer(scanner.nextLine(), 0);
		scanner.close();
		
		GameInitializer gameInitializer = new GameInitializer(kingdom, warrior, 1);
		gameInitializer.play();
	}
}
