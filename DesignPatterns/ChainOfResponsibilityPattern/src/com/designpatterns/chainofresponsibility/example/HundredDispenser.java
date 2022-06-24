package com.designpatterns.chainofresponsibility.example;

public class HundredDispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
		
	}

	@Override
	public void dispense(PaperCurrency currency) {
		if(currency.getAmount() >= 100){
			int num = currency.getAmount()/100;
			int remainder = currency.getAmount() % 100;
			System.out.println("Dispensing '"+num+"' 100$ note");
			if(remainder !=0) this.chain.dispense(new PaperCurrency(remainder));
		}else{
			this.chain.dispense(currency);
		}
		
	}

}



