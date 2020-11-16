        
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 
 * @author Taoheed King
 * 
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure table;

	public CourseDBManager() {
		table = new CourseDBStructure(10);
	}
	
	/**
	 * @param id the id of the course
	 * @param crn the crn number
	 * @param credits the number of credits
	 * @param roomNum the room number
	 * @param instructor the name of instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		table.add(element);
	}

	/**
	 * @param crn the course number of the course
	 * @return the course that belongs to the crn
	 */
	public CourseDBElement get(int crn) {
		try {
			return table.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param input a file to place into hash table
	 */
	public void readFile(File input) throws FileNotFoundException {
		Scanner read = new Scanner (input);
		String CourseId;
		int CRN;
		int credits;
		String room;
		String instruct = "";
		
		String line;
		while(read.hasNextLine()) {
			line = read.nextLine();
			Scanner readline = new Scanner(line);
			
			while(readline.hasNext()) {
				CourseId = readline.next();
				CRN = Integer.parseInt(readline.next());
				credits = Integer.parseInt(readline.next());
				room = readline.next();
				while(readline.hasNext()){
					instruct += readline.next();
				}
				add(CourseId, CRN,credits, room, instruct);
				instruct = ""; 
				}
			readline.close();
		}
	
		read.close();
	} 

	//implementing
/**
 * @return returns and arraylist with courses
 */
	public ArrayList<String> showAll() {
		ArrayList<String> toString = new ArrayList<String>();
			for(int i=0;i<table.hashTable.length;i++) {
				if(table.hashTable[i] != null) {
				for(CourseDBElement course: table.hashTable[i]) {
					toString.add(table.ElementString(course));
			}
				} 
				
		}
			return toString;
	}
	
}

    