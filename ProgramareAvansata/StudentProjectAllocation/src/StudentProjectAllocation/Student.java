/**
 * 
 */
package StudentProjectAllocation;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class Student {
	private Integer studentID;
	private ArrayList<Project> studentProjectPreferences;
	private Project studentAssignedProject;
	
	private static int lastStudentID = 0;
	
	//Constructors
	public Student(){
		Initialize();
		
		studentID = Student.lastStudentID;
		++Student.lastStudentID;
	}
	
	public Student(Integer studentID, ArrayList<Project> studentProjectPreferences){
		Initialize();
		
		studentID = Student.lastStudentID;
		this.studentProjectPreferences = studentProjectPreferences;
		
		if (Student.lastStudentID < studentID){
			Student.lastStudentID = studentID;
		}
		else{
			++Student.lastStudentID;
		}
	}
	
	private void Initialize(){
		studentID = 0;
		studentProjectPreferences = new ArrayList<Project>();
		studentAssignedProject = new Project();
	}
	
	public int getNoOfPreferences(){
		return studentProjectPreferences.size();
	}
	
	public Project getFirstProjectOfStudent(){
		return studentProjectPreferences.get(0);
	}
}
