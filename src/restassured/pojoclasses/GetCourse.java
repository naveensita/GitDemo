package restassured.pojoclasses;

/**
 * The Class GetCourse.
 * @author Naveen.Pathak
 */
public class GetCourse {
	
	/** The instructor. */
	private String instructor;
	/** The url. */
	private String url;
	/** The services. */
	private String services;
	/** The expertise. */
	private String expertise;
	/** The courses. */
	private Courses courses;
	/** The linked in. */
	private String linkedIn;
	
	/**
	 * Gets the instructor.
	 *
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * Sets the instructor.
	 *
	 * @param instructor the new instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public String getServices() {
		return services;
	}
	
	/**
	 * Sets the services.
	 *
	 * @param services the new services
	 */
	public void setServices(String services) {
		this.services = services;
	}
	
	/**
	 * Gets the expertise.
	 *
	 * @return the expertise
	 */
	public String getExpertise() {
		return expertise;
	}
	
	/**
	 * Sets the expertise.
	 *
	 * @param expertise the new expertise
	 */
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	/**
	 * Gets the courses.
	 *
	 * @return the courses
	 */
	public Courses getCourses() {
		return courses;
	}
	
	/**
	 * Sets the courses.
	 *
	 * @param courses the new courses
	 */
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	
	/**
	 * Gets the linked in.
	 *
	 * @return the linked in
	 */
	public String getLinkedIn() {
		return linkedIn;
	}
	
	/**
	 * Sets the linked in.
	 *
	 * @param linkedIn the new linked in
	 */
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
}
