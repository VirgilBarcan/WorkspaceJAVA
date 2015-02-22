/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public class PassengerPlane extends Plane 
{

	public static Plane getPassengerPlane()
	{
		return new PassengerPlane();
	}
	
	private PassengerPlane()
	{
		planeID = new String();
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
