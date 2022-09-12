package com.designpattern.singleton;

public class SinglePersonDemo {

	public static void main(String[] args) {
		
		Long start;
		Long end;
		
		//1st Instance
		SinglePersonObject singlePersonObject1 = SinglePersonObject.getSinglePersonObject();
		System.out.println(singlePersonObject1);
		
		start = System.currentTimeMillis();
		//Connection connection = SinglePersonObject.getConnection();
		end = System.currentTimeMillis();
		
		System.out.println(end-start);
		//2nd Instance
		SinglePersonObject singlePersonObject2 = SinglePersonObject.getSinglePersonObject();
		System.out.println(singlePersonObject2);
		
	}

}



