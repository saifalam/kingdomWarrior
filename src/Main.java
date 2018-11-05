import game.Game;
import game.GameInitializer;

public class Main {
	// Used to run the game
	public static void main(String[] args) {
		System.out.println();
		System.out.println(Game.ANSI_YELLOW + "Welcome to the KINGDOM WARRIOR" + Game.ANSI_RESET);
		System.out.println(Game.ANSI_RED+"--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("Rules of this game:");
		System.out.println("    =>To rule the seven kingdom as a warrior, "
				+ "you need to conquer seven different levels/ areas one by one. ");
		
		System.out.println("    =>To travese the board /area you must need to move "
				+ "north (up), south(down), east(right) and west (left).");
		
		System.out.println("    =>To move north, south, east and west you can use 4 keys from your keyboard ");
		
		System.out.println("    # West (left) = H ");
		System.out.println("    # East(right) = L ");
		System.out.println("    # South(down) = K ");
		System.out.println("    # North (up) = J ");
		System.out.println("    (If you are a vim user then you know what I mean ;) .... )");
		
		System.out.println();
		System.out.println("    # As a warrior you will be represented by @ sign within a kingdom");
		
		System.out.println("    # To conqure a kingdom you need to reach the $ sign, "
				+ "representing the flag of the kingdom");
		
		System.out.println();
		System.out.println();

		System.out.println(" So, don't wait, go and take the challenge to collect all flags to rule seven kingdom.");
		
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------" + Game.ANSI_RESET);
		GameInitializer gameInitializer = new GameInitializer();
		gameInitializer.initGame();
	}
}
