        
import java.io.IOException;
import java.util.*;
/**
 * 
 * @author Taoheed King
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	protected LinkedList<CourseDBElement> [] hashTable;
	
	private int tablesize;
	//implementing
	
	/**
	 * @param size the estimated size of the hashtable
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		this.hashTable = new LinkedList[size];
		tablesize = size;
		
	}
	
	/**
	 * 
	 * @param test for testing purposes
	 * @param size size of hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int size) {
		this.hashTable = new LinkedList[size];
	}
	
	/**
	 * 
	 * @param element the course to be placed into hashtable
	 * @return the index of the course in the hash table
	 */
	private int hash(CourseDBElement element) {
		String crn = String.valueOf(element.CRN);
		return crn.hashCode() % hashTable.length;
	}

	@SuppressWarnings("unchecked")
	/**
	 * @param element the course to add 
	 */
	public void add(CourseDBElement element) {
		LinkedList[] temp;
		
		if(hash(element) > hashTable.length) {
			
			temp = new LinkedList [hash(element)+1];
			
			for(int i=0; i<hashTable.length;i++) {
				temp[i] = hashTable[i];
			}
			for(int i=hashTable.length; i<=hash(element);i++) {
				temp[i] = new LinkedList<CourseDBElement>();
			}
			
			hashTable = temp;   
		}
		else if(hashTable[hash(element)] == null) {
			hashTable[hash(element)] = new LinkedList<CourseDBElement>();
		}
		hashTable[hash(element)].add(element);
	}

	
	/**
	 * @param use the crn number to find and retrieve
	 * @return CourseDBElement the course with the crn number
	 */
	public CourseDBElement get(int crn) throws IOException {
		String Stringcrn = String.valueOf(crn);
		LinkedList<CourseDBElement> tableElement = hashTable[Stringcrn.hashCode()%tablesize];
		
		for(CourseDBElement course: tableElement) {
			if(course.CRN == crn) {
				return course;
			}
		}
		
		return null;
	}

	/**
	 * @return the size of table 
	 */
	public int getTableSize() {
		return hashTable.length;
	}
	
	/**
	 * 
	 * @param element element to turn into string
	 * @return the course in a string notation
	 */
	public String ElementString(CourseDBElement element) {
		String CourseData = "\nCourse: " + element.CourseId + " CRN: " + element.CRN + " Credits: " + element.credits +
				" Instructor: " + element.teacher + " Room: "+element.room +"";
		return CourseData;

	}


}

    