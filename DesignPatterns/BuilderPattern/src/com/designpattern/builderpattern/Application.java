package com.designpattern.builderpattern;

public class Application {

	public static void main(String[] args) {
	
		
		///Using builder to get the object in a single line 
		//without any inconsistent state or arguments management issues
		
		Computer.Builder builder = new Computer.Builder("1TB", "2GB");
	     
	    Computer computer = builder.isBluetoothEnabled(true).build();
	     
	    System.out.println(computer);
		
	}

}


