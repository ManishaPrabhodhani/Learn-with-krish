package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonObject {
	
	//Create an Object
	private static volatile SingletonObject singletonObject; // = new SingletonObject();
	private static volatile Connection connection;
	
	
	private SingletonObject() {
		if (singletonObject !=  null) {
			throw new RuntimeException("Please use getSingletonObject method"); 
		}	
	}

	
	public static SingletonObject getSingletonObject() {
		//Double-checked singleton implementation
		if(singletonObject==null) {
			// If it is null, synchronise the SingletonObject class 
			synchronized (SingletonObject.class) {
				//Again check the singletonObject is null 
				if(singletonObject==null) {
				singletonObject = new SingletonObject();
				}
			}
			
		}
		return singletonObject;
	}
	public Connection getConnection() {
		
		if(connection == null) {
			synchronized (SingletonObject.class) {
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




