package com.skilldistillery.jets.entities;

public class StealthJet extends Jet implements Stealthy {

	public StealthJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly () {
		int intFlytime =  (int) ((this.getRange()/this.getSpeed() ) * 100);
		double flytime = ((double) intFlytime) / 100;
		System.out.println(this.toString() + " Flight time: " + flytime + " hours");
	}
	
	public void sneak () {
		System.out.println("Sneakily sneaking actively...");
	}

	@Override
	public String toString() {
		return "StealthJet: Model: " + this.getModel()+ ", Speed in MPH: " + this.getSpeed() + ", Range in miles: " + this.getRange() + ", Price in USD: " + this.getPrice();
	}

}
