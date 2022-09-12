package prototype;

public class prototypedemo {
	public static void main(String[] args) {
	      Icecreamstore.loadCache();

	      Icecream clonedicecream1 = (Icecream) Icecreamstore.getIcecream("1");
	      System.out.println("Icecream : " + clonedicecream1.getflavour());		

	      Icecream clonedicecream2 = (Icecream) Icecreamstore.getIcecream("2");
	      System.out.println("Icecream : " + clonedicecream2.getflavour());		
	
	   }

}
