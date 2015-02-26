package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

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
	
	public static Plane getMilitaryPlane()
	{
		return new MilitaryPlane();
	}	
	
	public MilitaryPlane()
	{
		setPlaneType("MilitaryPlane");
	}
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("MilitaryPlane");
		aircraftsTag.setAttribute(new Attribute("noOfGuns", Integer.toString(this.getNumberOfGuns())));
		aircraftsTag.setAttribute(new Attribute("noOfBombs", Integer.toString(this.getNumberOfBombs())));
		
		element.addContent(aircraftsTag);
	}

	@Override
	public void load(Element element) 
	{
		try 
		{
			this.setNumberOfGuns(element.getAttribute("noOfGuns").getIntValue());
			this.setNumberOfBombs(element.getAttribute("noOfBombs").getIntValue());
		} 
		catch (DataConversionException e) 
		{
			e.printStackTrace();
		}	
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
