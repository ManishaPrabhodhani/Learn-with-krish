package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SinglePersonnObject {
	
	//Create an Object
	private static volatile SingletPersonObject singlePersonObject; // = new SinglePersonObject();
	private static volatile Connection connection;
	
	
	private SinglePersonObject() {
		if (singlePersonObject !=  null) {
			throw new RuntimeException("Please use getSinglePersonObject method"); 
		}	
	}

	
	public static SinglePersonObject getSinglePersonObject() {
		//Double-checked singleton implementation
		if(singlePersonObject==null) {
			// If it is null, synchronise the SinglePersonObject class 
			synchronized (SinglePersonObject.class) {
				//Again check the singlePersonObject is null 
				if(singlePersonObject==null) {
				singlePersonObject = new SinglePersonObject();
				}
			}
			
		}
		return singlePersonObject;
	}
	public Connection getConnection() {
		
		if(connection == null) {
			synchronized (SinglePersonObject.class) {
				if(connection == null) {
					String url = "";
					try {
						connection =DriverManager.getConnection(url);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return connection;

				}
	
}




