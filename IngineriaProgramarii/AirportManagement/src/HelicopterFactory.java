import java.util.Map;

/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public class HelicopterFactory implements IFactory 
{

	private Map<String, IAircraft> callbacks;
	
	/* (non-Javadoc)
	 * @see IFactory#register()
	 */
	@Override
	public boolean register(String typeOfHelicopter, IAircraft functor) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see IFactory#unregister()
	 */
	@Override
	public boolean unregister(String typeOfHelicopter) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
