package restassured.pojoclasses;

import java.util.List;

/**
 * The Class AddPlace.
 * @author Naveen.Pathak
 */
public class AddPlace {
	
	/** The accuracy. */
	private int accuracy;
	/** The name. */
	private String name;
	/** The phone number. */
	private String phone_number;
	/** The address. */
	private String address;
	/** The website. */
	private String website;
	/** The language. */
	private String language;
	/** The location. */
	private Location location;
	/** The types. */
	private List<String> types;
	
	/**
	 * Gets the accuracy.
	 *
	 * @return the accuracy
	 */
	public int getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Sets the accuracy.
	 *
	 * @param accuracy the new accuracy
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhone_number() {
		return phone_number;
	}
	
	/**
	 * Sets the phone number.
	 *
	 * @param phone_number the new phone number
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	
	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Gets the types.
	 *
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}
	
	/**
	 * Sets the types.
	 *
	 * @param types the new types
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}
	

}
