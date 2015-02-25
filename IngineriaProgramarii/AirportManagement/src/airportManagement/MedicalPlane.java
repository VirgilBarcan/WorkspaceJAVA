package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

public class MedicalPlane extends Plane 
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
	
	public static Plane getMedicalPlane()
	{
		return new MedicalPlane();
	}	
	
	private MedicalPlane()
	{
		setPlaneType("Medical Plane");
	}	
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("MedicalPlane");
		aircraftsTag.setAttribute(new Attribute("noOfMedicalKits", Integer.toString(this.getNumberOfMedicalKits())));
		aircraftsTag.setAttribute(new Attribute("noOfPortableBeds", Integer.toString(this.getNumberOfPortableBeds())));
		
		element.addContent(aircraftsTag);
	}
	
	@Override
	public void load(Element element) 
	{
		try 
		{
			this.setNumberOfMedicalKits(element.getAttribute("noOfMedicalKits").getIntValue());
			this.setNumberOfPortableBeds(element.getAttribute("noOfPortableBeds").getIntValue());
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
	public boolean requestPermissionToFly(Airport airport, Lane lane) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Plane#requestPermissionToLand()
	 */
	@Override
	public boolean requestPermissionToLand(Airport airport, Lane lane) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
