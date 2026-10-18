package restassured.pojoclasses;

// TODO: Auto-generated Jav-adoc
/**
 * The Class EcommerceAddProductResponse.
 * @author Naveen.Pathak
 */
public class EcommerceAddProductResponse {
	
	/** The token. */
	private String productId;
	/** The user id. */
	private String message;
	
	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
