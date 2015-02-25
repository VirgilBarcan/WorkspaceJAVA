package airportManagement;
import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class HelicopterFactory implements IFactory 
{	
	private static HelicopterFactory instance = null;
	
	public static HelicopterFactory getInstance()
	{
		return instance != null ? instance : new HelicopterFactory(); 
	}
	
	private HelicopterFactory() { }
	
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

	public Helicopter createHelicopter(String helicopterType)
	{
		
		String packageName = Plane.class.getPackage().getName();
		
		Reflections reflections = new Reflections(packageName);
		
		Set<Class<? extends Helicopter>> allHelicopters = reflections.getSubTypesOf(Helicopter.class);
		
		Iterator<Class<? extends Helicopter>> it = allHelicopters.iterator();
		
		while (it.hasNext())
		{
			try
			{
				Helicopter helicopter = it.next().newInstance();
				
				if (helicopter.getHelicopterType() == helicopterType)
				{
					return helicopter;
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
}
