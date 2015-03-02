/**
 * 
 */
package StudentProjectAllocation;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class Project {
	private ArrayList<Student> assignedStudents;
	private Integer projectID;
	private Integer projectCapacity;
	
	
	private static int lastProjectID = 1;
	
	//Constructors
	public Project(){
		Initialize();
		
		projectID = Project.lastProjectID;
		++Project.lastProjectID;
	}
	
	public Project(Integer projectID, Integer projectCapacity){
		Initialize();
		
		this.projectID = projectID;
		this.projectCapacity = projectCapacity;
		
		if (Project.lastProjectID < projectID){
			Project.lastProjectID = projectID;
		}
		else{
			++Project.lastProjectID;
		}
	}
	
	private void Initialize(){
		assignedStudents = new ArrayList<Student>();
		projectID = 0;
		projectCapacity = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [ projectID="
				+ projectID + ", projectCapacity=" + projectCapacity + "]";
	}
	
	public int getProjectID(){
		return this.projectID;
	}

	public void assignStudent(Student student){
		assignedStudents.add(student);
		--projectCapacity;
		
		System.out.println("Student " + student.getStudentID() + " assigned to project " + this.getProjectID());
	}
	
	public void deAssignStudent(Student student){
		if (assignedStudents.contains(student) == true){
			assignedStudents.remove(student);
			++projectCapacity;
		}
	}
	
	public boolean isOverCapacity(){
		if (projectCapacity < 0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if (projectCapacity == 0)
			return true;
		return false;
	}
}
