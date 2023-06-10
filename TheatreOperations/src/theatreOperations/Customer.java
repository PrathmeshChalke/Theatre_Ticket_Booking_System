package theatreOperations;

public class Customer {
	
	String customerName;
	int seats[];
	String showtime;

	/**
	 * @return the choiceOfSeats
	 */
	public Customer(String customerName, int seats[], String showTime) {
		// TODO Auto-generated constructor stub
		this.customerName = customerName;
		this.seats = seats;
		this.showtime = showTime;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the seats
	 */
	public int[] getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int[] seats) {
		this.seats = seats;
	}

	/**
	 * @return the showtime
	 */
	public String getShowtime() {
		return showtime;
	}

	/**
	 * @param showtime the showtime to set
	 */
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	/**
	 * @param customerName the customerName to set
	 */

	public int[] getChoiceOfSeats() {
		return seats;
	}

	/**
	 * @param choiceOfSeats the choiceOfSeats to set
	 */
	public void setChoiceOfSeats(int[] choiceOfSeats) {
		this.seats = choiceOfSeats;
	}

	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @return the noOfTickets
	 */
	public void setCustomerName(String name) {
		// TODO Auto-generated method stub
		this.customerName = name;

	}

}

