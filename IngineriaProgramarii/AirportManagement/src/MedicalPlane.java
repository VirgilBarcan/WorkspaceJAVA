/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class MedicalPlane extends Plane 
{
	private int numberOfMedicalKits;
	private int numberOfPortableBeds; 
	
	public void setNumberOfMedicalKits(int kits)
	{
		numberOfMedicalKits = kits;
	}
	
	public int getNumberOfMedicalKits()
	{
		return numberOfMedicalKits;
	}
	
	public void setNumberOfPortableBeds(int beds)
	{
		numberOfPortableBeds = beds;
	}
	
	public int getNumberOfPortableBeds()
	{
		return numberOfPortableBeds;
	}	
	
	/* (non-Javadoc)
	 * @see Plane#save()
	 */
	@Override
	public void save() 
	{
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see Plane#load()
	 */
	@Override
	public void load() 
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Plane#requestPermissionToFly()
	 */
	@Override
	public boolean requestPermissionToFly(Airport airport, Lane lane) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Plane#requestPermissionToLand()
	 */
	@Override
	public boolean requestPermissionToLand(Airport airport, Lane lane) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
