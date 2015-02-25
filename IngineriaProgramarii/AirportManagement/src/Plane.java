/**
 * 
@author Virgil Barcan & Morosanu Dan
 *
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class Plane implements IAircraft
{
	protected String planeID;
	protected String planeType;
	
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
	public abstract boolean requestPermissionToFly(Airport airport, Lane lane);

	/* (non-Javadoc)
	 * @see Aircraft#requestPermissionToLand()
	 */
	@Override
	public abstract boolean requestPermissionToLand(Airport airport, Lane lane);

	
	@XmlElement
	public void setPlaneType(String planeType)
	{
		this.planeType = planeType;
	}
	
	@XmlElement
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
