package com.designpatterns.chainofresponsibility.example;

public class FiftyDispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
		
	}

	@Override
	public void dispense(PaperCurrency currency) {
		if(currency.getAmount() >= 50){
			int num = currency.getAmount()/50;
			int remainder = currency.getAmount() % 50;
			System.out.println("Dispensing  '"+num+"' 50$ currency note");
		
			if(remainder !=0) this.chain.dispense(new PaperCurrency(remainder));
		}else{
			this.chain.dispense(currency);
		}
	}
}


