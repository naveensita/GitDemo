package restassured.pojoclasses;

/**
 * The Class WebAutomation.
 * @author Naveen.Pathak
 */
public class WebAutomation {
	
	private String courseTitle;
	private String price;
	
	/**
	 * Gets the course title.
	 *
	 * @return the course title
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	
	/**
	 * Sets the course title.
	 *
	 * @param courseTitle the new course title
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
}
