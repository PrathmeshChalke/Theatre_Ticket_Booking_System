package theatreOperations;

public class Ticket {

	Customer customer;
	float price = 50;

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the show
	 **
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public Ticket(Customer customer, float price) {
		this.customer = customer;
		this.price = price * customer.getChoiceOfSeats().length;
	}

}
