package airportManagement;
/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */

public interface IAircraft 
{
	public void save(org.jdom.Element element);
	public void load(org.jdom.Element element);
	
	public boolean requestPermissionToFly(Airport airport, Lane lane);
	public boolean requestPermissionToLand(Airport airport, Lane lane);
}
