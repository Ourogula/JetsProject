package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet implements Transporter{

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly () {
		int intFlytime =  (int) ((this.getRange()/this.getSpeed() ) * 100);
		double flytime = ((double) intFlytime) / 100;
		System.out.println("Fly away my arks of mankind! Flight time: " + flytime + " hours");
	}

	public void loadCargo() {
		System.out.println("Loading up the goods!");
	}
	
	@Override
	public String toString() {
		return "PassengerJet: Model: " + this.getModel()+ ", Speed in MPH: " + this.getSpeed() + ", Range in miles: " + this.getRange() + ", Price in USD: " + this.getPrice();
	}
}
