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
			if (students.get(i).isAssigned() == false){
				return students.get(i);
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AllocationManager \n[students=" + students + ", lecturers="
				+ lecturers + ", projects=" + projects + ", studentIsFree="
				+ studentIsFree + ", lecturerIsFree=" + lecturerIsFree
				+ ", projectIsFree=" + projectIsFree + "]";
	}

	private Lecturer getLecturerWhoOffersProject(Project project){
		for (Lecturer lecturer : lecturers){
			if (lecturer.isOfferingProject(project) == true){
				return lecturer;
			}
		}
		return null;
	}
	
	private Student getWorstStudentForProject(Project project){
		ArrayList<Student> lecturerStudentsPreferences;
		Lecturer lecturer;
		lecturer = this.getLecturerWhoOffersProject(project);
		lecturerStudentsPreferences = lecturer.getLecturerPreferencesForProject(project);
		
		int lastIndex = lecturerStudentsPreferences.size();
		return lecturerStudentsPreferences.get(lastIndex - 1);
	}
	
	private Student getWorstStudentForLecturerForProject(Lecturer lecturer, Project project){
		ArrayList<Student> lecturerStudentsPreferences;
		lecturerStudentsPreferences = lecturer.getLecturerPreferencesForProject(project);
		
		int lastIndex = lecturerStudentsPreferences.size();
		return lecturerStudentsPreferences.get(lastIndex - 1);
	}
	
	private ArrayList<Project> getProjectsOfferedByLecturerAcceptableForStudent(Lecturer lecturer, Student student){
		ArrayList<Project> projectsOfferedByLecturer;
		projectsOfferedByLecturer = lecturer.getLecturerProjects();
		
		ArrayList<Project> projectsAcceptableForStudent;
		projectsAcceptableForStudent = student.getStudentProjectPreferences();
		
		ArrayList<Project> result;
		result = new ArrayList<Project>();
		
		for (Project projectL : projectsOfferedByLecturer){
			if (projectsAcceptableForStudent.contains(projectL) == true){
				result.add(projectL);
			}
		}
		
		return result;
	}
	
	//StartAllocation
	public void startAllocation(){
		this.setStudentsFree();
		this.setLecturersFree();
		this.setProjectsFree();
		
		Student firstFreeStudent; //Si
		firstFreeStudent = this.getFirstFreeStudent();
		
		while((firstFreeStudent != null) && (firstFreeStudent.getNoOfPreferences() != 0)){
			
			System.out.println("startAllocation()");
			
			System.out.println("student: " + firstFreeStudent.toString());
			
			Project firstProjectOfStudent; //Pj
			firstProjectOfStudent = firstFreeStudent.getFirstProjectOfStudent();
			
			System.out.println("firstProject: " + firstProjectOfStudent.toString());
			
			Lecturer lecturerWhoOffersProject; //Lk
			lecturerWhoOffersProject = this.getLecturerWhoOffersProject(firstProjectOfStudent);
			
			System.out.println("lecturer: " + lecturerWhoOffersProject.toString());
			
			firstProjectOfStudent.assignStudent(firstFreeStudent);
			firstFreeStudent.assignToProject(firstProjectOfStudent);
			
			if (firstProjectOfStudent.isOverCapacity() == true){
				Student worstStudent; //Sr
				worstStudent = this.getWorstStudentForProject(firstProjectOfStudent);
				
				firstProjectOfStudent.deAssignStudent(worstStudent);
				worstStudent.deAssignFromProject();
			}
			else
				if (lecturerWhoOffersProject.isOverCapacity() == true){
					Student worstStudent; //Sr
					Project projectOfWorstStudent;
					
					worstStudent = this.getWorstStudentForLecturerForProject(lecturerWhoOffersProject, firstProjectOfStudent);
					projectOfWorstStudent = worstStudent.getAssignedProject();
					
					projectOfWorstStudent.deAssignStudent(worstStudent);
					worstStudent.deAssignFromProject();
				}
			
			if (firstProjectOfStudent.isFull() == true){
				Student worstStudent; //Sr
				worstStudent = this.getWorstStudentForProject(firstProjectOfStudent);
				
				ArrayList<Student> lecturerStudentsPreferences;
				lecturerStudentsPreferences = lecturerWhoOffersProject.getLecturerPreferencesForProject(firstProjectOfStudent);
				
				//delete the project from all the students that are worst than worstStudent
				int worstStudentIndex;
				worstStudentIndex = lecturerStudentsPreferences.indexOf(worstStudent);
				
				for (int i = worstStudentIndex; i < lecturerStudentsPreferences.size(); ++i){
					Student student;
					student = lecturerStudentsPreferences.get(i);
					student.deleteProjectFromStudentPreferences(firstProjectOfStudent);
				}
				
				lecturerWhoOffersProject.deleteAllFromPreferenceListForProject(worstStudent, firstProjectOfStudent);
				
			}
			
			if (lecturerWhoOffersProject.isFull() == true){
				Student worstStudent; //Sr
				Project projectOfWorstStudent;
				
				worstStudent = this.getWorstStudentForLecturerForProject(lecturerWhoOffersProject, firstProjectOfStudent);
				projectOfWorstStudent = worstStudent.getAssignedProject();
				
				ArrayList<Student> lecturerStudentsPreferences;
				lecturerStudentsPreferences = lecturerWhoOffersProject.getLecturerPreferencesForProject(firstProjectOfStudent);
				
				//delete the project from all the students that are worst than worstStudent
				int worstStudentIndex;
				worstStudentIndex = lecturerStudentsPreferences.indexOf(worstStudent);
				
				for (int i = worstStudentIndex; i < lecturerStudentsPreferences.size(); ++i){
					Student student;
					student = lecturerStudentsPreferences.get(i);
					
					ArrayList<Project> projects = getProjectsOfferedByLecturerAcceptableForStudent(lecturerWhoOffersProject, student);
					
					for (Project project : projects){
						student.deleteProjectFromStudentPreferences(project);
					}
					
				}
				
				lecturerWhoOffersProject.deleteAllFromPreferenceListForProject(worstStudent, firstProjectOfStudent);
				
			}
			firstFreeStudent = this.getFirstFreeStudent();
		}
	}
	
}
