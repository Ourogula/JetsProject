package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	private Scanner sc;

	public static void main(String[] args) {
		Airfield airfield = new Airfield();
		JetsApplication app = new JetsApplication();

		airfield.readJets("Jets.txt");

		app.run(airfield);
	}

	private void printMenu() {
		System.out.println("******************************");
		System.out.println("* 1. List Fleet              *");
		System.out.println("* 2. Fly Fleet               *");
		System.out.println("* 3. View fastest jet        *");
		System.out.println("* 4. View longest range jet  *");
		System.out.println("* 5. Raze the world!         *");
		System.out.println("* 6. Sneak around            *");
		System.out.println("* 7. Ferry mankind           *");
		System.out.println("* 8. Add a jet to Fleet      *");
		System.out.println("* 9. Remove a jet from Fleet *");
		System.out.println("* 10. Quit                   *");
		System.out.println("******************************");
	}

	private String inputName(Scanner sc) {
		String name = "";
		while (true) {
			System.out.println("Please enter the name of your jet: ");
			try {
				name = sc.nextLine();
				if (name.trim().equals("")) {
					System.out.println("Please enter a valid name.");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				System.out.println("Please enter a valid name.");
			}
		}
		return name;
	}

	private int inputRange(Scanner sc) {
		int range = 0;
		while (true) {
			System.out.println("Please enter the range of your jet: ");
			try {
				range = sc.nextInt();
				break;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Please enter a valid range.");
			}
		}
		return range;
	}

	private double inputSpeed(Scanner sc) {
		double speed = 0.0;
		while (true) {
			System.out.println("Please enter the speed of your jet: ");
			try {
				speed = sc.nextDouble();
				break;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Please enter a valid speed.");
			}
		}
		return speed;
	}

	private Long inputPrice(Scanner sc) {
		long price = 0L;
		while (true) {
			System.out.println("Please enter the price of your jet (in USD) : ");
			try {
				price = sc.nextLong();
				break;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Please enter a valid price.");
			}
		}
		return price;
	}

	public void run(Airfield fleet) {
		boolean keepPlaying = true;
		int input = 0;
		sc = new Scanner(System.in);

		while (keepPlaying) {
			while (true) {
				printMenu();
				System.out.println("Please choose an option from the menu:");
				try {
					input = sc.nextInt();
					if (input > 0 && input < 11) {
						sc.nextLine();
						break;
					} else {
						sc.nextLine();
						System.out.println("Please enter a valid number from the menu!");
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Please enter a valid number from the menu!");
				}
			}
			switch (input) {
			// List Fleet
			case 1:
				fleet.listFleet();
				break;

			// Fly Fleet
			case 2:
				fleet.flyJets();
				break;

			// View Fastest Jet
			case 3:
				fleet.getFastestJet();
				break;

			// View longest range Jet
			case 4:
				fleet.getLongestRange();
				break;

			// Dragons Breath Fire
			case 5:
				fleet.razeMechaDragons();
				break;

			// Stealth Jets act stealthily
			case 6:
				fleet.sneakStealthJets();
				break;

			// Passenger Jets carry people
			case 7:
				fleet.loadPassengerJets();
				break;

			// Lets add a jet
			case 8:
				String type = "";
				while (true) {
					System.out.println("Please choose a type of jet to create: ");
					System.out.println("Type '1' for a Mechanical Dragon");
					System.out.println("Type '2' for a Stealth Jet");
					System.out.println("Type '3' for a Passenger Jet");
					try {
						type = sc.nextLine();
						if (Integer.parseInt(type) > 0 && Integer.parseInt(type) < 4) {
							break;
						} else {
							System.out.println("Please enter a valid number from the menu!");
						}
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
						System.out.println("Please enter a valid number from the menu!");
					}
				}
				int types = Integer.parseInt(type);
				fleet.addJet(types, inputName(sc), inputSpeed(sc), inputRange(sc), inputPrice(sc));
				break;

			// Lets remove a Jet
			case 9:
				int idx = 0;
				boolean multiplePlanes = true;
				while (multiplePlanes) {
					System.out.println("Please enter the number of the jet you would like to remove: ");
					fleet.listFleet();
					try {
						idx = sc.nextInt();
						if (fleet.getSize() == 1) {
							System.out.println("Can't remove the last jet!");
							multiplePlanes = false;
						} else if (idx >= fleet.getSize() || idx < 1) {
							System.out.println("Please enter a valid number from the fleet.");
							continue;
						}
						break;
					} catch (Exception e) {
						sc.nextLine();
						System.out.println("Please enter a valid number from the fleet!");
					}
				}
				if (multiplePlanes) {
					fleet.removeJet(idx);
				}
				break;

			// I'm done with this!
			case 10:
				System.out.println("Goodbye!");
				keepPlaying = false;
			}

			input = 0;

		}
		sc.close();
	}
}