package com.designpattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		
		Long start;
		Long end;
		
		//1st Instance
		SingletonObject singletonObject1 = SingletonObject.getSingletonObject();
		System.out.println(singletonObject1);
		
		start = System.currentTimeMillis();
		//Connection connection = SingletonObject.getConnection();
		end = System.currentTimeMillis();
		
		System.out.println(end-start);
		//2nd Instance
		SingletonObject singletonObject2 = SingletonObject.getSingletonObject();
		System.out.println(singletonObject2);
		
	}

}



