package com.skilldistillery.jets.entities;

public class MechaDragon extends Jet implements Firebreathing {

	public MechaDragon(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly () {
		int intFlytime =  (int) ((this.getRange()/this.getSpeed() ) * 100);
		double flytime = ((double) intFlytime) / 100;
		System.out.println("Fly across the lands with wings of steel! Flight time: " + flytime + " hours");
	}
	
	public void setFire () {
		System.out.println("Raze the lands, harvest the crops of the world!");
	}

	@Override
	public String toString() {
		return "MechaDragon: Model: " + this.getModel()+ ", Speed in MPH: " + this.getSpeed() + ", Range in miles: " + this.getRange() + ", Price in USD: " + this.getPrice();
	}
}
