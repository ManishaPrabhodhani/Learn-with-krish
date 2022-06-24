package com.designpatterns.chainofresponsibility.example;

import java.util.Scanner;

public class ATMDispenseChain {
	
	private DispenseChain c1;

	public ATMDispenseChain() {
		
		// initialise the chain
		this.c1 = new HundredDispenser();
		DispenseChain c2 = new FiftyDispenser();
		DispenseChain c3 = new TenDispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}
	
	
	public static void main(String[] args) {
		
		ATMDispenseChain atmDispenserChain = new ATMDispenseChain();
		
		while (true) {
			int amount = 0;
			System.out.println("Please enter amount to dispense:");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if(amount > 1000){
				
				System.out.println("Daily withdrawal limit is 1000$. Please Try again!");
				return ;
				
			}else if(amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s, Please Try again!");
				return;
			}
			
			// process the request
			atmDispenserChain.c1.dispense(new PaperCurrency(amount));
		}
	}
}


