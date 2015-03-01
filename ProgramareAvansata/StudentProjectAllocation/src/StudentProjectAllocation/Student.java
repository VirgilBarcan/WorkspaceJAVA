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
	
	public ArrayList<Project> getStudentProjectPreferences(){
		return studentProjectPreferences;
	}
	
	public void setStudentProjectPreferences(ArrayList<Project> preferences){
		this.studentProjectPreferences = preferences;
	}
	
	public void addStudentProjectPreferences(Project preference){
		this.studentProjectPreferences.add(preference);
	}
	
	public Project getAssignedProject(){
		return studentAssignedProject;
	}
	
	public Project getFirstProjectOfStudent(){
		return studentProjectPreferences.get(0);
	}
	
	public boolean isAssigned(){
		return (studentAssignedProject == null);
	}
	
	public void assignToProject(Project project){
		studentAssignedProject = project;
	}
	
	public void deAssignFromProject(){
		studentAssignedProject = null;
	}
	
	public void deleteProjectFromStudentPreferences(Project project){
		studentProjectPreferences.remove(project);
	}
}
