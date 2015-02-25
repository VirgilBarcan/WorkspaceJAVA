import java.io.File;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

@XmlRootElement
public class PassengerPlane extends Plane 
{
	public static Plane getPassengerPlane()
	{
		return new PassengerPlane();
	}
	
	private PassengerPlane()
	{
		setPlaneType("Passenger Plane");
	}
	
	@Override
	public void save() 
	{

	}
	
	/* (non-Javadoc)
	 * @see Plane#load()
	 */
	@Override
	public void load() 
	{
		
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
