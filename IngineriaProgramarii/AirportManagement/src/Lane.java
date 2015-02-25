import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class Lane 
{
	private ArrayList<IAircraft> aircrafts;
	private boolean isClear;
	
	public Lane()
	{
		Initialize();
	}
	
	private void Initialize()
	{
		aircrafts = new ArrayList<IAircraft>();
		isClear   = true;
	}
	
	public boolean getIsClear()
	{
		return isClear;
	}
	
	private void setIsClear(boolean isClear)
	{
		this.isClear = isClear;
	}
}
