package theatreOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheatreMaintenance {

	public Screen screen = new Screen();

	public static void main(String[] args) {
		Screen s = new Screen();
		int capacity = 50;
		Ticket t = null;
		String ans = "default";
		while (!ans.equals("exit")) {
			System.out.println("Welcome to " + "Theartre Maintenance System");

			System.out.println("Are you Owner ([Yes/y]/[No/n])?");
			System.out.println("Press 'exit' for exiting");

			Scanner sc = new Scanner(System.in);
			ans = sc.next();
			if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
				String choice = "pa";

				while (!choice.equals("exit")) {
					System.out.println("Press v for viewing report");
					System.out.println("Press g for generating report");
					System.out.println("Press 'exit' for exiting");
					choice = sc.next();

					switch (choice) {
					case "v":
					case "V": {
						System.out.println("Report viwed");
						break;
					}

					case "g":
					case "G": {
						System.out.println("Report generated");
						break;
					}
					case "exit": {
						System.out.println("Thankyou Goodbye");
						break;
					}
					default:
						System.out.println("Invalid choice");
						break;
					}
				}

			} else if (ans.equalsIgnoreCase("No") || ans.equalsIgnoreCase("n")) {
				String choice = "mac";
				while (!choice.equalsIgnoreCase("exit")) {
					System.out.println("Press B for booking ticket");
					System.out.println("Press V for viewing shows");
					System.out.println("If you want to 'exit' enter exit");
					choice = sc.next();

					switch (choice) {

					case "V":
					case "v":

						System.out.println("Our currently running show is Drishyam 2");
						System.out.println("The capacity of theatre is " + capacity);
						System.out.println("Available Shows are: ");
						System.out.println(" " + "Morning Show" + " \n " + "Afternoon Show" + " \n " + "Evening Show"
								+ " \n " + "Night Show");
						break;

					case "B":
					case "b":
						ArrayList<Customer> bookers = new ArrayList<>();

						TheatreMaintenance tm = new TheatreMaintenance();

						Customer cust = tm.takeInput();
						bookers.add(new Customer(cust.getCustomerName(), cust.getChoiceOfSeats(), cust.getShowtime()));

						// System.out.println("The available seats are " +
						// screen.getTotalAvailableSeats(cust.getShowtime()));
						t = s.issueTicket(bookers.remove(0), cust.getChoiceOfSeats(), cust.getShowtime());
						if (null != t) {
							System.out.println(
									"The available seats are now " + (s.getTotalAvailableSeats(cust.getShowtime())));
						}
						if (null != t) {
							TicketPrint.FileWriter(t);
						} else {
							System.out.println(
									"Ticket could not be printed as you entered the same booked seat, try again");
						}
						break;

					case "exit":
						System.out.println("Thanku GoodBye");
						break;

					default:
						System.out.println("Invalid choice");
						break;

					}

				}
			} else if (ans.equals("exit")) {
				System.out.println("Thankyou Visit again");
			} else {
				System.out.println("Invalid user");
			}
		}

	}

	@SuppressWarnings("static-access")
	public Customer takeInput() {
		Scanner sc = new Scanner(System.in);
		String name;
		Customer c = new Customer();
		System.out.println("Enter Your Name");
		name = sc.next();
		while (!name.matches("[A-Za-z]*")) {
			System.out.println("Please retype name only in aplhabets form");
			name = sc.next();
		}
		String showName;
		System.out.println("Enter show you want (m:mornning/a:afternoon/e:evening/n:night)");
		showName = sc.next();
		while (!(showName.equalsIgnoreCase("M") || showName.equalsIgnoreCase("e") || showName.equalsIgnoreCase("a")
				|| showName.equalsIgnoreCase("n"))) {
			System.out.println("Enter m , e , a , n");
			showName = sc.next();
		}

		Map<Integer, String> showMap = screen.getShowMap(showName);
		screen.displaySeats((HashMap<Integer,String>) showMap);
		System.out.println();
		System.out.println("Enter number of tickets");
		int no = sc.nextInt();
		if (no == 0) {
			do {
				System.out.println("Number cant be zero");
				no = sc.nextInt();
				break;
			} while (no != 0);
		}
		int[] seatsChoice = new int[no];
		System.out.println("Enter the choice of noseats");

		takeSeatInput(sc, seatsChoice);
		boolean aresSeatsValid = validateSeats(seatsChoice);
		if (!aresSeatsValid) {
			while (aresSeatsValid != true) {
				takeSeatInput(sc, seatsChoice);
				aresSeatsValid = validateSeats(seatsChoice);
			}
		}

		c.setCustomerName(name);
		c.setChoiceOfSeats(seatsChoice);
		c.setShowtime(showName);

		return c;

	}

	public void takeSeatInput(Scanner sc, int[] seatsChoice) {
		int x = 0;
		while (x < seatsChoice.length) {
			int duplicated = 0;

			seatsChoice[x] = sc.nextInt();

			for (int y = 0; y < x; y++) {
				if (seatsChoice[x] == seatsChoice[y]) {
					System.out.println("You already choosed this seat number,please enter another\n");
					duplicated = 1;
					break;
				}
			}

			if (duplicated != 1)
				x++;
		}
	}

	private boolean validateSeats(int[] seatsChoice) {
		boolean isValid = true;
		for (int i = 0; i < seatsChoice.length; i++) {
			if (seatsChoice[i] < 0 || seatsChoice[i] > Screen.CAPACITY) {
				isValid = false;
				System.out.println("out of bound seats should be between 1 to " + Screen.CAPACITY);
				break;
			}
		}
		return isValid;

	}

}
