package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

public class MilitaryHelicopter extends Helicopter 
{
	private int numberOfGuns;
	
	public void setNumberOfGuns(int guns)
	{
		numberOfGuns = guns;
	}
	
	public int getNumberOfGuns()
	{
		return numberOfGuns;
	} 

	public static Helicopter getMilitaryHelicopter()
	{
		return new MilitaryHelicopter();
	}
	
	private MilitaryHelicopter()
	{
		setHelicopterType("Military Helicopter");
	}
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("MilitaryHelicopter");
		aircraftsTag.setAttribute(new Attribute("noOfGuns", Integer.toString(this.getNumberOfGuns())));
		
		element.addContent(aircraftsTag);
	}

	@Override
	public void load(Element element)
	{
		try 
		{
			this.setNumberOfGuns(element.getAttribute("noOfGuns").getIntValue());
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
