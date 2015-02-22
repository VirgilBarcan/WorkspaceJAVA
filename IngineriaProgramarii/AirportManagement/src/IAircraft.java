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
	public boolean requestPermissionToFly();
	public boolean requestPermissionToLand();
}
