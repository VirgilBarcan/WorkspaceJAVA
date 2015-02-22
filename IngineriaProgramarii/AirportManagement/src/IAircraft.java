/**
 * 
 */

/**
 * @author Virgil Barcan
 *
 */
public interface IAircraft 
{
	public void  save();
	public void  load();
	public boolean requestPermissionToFly(Airport airport, Lane lane);
	public boolean requestPermissionToLand(Airport airport, Lane lane);
}
