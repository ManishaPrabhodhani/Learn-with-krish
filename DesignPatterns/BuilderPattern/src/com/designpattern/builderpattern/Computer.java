package com.designpattern.builderpattern;

import com.designpattern.builderpattern.House.Builder;

public class Computer {
	
		private final String HDD;  //required parameters
		private final String RAM;  //required parameters
		private final boolean isBluetoothEnabled;    //optional parameters
		private final boolean isGraphicsCardEnabled; //optional parameters
	  
		 public Computer(Builder builder) {
			  this.HDD=builder.HDD;
			  this.RAM=builder.RAM;
			  this.isBluetoothEnabled=builder.isBluetoothEnabled;
			  this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
			    	
			}

	    //Builder Class
	    static class Builder{
	    	
	    	private String HDD;  //required parameters
			private String RAM;  //required parameters
			private boolean isBluetoothEnabled;    //optional parameters
			private boolean isGraphicsCardEnabled; //optional parameters
			
			//build method
			 public Computer build() {
		 	    	return new Computer(this);
		 	    }
			 
			 //HDD and RAM are required for a computer
			 public Builder(String HDD, String RAM){
					this.HDD=HDD;
					this.RAM=RAM;
	    }
			 //Take isBluetoothEnabled and assign to this
		     // And return the current instance
			 public Builder isBluetoothEnabled(boolean isBluetoothEnabled) {
				 this.isBluetoothEnabled=isBluetoothEnabled;
				 return this;
			 }
			 
			 public Builder isGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
				 this.isGraphicsCardEnabled=isGraphicsCardEnabled;
				 return this;
			 }
	   }

		@Override
		public String toString() {
			return "Computer [HDD=" + HDD + 
					", RAM=" + RAM + 
					", isBluetoothEnabled=" + isBluetoothEnabled + 
					", isGraphicsCardEnabled=" + isGraphicsCardEnabled + 
					
					"]";
		}
		
		
	    
	    
}
