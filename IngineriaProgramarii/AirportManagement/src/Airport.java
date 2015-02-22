import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public class Airport 
{
	private ArrayList<Hangar> hangars;
	private ArrayList<Lane> lanes;
	
	public Airport()
	{
		Initialize();
	}
	
	private void Initialize()
	{
		hangars = new ArrayList<Hangar>();
		lanes   = new ArrayList<Lane>();
	}
	
	public boolean givePermissionToFly(IAircraft aircraft, Lane lane)
	{
		//TODO Find lane in lanes and get the isClear member to see if lane is free
		return true;
	}
	
	public boolean givePermissionToLand()
	{
		//TODO Find lane in lanes and get the isClear member to see if lane is free
		return true;
	}
}
