/**
 * 
 */
package StudentProjectAllocation;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Virgil Barcan
 *
 */
public class Lecturer {
	private Integer lecturerID;
	private Integer lecturerCapacity;
	private ArrayList<Project> lecturerProjects;
	private Hashtable<Project, ArrayList<Student>> lecturerStudentPreferences;
	
	private static int lastLecturerID = 1;
	
	//Constructors
	public Lecturer(){
		Initialize();
		
		lecturerID = Lecturer.lastLecturerID;
		++Lecturer.lastLecturerID;
	}
	
	public Lecturer(Integer lecturerID, Integer lecturerCapacity, ArrayList<Project> lecturerProjects, Hashtable<Project, ArrayList<Student>> lecturerStudentPreferences){
		Initialize();
		
		this.lecturerID = lecturerID;
		this.lecturerCapacity = lecturerCapacity;
		this.lecturerProjects = lecturerProjects;
		this.lecturerStudentPreferences = lecturerStudentPreferences;
		
		if (Lecturer.lastLecturerID < lecturerID){
			Lecturer.lastLecturerID = lecturerID;
		}
		else{
			++Lecturer.lastLecturerID;
		}
	}
	
	private void Initialize(){
		lecturerID = 0;
		lecturerCapacity = 0;
		lecturerProjects = new ArrayList<Project>();
		lecturerStudentPreferences = new Hashtable<Project, ArrayList<Student>>();
	}
	
	public boolean isOfferingProject(Project project){
		for (Project p : lecturerProjects){
			if (p.equals(project) == true){
				return true;
			}
		}
		return false;
	}
	
	public boolean isOverCapacity(){
		if (lecturerCapacity < 0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if (lecturerCapacity == 0)
			return true;
		return false;
	}
	
	public Hashtable<Project, ArrayList<Student>> getLecturerPreferences(){
		return lecturerStudentPreferences;
	}
	
	public ArrayList<Student> getLecturerPreferencesForProject(Project project){
		return lecturerStudentPreferences.get(project);
	}
	
	public void setLecturerPreferences(ArrayList<Student> students){
		//add each student to its project list
	}
	
	public void setLecturerPreferencesForProject(Hashtable<Project, ArrayList<Student>> preferences){
		this.lecturerStudentPreferences = preferences;
	}
	
	public ArrayList<Project> getLecturerProjects(){
		return lecturerProjects;
	}
	
	public void setLecturerProjects(ArrayList<Project> projects){
		this.lecturerProjects = projects;
	}
	
	public int getNoOfPreferences(){
		return lecturerStudentPreferences.size() - 1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lecturer [lecturerID=" + lecturerID + ", lecturerCapacity="
				+ lecturerCapacity + ", lecturerProjects=" + lecturerProjects
				+ ", lecturerStudentPreferences=" + lecturerStudentPreferences
				+ "]";
	}

	public void deleteAllFromPreferenceListForProject(Student student, Project project){
		int indexOfStudent;
		indexOfStudent = lecturerStudentPreferences.get(project).indexOf(student);
		
		int noOfPreferences;
		noOfPreferences = this.getNoOfPreferences();
		
		for (int i = noOfPreferences; i >= indexOfStudent; --i){
			lecturerStudentPreferences.get(project).remove(i);
		}
	}
}
