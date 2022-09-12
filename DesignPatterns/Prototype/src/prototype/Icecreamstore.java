package prototype;

import java.util.Hashtable;

public class Icecreamstore {
	
	private static Hashtable<String, Icecream> shapeMap  = new Hashtable<String, Icecream>();

	   public static Icecream getIcecream(String Icecreamno) {
		Icecream storedIcecream = shapeMap.get(Icecreamno);
	   return (Icecream) storedIcecream.clone();
	  }
	   
	   
	  
	   public static void loadCache() {
		     Vanila vanila = new Vanila();
		     vanila.setId("1");
		     shapeMap.put(vanila.getId(),vanila);

		      Blueberry blueberry = new Blueberry();
		      blueberry .setId("2");
		      shapeMap.put(blueberry .getId(),blueberry);
		      
		      Chocolate chocolate = new Chocolate();
		      chocolate .setId("3");
		      shapeMap.put(chocolate .getId(),chocolate);
		}	

}
