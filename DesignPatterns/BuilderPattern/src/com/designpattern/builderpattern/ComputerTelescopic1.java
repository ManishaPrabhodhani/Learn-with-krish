package com.designpattern.builderpattern;

public class ComputerTelescopic1 {
	
	  String HDD;  
	  String RAM;  
	  boolean isBluetoothEnabled;    
	  boolean isGraphicsCardEnabled; 

      
      //Only take HDD constructor
      public ComputerTelescopic1(String HDD) {
    	  this.HDD=HDD;
    	  
      }
      //take HDD & RAM
      public ComputerTelescopic1(String HDD,String RAM) {
    	  this(HDD);     //Meantime Pass HDD constructor
    	  this.RAM=RAM;  //Only set the RAM 
    	   
      }
      
      public ComputerTelescopic1(String HDD,String RAM,  boolean isBluetoothEnabled) {
    	  this(HDD, RAM);
    	  this.isBluetoothEnabled= isBluetoothEnabled;
    	   
      }
      
      public ComputerTelescopic1(String HDD,String RAM,  boolean isBluetoothEnabled, boolean isGraphicsCardEnabled) {
    	  this(HDD, RAM, isBluetoothEnabled);
    	  this.isGraphicsCardEnabled=isGraphicsCardEnabled;
    	  
      }
      
 

	@Override
	public String toString() {
		return "ComputerTelescopic [HDD=" + HDD + 
				", RAM=" + RAM +
				", isBluetoothEnabled=" + isBluetoothEnabled + 
				", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
				"]";
	}
      
      
      

}
