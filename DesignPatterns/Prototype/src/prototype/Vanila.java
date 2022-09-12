package prototype;

public class Vanila extends Icecream {
	public Vanila(){
	     flavour = "vanila";
	   }
	
	@Override
	void serve() {
		System.out.println("vanila icecream serve() method");
		
	}

}
