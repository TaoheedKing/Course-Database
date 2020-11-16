        
/**
 * 
 * @author Taoheed King
 *
 */
public class CourseDBElement implements Comparable{
	
	String CourseId;
	int CRN;
	int credits;
	String room;
	String teacher;
	
	/**
	 * 
	 * @param course course name
	 * @param crn course number
	 * @param credits number of credits
	 * @param room room number
	 * @param instructor instructor name
	 */
	public CourseDBElement(String course, int crn, int credits, String room, String instructor) {
		this.CourseId = course;
		this.CRN = crn;
		this.credits = credits;
		this.room = room;
		this.teacher = instructor;
	}
	
	public CourseDBElement() {
		 
	}
	
	/**
	 * @return the crn number of the course
	 */
	public int getCRN() {
		return CRN;
	}
	
	@Override
	public int compareTo(CourseDBElement element) {
		return element.CourseId.compareTo(CourseId);
	}
	
	/**
	 * 
	 * @param parseInt the crn of the course
	 */
	public void setCRN(int parseInt) {
		this.CRN = parseInt;
	}
	
}

    