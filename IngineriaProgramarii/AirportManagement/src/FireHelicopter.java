/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

public class FireHelicopter extends Helicopter 
{
	private int numberOfWaterBuckets; 
	
	public void setNumberOfWaterBuckets(int buckets)
	{
		numberOfWaterBuckets = buckets;
	}
	
	public int getNumberOfWaterBuckets()
	{
		return numberOfWaterBuckets;
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

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
