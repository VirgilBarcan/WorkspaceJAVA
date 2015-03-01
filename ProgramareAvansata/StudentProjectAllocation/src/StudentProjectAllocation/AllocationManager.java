/**
 * 
 */
package StudentProjectAllocation;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class AllocationManager {
	private ArrayList<Student> students;
	private ArrayList<Lecturer> lecturers;
	private ArrayList<Project> projects;
	
	private ArrayList<Boolean> studentIsFree;
	private ArrayList<Boolean> lecturerIsFree;
	private ArrayList<Boolean> projectIsFree;
	
	private static AllocationManager singletonInstance;
	
	//Constructor -- private, for Singleton
	private AllocationManager(){
		Initialize();
	}
	
	public static AllocationManager getInstance(){
		if (AllocationManager.singletonInstance == null){
			AllocationManager.singletonInstance = new AllocationManager();
			return AllocationManager.singletonInstance;
		}
		else{
			return AllocationManager.singletonInstance;
		}
	}

	private void Initialize(){
		students  = new ArrayList<Student>();
		lecturers = new ArrayList<Lecturer>();
		projects  = new ArrayList<Project>();
		
		studentIsFree  = new ArrayList<Boolean>();
		lecturerIsFree = new ArrayList<Boolean>();
		projectIsFree  = new ArrayList<Boolean>();
	}
	
	public void setStudents(ArrayList<Student> students){
		this.students = students;
	}
	
	public void setLecturers(ArrayList<Lecturer> lecturers){
		this.lecturers = lecturers;
	}
	
	public void setProjects(ArrayList<Project> projects){
		this.projects = projects;
	}
	
	private int getNoOfStudents(){
		return students.size();
	}
	
	private int getNoOfLecturers(){
		return lecturers.size();
	}
	
	private int getNoOfProjects(){
		return projects.size();
	}
	
	private void setStudentsFree(){
		int noOfStudents;
		noOfStudents = this.getNoOfStudents();
		
		for (int i = 0; i < noOfStudents; ++i){
			studentIsFree.add(true);
		}
	}
	
	private void setLecturersFree(){
		int noOfLecturers;
		noOfLecturers = this.getNoOfLecturers();
		
		for (int i = 0; i < noOfLecturers; ++i){
			lecturerIsFree.add(true);
		}
	}
	
	private void setProjectsFree(){
		int noOfProjects;
		noOfProjects = this.getNoOfProjects();
		
		for (int i = 0; i < noOfProjects; ++i){
			projectIsFree.add(true);
		}
	}
	
	private boolean isStudentFree(int studentNo){
		return studentIsFree.get(studentNo);
	}
	
	private boolean isLecturerFree(int lecturerNo){
		return lecturerIsFree.get(lecturerNo);
	}
	
	private boolean isProjectFree(int projectNo){
		return projectIsFree.get(projectNo);
	}
	
	private Student getFirstFreeStudent(){
		int noOfStudents;
		noOfStudents = this.getNoOfStudents();
		
		for (int i = 0; i < noOfStudents; ++i){
			if (isStudentFree(i) == true){
				return students.get(i);
			}
		}
		return null;
	}
	
	private Lecturer getLecturerWhoOffersProject(Project project){
		for (Lecturer lecturer : lecturers){
			if (lecturer.isOfferingProject(project) == true){
				return lecturer;
			}
		}
		return null;
	}
	
	//StartAllocation
	public void startAllocation(){
		this.setStudentsFree();
		this.setLecturersFree();
		this.setProjectsFree();
		
		Student firstFreeStudent; //Si
		firstFreeStudent = this.getFirstFreeStudent();
		
		while((firstFreeStudent != null) && (firstFreeStudent.getNoOfPreferences() != 0)){
			Project firstProjectOfStudent;
			firstProjectOfStudent = firstFreeStudent.getFirstProjectOfStudent();
			
			Lecturer lecturerWhoOffersProject;
			
		}
	}
	
}
