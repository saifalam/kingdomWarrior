package game;

public class GameObjectInitializer {
	
	public static AbstractGameFactory getFactoryObject(String choice){
		   
	      if(choice.equalsIgnoreCase("board")) {
	         //return new BoardFactory();
	    	  return null;
	         
	      }
	      else if(choice.equalsIgnoreCase("player")) {
	    	  //return new PlayerFactory();
	    	  return null;
	      } 
	      else
	    	  return null;
	   }
}
