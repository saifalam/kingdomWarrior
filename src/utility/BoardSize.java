package utility;

/**
 * Provide board size depending on game level
 * 
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
public enum BoardSize {
	ONE(5),
	TOW(6),
	THREE(7),
	FOUR(8),
	FIVE(9),
	SIX(10),
	SEVEN(11);
	
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
