/**
 * 
 */
package StudentProjectAllocation;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class Lecturer {
	private Integer lecturerID;
	private ArrayList<Project> lecturerProjects;
	private ArrayList<Student> lecturerStudentPreferences;
	
	private static int lastLecturerID = 0;
	
	//Constructors
	public Lecturer(){
		Initialize();
		
		lecturerID = Lecturer.lastLecturerID;
		++Lecturer.lastLecturerID;
	}
	
	public Lecturer(Integer lecturerID, ArrayList<Project> lecturerProjects, ArrayList<Student> lecturerStudentPreferences){
		Initialize();
		
		this.lecturerID = lecturerID;
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
		lecturerProjects = new ArrayList<Project>();
		lecturerStudentPreferences = new ArrayList<Student>();
	}
	
	public boolean isOfferingProject(Project project){
		for (Project p : lecturerProjects){
			if (p.equals(project) == true){
				return true;
			}
		}
		return false;
	}
}
