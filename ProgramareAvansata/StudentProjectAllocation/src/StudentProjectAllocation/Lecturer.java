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
	private ArrayList<Student> lecturerPreferences;
	
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
		this.lecturerPreferences = new ArrayList<Student>();
	}
	
	public int getLecturerID(){
		return this.lecturerID;
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
	
	public ArrayList<Student> getLecturerPreferencesList(){
		return lecturerPreferences;
	}
	
	public void setLecturerPreferences(ArrayList<Student> students){
		this.lecturerPreferences = students;
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

	public int getNoOfPreferencesForProject(Project project){
		return lecturerStudentPreferences.get(project).size() - 1;
	}
	
	public void deleteAllFromPreferenceListForProject(Student student, Project project){
		int indexOfStudent;
		indexOfStudent = lecturerStudentPreferences.get(project).indexOf(student);
		
		int noOfPreferences;
		noOfPreferences = this.getNoOfPreferencesForProject(project);
		
		lecturerPreferences.remove(student);
		
		for (int i = indexOfStudent; i <= noOfPreferences; ++i){
			if (lecturerStudentPreferences.get(project).get(i) != null){
				lecturerStudentPreferences.get(project).remove(i);
			}
		}
	}
	
	public void deleteStudentFromPreferenceListForProject(Student student, Project project){
		lecturerPreferences.remove(student);
		
		lecturerStudentPreferences.get(project).remove(student);
		
	}
	
	public void setLecturerCapacity(int capacity){
		this.lecturerCapacity = capacity;
	}
	
	public int getLecturerCapacity(){
		return this.lecturerCapacity;
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
	
}
