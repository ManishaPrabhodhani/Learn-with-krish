package prototype;

public abstract class Icecream implements Cloneable {
	private String id;
	   protected String flavour;
	   
	   abstract void serve();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getflavour() {
		return flavour;
	}

	public void setflavour(String flavour) {
		this.flavour = flavour;
	}
	   
	public Object clone() {
	      Object clone = null;
	      
	      try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }

}
