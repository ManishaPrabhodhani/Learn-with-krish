package com.designpatterns.chainofresponsibility.example;

public class TenDispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
		
	}

	@Override
	public void dispense(PaperCurrency currency) {
		if(currency.getAmount() >= 10){
			int num = currency.getAmount()/10;
			int remainder = currency.getAmount() % 10;
			System.out.println("Dispensing '"+num+"' 10$ note");
			if(remainder !=0) this.chain.dispense(new PaperCurrency(remainder));
		}else{
			this.chain.dispense(currency);
		}
	}
}


