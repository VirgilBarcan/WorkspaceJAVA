/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class MedicalHelicopter extends Helicopter 
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
	 * @see Helicopter#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Helicopter#load()
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see Helicopter#requestPermissionToFly()
	 */
	@Override
	public boolean requestPermissionToFly(Airport airport, Lane lane) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Helicopter#requestPermissionToLand()
	 */
	@Override
	public boolean requestPermissionToLand(Airport airport, Lane lane) {
		// TODO Auto-generated method stub
		return false;
	}

}
