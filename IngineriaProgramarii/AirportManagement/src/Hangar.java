import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public class Hangar 
{
	private ArrayList<IAircraft> aircrafts;
	private boolean hasSpace;
	private int capacity;
	private int noOfPlanesInside;
	
	public Hangar()
	{
		Initialize();
	}
	
	private void Initialize()
	{
		aircrafts = new ArrayList<IAircraft>();
		hasSpace  = true;
		capacity  = 0;
		noOfPlanesInside = 0;
	}
	
	public boolean getHasSpace()
	{
		return hasSpace;
	}
	
	private void setHasSpace(boolean hasSpace)
	{
		this.hasSpace = hasSpace;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	private void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	public int getNoOfPlanesInside()
	{
		return noOfPlanesInside;
	}
	
	private void setNoOfPlanesInside(int noOfPlanesInside)
	{
		this.noOfPlanesInside = noOfPlanesInside;
	}
}
