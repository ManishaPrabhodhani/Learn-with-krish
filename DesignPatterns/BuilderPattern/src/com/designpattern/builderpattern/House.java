package com.designpattern.builderpattern;

import com.designpattern.builderpattern.House.Builder;

public class House {
	
	    

		private final String basement;
	    private final String roof;
	    private final String structure;
	    private final Boolean etc;

	    
	    public House(Builder builder) {
	    	this.basement=builder.basement;
			this.roof=builder.roof;
			this.structure=builder.structure;
			this.etc=builder.etc;
		}
	    
	    
	    //Builder Class
	    static class Builder{
	    	
	    	private String basement;
	 	    private String roof;
	 	    private String structure;
	 	    private Boolean etc;

	 	    public House build() {
	 	    	return new House(this);
	 	    }
	 	    
	 	    //Roof is a must for a House
	        public Builder(String roof) {
	        	this.roof=roof;
	        		
	        }
	          
	        //Take basement and assign to this
	        //Return the current instance
	        public Builder basement(String basement) {
	          	this.basement=basement;
	          	return this;
	        }
	        
	        public Builder structure(String structure) {
	          	this.structure=structure;
	          	return this;
	        }
	        
	        public Builder etc(Boolean etc) {
	          	this.etc = etc;
	          	return this;
	        }
			
	    }


		@Override
		public String toString() {
			return "House { "+
					"basement=" + basement + 
					", roof=" + roof + 
					", structure=" + structure +
					", etc=" + etc + 
					"}";
		}
	    
}
