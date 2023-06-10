package theatreOperations;

import java.util.HashMap;
import java.util.Map;

public class Screen {

	Show show = new Show();
	public static final int CAPACITY = 50;

	Screen() {

	}

	public int getTotalAvailableSeats(String ShowTime) {
		int count = 0;
		HashMap<Integer, String> allocationMap = null;
		allocationMap = getShowMap(ShowTime);

		for (int i = 1; i < CAPACITY + 1; i++) {
			if (null != allocationMap) {
				if (null != allocationMap.get(i)) {
					if (allocationMap.get(i).equals("empty")) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public HashMap<Integer, String> getShowMap(String ShowTime) {
		HashMap<Integer, String> allocationMap;
		if (ShowTime.equalsIgnoreCase(TheatreConstants.morningShow)) {
			allocationMap = show.getMorning();
		} else if (ShowTime.equalsIgnoreCase(TheatreConstants.afternoonShow)) {
			allocationMap = show.getAfternoon();
		} else if (ShowTime.equalsIgnoreCase(TheatreConstants.eveningShow)) {
			allocationMap = show.getEvening();
		} else if (ShowTime.equalsIgnoreCase(TheatreConstants.nightShow)) {
			allocationMap = show.getNight();
		} else {
			allocationMap = null;
		}
		return allocationMap;
	}

	public Ticket issueTicket(Customer customer, int seat[], String showTime) {
		Ticket t = null;
		int count = getTotalAvailableSeats(customer.getShowtime());
		HashMap<Integer, String> allocationMap = null;
		allocationMap = getShowMap(showTime);
		if (!allocationMap.isEmpty()) {
			boolean areAllEmpty = true;
			if (seat.length < count) {
				for (int s : seat) {
					if (!allocationMap.get(s).equalsIgnoreCase("empty")) {
						areAllEmpty = false;
						return null;
					}
				}
				if (areAllEmpty) {
					boolean isAllSeatsAvailable = areAllSeatsAvaialable(allocationMap, seat);

					if (isAllSeatsAvailable) {
						for (int s : seat) {
							allocationMap.put(s, customer.customerName);
							System.out.println("Booking confiremd:\nSeat no: " + s + " Name: " + customer.customerName
									+ "\n\n" + customer.getShowtime());
						}
						t = new Ticket(customer, 50);
						System.out.println("Name of Ticket Holder " + t.customer.getCustomerName());
						System.out
								.println("Number of ticket the holder booked " + t.customer.getChoiceOfSeats().length);
						System.out.println("Tickets are ");
						for (int i = 0; i < t.customer.getChoiceOfSeats().length; i++) {
							System.out.print(t.customer.getChoiceOfSeats()[i] + " ");
						}
						System.out.println();
						System.out.println("Price Total is " + t.getPrice());
						displaySeats(allocationMap);
						return t;
					} else {
						return null;
					}
				} else {
					System.out.println("That seat is already booked");
					return null;
				}
			} else {
				System.out.println("Housefull!!!!");
				return null;
			}
		} else {
			System.out.println("Invalid Showtime");
			return null;
		}
	}

	public static boolean areAllSeatsAvaialable(HashMap<Integer, String> list, int arr[]) {
		boolean isAvaialble = true;
		for (int s : arr) {
			if (list.get(s) != null)
				if (!(list.get(s).equalsIgnoreCase("empty"))) {
					isAvaialble = false;
					break;

				}
		}

		return isAvaialble;

	}

	public static void displaySeats(HashMap<Integer, String> allocationMap) {
		System.out.println("Current allocation status : ");
		for (Map.Entry<Integer, String> entry : allocationMap.entrySet()) {
			System.out.print("[");
			if (!entry.getValue().equalsIgnoreCase("empty")) {
				System.out.print(entry.getKey() + " , " + entry.getValue());
			} else {
				System.out.print(entry.getKey() + ", __");
			}
			System.out.print("],");
			// System.out.println();
		}
	}

}
