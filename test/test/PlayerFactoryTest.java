package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import player.IPlayer;
import player.PlayerFactory;

/**
 * used to test {@link PlayerFactory} 
 * 
 * <br>
 * @author  Saif
 * @version 1.0
 * @since   2018-11-04
 */
class PlayerFactoryTest {

	@Test
	void getPlayer() {
		
		String name = "test";
		int points = 0007;
		
		IPlayer player = PlayerFactory.getPlayerFactory().getPlayer(name, points);
		
		assertTrue(player instanceof IPlayer);
		
		assertEquals(name, player.getName());
		
		assertEquals(points, player.getPoints());
		
		// test setPlayer for Player
		player.setPoints(420);
		
		assertEquals(420, player.getPoints());
	}

}
