/**
 * 
 */
package StudentProjectAllocation;

/**
 * @author Virgil Barcan
 *
 */
public class Project {
	private Integer projectID;
	private Integer projectCapacity;
	private Integer offeredBy;
	
	private static int lastProjectID = 0;
	
	//Constructors
	public Project(){
		Initialize();
		
		projectID = Project.lastProjectID;
		++Project.lastProjectID;
	}
	
	public Project(Integer projectID, Integer projectCapacity, Integer offeredBy){
		Initialize();
		
		this.projectID = projectID;
		this.projectCapacity = projectCapacity;
		this.offeredBy = offeredBy;
		
		if (Project.lastProjectID < projectID){
			Project.lastProjectID = projectID;
		}
		else{
			++Project.lastProjectID;
		}
	}
	
	private void Initialize(){
		projectID = 0;
		projectCapacity = 0;
		offeredBy = 0;
	}
}
