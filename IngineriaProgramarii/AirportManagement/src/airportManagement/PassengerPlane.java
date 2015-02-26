package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

public class PassengerPlane extends Plane 
{
	private int numberOfPassengers;
	private int numberOfSeats;
	
	public void setNumberOfPassengers(int passengers)
	{
		numberOfPassengers = passengers;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PassengerPlane [numberOfPassengers=" + numberOfPassengers
				+ ", numberOfSeats=" + numberOfSeats + ", planeID=" + planeID
				+ ", planeType=" + planeType + "]";
	}

	public int getNumberOfPassengers()
	{
		return numberOfPassengers;
	}
	
	public void setNumberOfSeats(int seats)
	{
		numberOfSeats = seats;
	}
	
	public int getNumberOfSeats()
	{
		return numberOfSeats;
	}	
	
	public static Plane getPassengerPlane()
	{
		return new PassengerPlane();
	}
	
	public PassengerPlane()
	{
		setPlaneType("PassengerPlane");
		setPlaneID("1");
	}
	
	@Override
	public void save(Element element) 
	{
		Element aircraftsTag = new Element("PassengerPlane");
		aircraftsTag.setAttribute(new Attribute("noOfPassengers", Integer.toString(this.getNumberOfPassengers())));
		aircraftsTag.setAttribute(new Attribute("noOfSeats", Integer.toString(this.getNumberOfSeats())));
		
		element.addContent(aircraftsTag);
	}
	
	@Override
	public void load(Element element) 
	{
		try 
		{
			this.setNumberOfPassengers(element.getAttribute("noOfPassengers").getIntValue());
			this.setNumberOfSeats(element.getAttribute("noOfSeats").getIntValue());
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
