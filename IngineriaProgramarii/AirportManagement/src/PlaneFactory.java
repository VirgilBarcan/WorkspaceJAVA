import java.util.Map;

/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public class PlaneFactory implements IFactory 
{

	//the pairs (nameOfObject, constructorOfObject)
	private Map<String, IAircraft> callbacks;
	
	/* (non-Javadoc)
	 * @see IFactory#register()
	 */
	@Override
	public boolean register(String typeOfPlane, IAircraft functor) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see IFactory#unregister()
	 */
	@Override
	public boolean unregister(String typeOfPlane) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
