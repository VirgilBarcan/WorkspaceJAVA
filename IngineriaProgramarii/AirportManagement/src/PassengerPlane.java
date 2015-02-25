import java.io.File;

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

public class PassengerPlane extends Plane 
{
	private int numberOfPassengers;
	private int numberOfSeats;
	
	public void setNumberOfPassengers(int passengers)
	{
		numberOfPassengers = passengers;
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
