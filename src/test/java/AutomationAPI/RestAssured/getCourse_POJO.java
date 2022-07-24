package AutomationAPI.RestAssured;

public class getCourse_POJO {
	private String url;
	private String services;
	private String experties;
	private Course Courses;
	private String instructor;
	private String linkedIn;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExperties() {
		return experties;
	}
	public void setExperties(String experties) {
		this.experties = experties;
	}
	public Course getCourses() {
		return Courses;
	}
	public void setCourses(Course courses) {
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	
	

	

}
