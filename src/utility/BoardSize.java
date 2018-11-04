package utility;

/**
 * Provide board size depending on game level
 */
public enum BoardSize {
	ONE(4),
	TOW(5),
	THREE(6),
	FOUR(7),
	FIVE(8),
	SIX(9),
	SEVEN(10);
	
	private int size;

	private BoardSize(int size) {
		this.size = size;
	}

	public static int getSizeByLevel(int level) {
		int result;
		
		switch (level) {
		case 2:
			result = TOW.size;
			break;
		case 3:
			result = THREE.size;
			break;
		case 4:
			result = FOUR.size;
			break;
		case 5:
			result = FIVE.size;
			break;
		case 6:
			result = SIX.size;
			break;
		case 7:
			result = SEVEN.size;
			break;	
		default:
			result = ONE.size;
			break;
		}
		return result;
	}
}
