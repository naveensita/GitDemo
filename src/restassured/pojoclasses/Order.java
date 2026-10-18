package restassured.pojoclasses;

import java.util.List;

// TODO: Auto-generated Java-doc
/**
 * The Class Order.
 * @author Naveen.Pathak
 */
public class Order {
	
	/** The orders. */
	private List<OrderDetails> orders;

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	public List<OrderDetails> getOrders() {
		return orders;
	}

	/**
	 * Sets the orders.
	 *
	 * @param orders the new orders
	 */
	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}
	

}
