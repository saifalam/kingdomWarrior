package utility;

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
	public void log(String content) {
		System.out.println(content);	
	}
	
	@Override
	public void print(String content) {
		System.out.print(content);	
	}
}
