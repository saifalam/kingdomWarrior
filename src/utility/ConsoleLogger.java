package utility;

/**
 * This is a singleton class, used to
 * print information on console 
 * 
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public class ConsoleLogger implements ILogger {
	
	private static ConsoleLogger logger = null;
	
	private ConsoleLogger() {}
	
	public static ConsoleLogger getConsoleLogger() {
		if(logger == null) {
			logger = new ConsoleLogger();
		}
		
		return logger;
	}

	@Override
	public void logln(String content) {
		System.out.println(content);
		
	}

	@Override
	public void log(String content) {
		System.out.print(content);
		
	}
	

	
}
