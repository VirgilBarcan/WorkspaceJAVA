/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class MilitaryPlane extends Plane 
{
	private int numberOfGuns;
	private int numberOfBombs;
	
	public void setNumberOfGuns(int guns)
	{
		numberOfGuns = guns;
	}
	
	public int getNumberOfGuns()
	{
		return numberOfGuns;
	}
	
	public void setNumberOfBombs(int bombs)
	{
		numberOfBombs = bombs;
	}
	
	public int getNumberOfBombs()
	{
		return numberOfBombs; 
	}
	
	/* (non-Javadoc)
	 * @see Plane#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see Plane#load()
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Plane#requestPermissionToFly()
	 */
	@Override
	public boolean requestPermissionToFly(Airport airport, Lane lane) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Plane#requestPermissionToLand()
	 */
	@Override
	public boolean requestPermissionToLand(Airport airport, Lane lane) {
		// TODO Auto-generated method stub
		return false;
	}

}
