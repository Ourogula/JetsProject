package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private ArrayList<Jet> fleet;

	public Airfield() {
		this.fleet = new ArrayList<>();
	}

	// Get the size of the collection
	public int getSize() {
		return fleet.size();
	}

	// Calls fly() on all jets in the fleet
	public void flyJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	// Calls fly() on all jets in the fleet
	public void razeMechaDragons() {
		for (Jet jet : fleet) {
			if (jet instanceof MechaDragon) {
				((MechaDragon)jet).setFire();
			}
		}
	}

	// Calls fly() on all jets in the fleet
	public void sneakStealthJets() {
		for (Jet jet : fleet) {
			if (jet instanceof StealthJet) {
				((StealthJet) jet).sneak();
			}
		}
	}

	// Calls fly() on all jets in the fleet
	public void loadPassengerJets() {
		for (Jet jet : fleet) {
			if (jet instanceof PassengerJet) {
				((PassengerJet)jet).loadCargo();
			}
		}
	}

	//Get Fastest jet in fleet	
	public void getFastestJet() {
		Jet fastest = null;
		double max = 0.0;
		for (Jet jet : fleet) {
			if (jet.getSpeed() > max) {
				max = (double) jet.getSpeed();
				fastest = jet;
			}
		}
		System.out.println("The fastest jet's specs: " + fastest);
	}
	
	//Get longest Range jet in fleet
	public void getLongestRange() {
		Jet furthest = null;
		Long max = 0L;
		for (Jet jet : fleet) {
			if (jet.getRange() > max) {
				max = (long) jet.getRange();
				furthest = jet;
			}
		}
		System.out.println("The longest range jet's specs: " + furthest);
	}

	// Remove a jet from the fleet
	public void removeJet(int idx) {
		fleet.remove(idx - 1);
	}

	// Add a jet to the fleet
	public void addJet(int types, String model, double speed, int range, long price) {
		if (types == 1) {
			fleet.add(new MechaDragon(model, speed, range, price));
		}
		if (types == 2) {
			fleet.add(new StealthJet(model, speed, range, price));
		}
		if (types == 3) {
			fleet.add(new PassengerJet(model, speed, range, price));
		}
	}

	// List all of the jets in the fleet
	public void listFleet() {
		int idx = 1;
		for (Jet jet : fleet) {
			System.out.println("ID:" + idx + " " + jet);
			idx++;
		}
	}

	// Import jets from file HERE
	public List<Jet> readJets(String filename) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] details = line.split(",");
				if (details[0].equals("MechaDragon")) {
					Jet jet = new MechaDragon(details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]),
							Long.parseLong(details[4]));
					fleet.add(jet);
				} else if (details[0].equals("PassengerJet")) {
					Jet jet = new PassengerJet(details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]),
							Long.parseLong(details[4]));
					fleet.add(jet);
				} else if (details[0].equals("StealthJet")) {
					Jet jet = new StealthJet(details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]),
							Long.parseLong(details[4]));
					fleet.add(jet);
				}
			}
			return fleet;
		} catch (IOException e) {
			System.err.println(e);
			return fleet;
		}
	}

}
