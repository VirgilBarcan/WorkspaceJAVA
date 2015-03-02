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
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllocationManager allocationManager = AllocationManager.getInstance();
		
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Project> projects = new ArrayList<Project>();
		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
		
		Student s1 = new Student(1, null);
		Student s2 = new Student(2, null);
		Student s3 = new Student(3, null);
		Student s4 = new Student(4, null);
		Student s5 = new Student(5, null);
		Student s6 = new Student(6, null);
		Student s7 = new Student(7, null);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s4.toString());
		System.out.println(s5.toString());
		System.out.println(s6.toString());
		System.out.println(s7.toString());

		Lecturer l1 = new Lecturer(1, 3, null, null);
		Lecturer l2 = new Lecturer(2, 2, null, null);
		Lecturer l3 = new Lecturer(3, 2, null, null);
		
		Project p1 = new Project(1, 2);
		Project p2 = new Project(2, 1);
		Project p3 = new Project(3, 1);
		Project p4 = new Project(4, 1);
		Project p5 = new Project(5, 1);
		Project p6 = new Project(6, 1);
		Project p7 = new Project(7, 1);
		Project p8 = new Project(8, 1);
		
		
		ArrayList<Project> projectsL1 = new ArrayList<Project>();
		ArrayList<Project> projectsL2 = new ArrayList<Project>();
		ArrayList<Project> projectsL3 = new ArrayList<Project>();
		
		projectsL1.add(p1);
		projectsL1.add(p2);
		projectsL1.add(p3);
		
		projectsL2.add(p4);
		projectsL2.add(p5);
		projectsL2.add(p6);
		projectsL3.add(p7);
		projectsL3.add(p8);
		
		l1.setLecturerProjects(projectsL1);
		l2.setLecturerProjects(projectsL2);
		l3.setLecturerProjects(projectsL3);
		
		ArrayList<Student> l1p1 = new ArrayList<Student>();
		ArrayList<Student> l1p2 = new ArrayList<Student>();
		ArrayList<Student> l1p3 = new ArrayList<Student>();
		ArrayList<Student> l2p4 = new ArrayList<Student>();
		ArrayList<Student> l2p5 = new ArrayList<Student>();
		ArrayList<Student> l2p6 = new ArrayList<Student>();
		ArrayList<Student> l3p7 = new ArrayList<Student>();
		ArrayList<Student> l3p8 = new ArrayList<Student>();
		
		l1p1.add(s1);
		l1p1.add(s3);
		l1p1.add(s2);
		l1p1.add(s5);
		
		l1p2.add(s4);
		l1p2.add(s3);
		l1p2.add(s2);
		l1p2.add(s5);
		l1p2.add(s6);
		
		l1p3.add(s7);
		l1p3.add(s2);
		l1p3.add(s5);
		l1p3.add(s6);
		
		l2p4.add(s3);
		l2p4.add(s2);
		l2p4.add(s6);
		l2p4.add(s5);
		
		l2p5.add(s2);
		l2p5.add(s6);
		l2p5.add(s7);
		
		l2p6.add(s2);
		l2p6.add(s6);
		
		l3p7.add(s1);
		l3p8.add(s7);
		
		Hashtable<Project, ArrayList<Student>> prefL1 = new Hashtable<Project, ArrayList<Student>>();
		Hashtable<Project, ArrayList<Student>> prefL2 = new Hashtable<Project, ArrayList<Student>>();
		Hashtable<Project, ArrayList<Student>> prefL3 = new Hashtable<Project, ArrayList<Student>>();
		
		prefL1.put(p1, l1p1);
		prefL1.put(p2, l1p2);
		prefL1.put(p3, l1p3);
		prefL2.put(p4, l2p4);
		prefL2.put(p5, l2p5);
		prefL2.put(p6, l2p6);
		prefL3.put(p7, l3p7);
		prefL3.put(p8, l3p8);
		
		l1.setLecturerPreferencesForProject(prefL1);
		l2.setLecturerPreferencesForProject(prefL2);
		l3.setLecturerPreferencesForProject(prefL3);

		ArrayList<Project> prefStudent1 = new ArrayList<Project>();
		ArrayList<Project> prefStudent2 = new ArrayList<Project>();
		ArrayList<Project> prefStudent3 = new ArrayList<Project>();
		ArrayList<Project> prefStudent4 = new ArrayList<Project>();
		ArrayList<Project> prefStudent5 = new ArrayList<Project>();
		ArrayList<Project> prefStudent6 = new ArrayList<Project>();
		ArrayList<Project> prefStudent7 = new ArrayList<Project>();
		
		prefStudent1.add(p1);
		prefStudent1.add(p7);

		prefStudent2.add(p1);
		prefStudent2.add(p2);
		prefStudent2.add(p3);
		prefStudent2.add(p4);
		prefStudent2.add(p5);
		prefStudent2.add(p6);
		
		prefStudent3.add(p2);
		prefStudent3.add(p1);
		prefStudent3.add(p4);
		
		prefStudent5.add(p2);
		
		prefStudent5.add(p1);
		prefStudent5.add(p2);
		prefStudent5.add(p3);
		prefStudent5.add(p4);

		prefStudent6.add(p2);
		prefStudent6.add(p3);
		prefStudent6.add(p4);
		prefStudent6.add(p5);
		prefStudent6.add(p6);
		
		prefStudent7.add(p5);
		prefStudent7.add(p3);
		prefStudent7.add(p8);
		
		s1.setStudentProjectPreferences(prefStudent1);
		s2.setStudentProjectPreferences(prefStudent2);
		s3.setStudentProjectPreferences(prefStudent3);
		s4.setStudentProjectPreferences(prefStudent4);
		s5.setStudentProjectPreferences(prefStudent5);
		s6.setStudentProjectPreferences(prefStudent6);
		s7.setStudentProjectPreferences(prefStudent7);
		
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		students.add(s7);
		
		lecturers.add(l1);
		lecturers.add(l2);
		lecturers.add(l3);
		
		projects.add(p1);
		projects.add(p2);
		projects.add(p3);
		projects.add(p4);
		projects.add(p5);
		projects.add(p6);
		projects.add(p7);
		projects.add(p8);
		
		allocationManager.setStudents(students);
		allocationManager.setLecturers(lecturers);
		allocationManager.setProjects(projects);
		
		System.out.println("Begin");
		
		System.out.println("AllocationManager: " + allocationManager.toString());
		
		allocationManager.startAllocation();
		
		System.out.println("End");
	}

}
