package com.designpattern.builderpattern;

public class ComputerTelescopic2 {
	
	  String HDD;  
	  String RAM;  
	  boolean isBluetoothEnabled;    
	  boolean isGraphicsCardEnabled; 
      boolean etc;
      
      public ComputerTelescopic2(String HDD, String RAM, boolean isBluetoothEnabled,boolean isGraphicsCardEnabled, boolean etc) {
    	  this.HDD=HDD;
    	  this.RAM=RAM;
    	  this.isBluetoothEnabled=isBluetoothEnabled;
    	  this.isGraphicsCardEnabled=isGraphicsCardEnabled;
    	  this.etc=etc;
    	  
      }
      public ComputerTelescopic2(String HDD, String RAM, boolean isBluetoothEnabled,boolean isGraphicsCardEnabled) {
    	  this(HDD,RAM,isBluetoothEnabled,isGraphicsCardEnabled,(Boolean) null);
      }

}
