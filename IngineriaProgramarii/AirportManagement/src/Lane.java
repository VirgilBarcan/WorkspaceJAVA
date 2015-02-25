import java.util.ArrayList;

import org.jdom.Attribute;
import org.jdom.Element;

/**
 * 
 */

/**
 * @author Virgil Barcan & Morosanu Dan
 *
 */
public class Lane 
{
	private int laneID;
	private ArrayList<IAircraft> aircrafts;
	private boolean isClear;
	
	private static int lastID = 0;
	
	public Lane()
	{
		Initialize();
		laneID = Lane.lastID;
		++Lane.lastID;
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
	
	private int getID(){
		return laneID;
	}
	
	private void setID(int id){
		laneID = id;
		if (Lane.lastID < id)
			Lane.lastID = id;
	}
	
	public void save(Element rootElement)
	{
		rootElement.setAttribute(new Attribute("id", Integer.toString(this.getID())));
		rootElement.addContent(new Element("isClear").setText(Boolean.toString(this.getIsClear())));
		//rootElement.addContent(new Element("aircrafts").setText(Integer.toString(this.getNoOfPlanesInside())));
		
		Element aircraftsTag = new Element("aircrafts");
		int size = ( (this.getIsClear() == false) ? 0 : 1 );
		aircraftsTag.setAttribute(new Attribute("size", String.valueOf(size)));
		
		PassengerPlane pp = (PassengerPlane) PassengerPlane.getPassengerPlane();
		
		aircrafts.add(pp);
		
		for (IAircraft aircraft : aircrafts)
		{
			Element aircraftTag = new Element("aircraft");
			
			aircraftsTag.addContent(aircraftTag);
		}
		
		rootElement.addContent(aircraftsTag);
	}

}
