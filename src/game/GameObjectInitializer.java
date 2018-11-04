package game;

import board.BoardFactory;
import player.PlayerFactory;

public class GameObjectInitializer {
	
	public static AbstractGameFactory getFactoryObject(String choice){
		   
	      if(choice.equalsIgnoreCase("board")) {
	         return new BoardFactory();
	         
	      }
	      else if(choice.equalsIgnoreCase("player")) {
	    	  return new PlayerFactory();
	      } 
	      else
	    	  return null;
	   }
}
