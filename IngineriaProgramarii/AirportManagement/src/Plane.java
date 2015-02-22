/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public abstract class Plane implements IAircraft 
{

	private String planeID;
	
	/* (non-Javadoc)
	 * @see Aircraft#save()
	 */
	@Override
	public abstract void save();

	/* (non-Javadoc)
	 * @see Aircraft#load()
	 */
	@Override
	public abstract void load();
	
	/* (non-Javadoc)
	 * @see Aircraft#requestPermissionToFly()
	 */
	@Override
	public abstract boolean requestPermissionToFly();

	/* (non-Javadoc)
	 * @see Aircraft#requestPermissionToLand()
	 */
	@Override
	public abstract boolean requestPermissionToLand();

}
