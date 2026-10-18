package restassured.pojoclasses;

import java.util.List;

/**
 * The Class Courses.
 * @author Naveen.Pathak
 */
public class Courses {
	
	/** The web automation. */
	private List<WebAutomation> webAutomation;
	/** The api. */
	private List<Api> api;
	/** The mobile. */
	private List<Mobile> mobile;
	
	/**
	 * Gets the web automation.
	 *
	 * @return the web automation
	 */
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	
	/**
	 * Sets the web automation.
	 *
	 * @param webAutomation the new web automation
	 */
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	
	/**
	 * Gets the api.
	 *
	 * @return the api
	 */
	public List<Api> getApi() {
		return api;
	}
	
	/**
	 * Sets the api.
	 *
	 * @param api the new api
	 */
	public void setApi(List<Api> api) {
		this.api = api;
	}
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public List<Mobile> getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	

}
