package airportManagement;
/**
 * 
@author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Element;

public abstract class Plane implements IAircraft
{
	protected String planeID;
	protected String planeType;
	
	/* (non-Javadoc)
	 * @see Aircraft#save()
	 */
	@Override
	public abstract void save(Element element);

	/* (non-Javadoc)
	 * @see Aircraft#load()
	 */
	@Override
	public abstract void load(Element element);
	
	/* (non-Javadoc)
	 * @see Aircraft#requestPermissionToFly()
	 */
	@Override
	public abstract boolean requestPermissionToFly(Airport airport, Lane lane);

	/* (non-Javadoc)
	 * @see Aircraft#requestPermissionToLand()
	 */
	@Override
	public abstract boolean requestPermissionToLand(Airport airport, Lane lane);

	
	public void setPlaneType(String planeType)
	{
		this.planeType = planeType;
	}
	
	public void setPlaneID(String planeID)
	{
		this.planeID = planeID;
	}	
	
	public String getPlaneType()
	{
		return planeType;
	}

	public String getPlaneID()
	{
		return planeID;
	}	
}
