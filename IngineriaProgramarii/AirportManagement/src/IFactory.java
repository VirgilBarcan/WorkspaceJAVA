/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public interface IFactory 
{
	public boolean register(String typeOfAircraft, IAircraft functor);
	public boolean unregister(String typeOfAircraft);
}
