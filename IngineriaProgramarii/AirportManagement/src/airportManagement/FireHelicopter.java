package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

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
	
	public static Helicopter getFireHelicopter()
	{
		return new FireHelicopter();
	}
	
	private FireHelicopter()
	{
		setHelicopterType("Fire Helicopter");
	}	
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("FireHelicopter");
		aircraftsTag.setAttribute(new Attribute("noOfWaterBuckets", Integer.toString(this.getNumberOfWaterBuckets())));
		
		element.addContent(aircraftsTag);		
	}

	@Override
	public void load(Element element) 
	{
		try 
		{
			this.setNumberOfWaterBuckets(element.getAttribute("noOfWaterBuckets").getIntValue());
		} 
		catch (DataConversionException e) 
		{
			e.printStackTrace();
		}
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
