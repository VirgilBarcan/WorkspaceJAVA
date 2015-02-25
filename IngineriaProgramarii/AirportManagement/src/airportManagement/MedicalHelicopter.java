package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

public class MedicalHelicopter extends Helicopter 
{
	private int numberOfMedicalKits;
	
	public void setNumberOfMedicalKits(int kits)
	{
		numberOfMedicalKits = kits;
	}
	
	public int getNumberOfMedicalKits()
	{
		return numberOfMedicalKits;
	}
	
	public static Helicopter getMedicalHelicopter()
	{
		return new MedicalHelicopter();
	}
	
	private MedicalHelicopter()
	{
		setHelicopterType("Medical Helicopter");
	}	
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("MedicalHelicopter");
		aircraftsTag.setAttribute(new Attribute("noOfMedicalKits", Integer.toString(this.getNumberOfMedicalKits())));
		
		element.addContent(aircraftsTag);
	}

	@Override
	public void load(Element element) 
	{
		try 
		{
			this.setNumberOfMedicalKits(element.getAttribute("noOfMedicalKits").getIntValue());
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
