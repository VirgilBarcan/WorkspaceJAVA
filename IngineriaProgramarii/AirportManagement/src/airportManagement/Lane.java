package airportManagement;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

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
	
	private int getID()
	{
		return laneID;
	}
	
	private void setID(int id)
	{
		laneID = id;
		if (Lane.lastID < id)
			Lane.lastID = id;
	}
	
	public void save(Element rootElement)
	{
		rootElement.setAttribute(new Attribute("id", Integer.toString(this.getID())));
		rootElement.addContent(new Element("isClear").setText(Boolean.toString(this.getIsClear())));
				
		Element aircraftsTag = new Element("aircrafts");
		
		// TODO - de facut corect		
		//int size = ( (this.getIsClear() == false) ? 0 : 1 );
		//aircraftsTag.setAttribute(new Attribute("size", String.valueOf(size)));
		
		// TODO - de eliminat / comentat testarile astea
		PassengerPlane pp = (PassengerPlane) PassengerPlane.getPassengerPlane();
		MilitaryPlane mp = (MilitaryPlane) MilitaryPlane.getMilitaryPlane();
		MedicalPlane mp2 = (MedicalPlane) MedicalPlane.getMedicalPlane();
		
		MilitaryHelicopter mh = (MilitaryHelicopter) MilitaryHelicopter.getMilitaryHelicopter();
		MedicalHelicopter mh2 = (MedicalHelicopter) MedicalHelicopter.getMedicalHelicopter();
		FireHelicopter fh = (FireHelicopter) FireHelicopter.getFireHelicopter();
		
		aircrafts.add(pp);
		aircrafts.add(mp);
		aircrafts.add(mp2);
		
		aircrafts.add(mh);
		aircrafts.add(mh2);
		aircrafts.add(fh);
		
		for (IAircraft aircraft : aircrafts)
		{
			aircraft.save(aircraftsTag);
		}
		
		rootElement.addContent(aircraftsTag);
	}
	
	public void load(Element element)
	{
		try 
		{
			this.setID(element.getAttribute("id").getIntValue());
			this.setIsClear(Boolean.parseBoolean(element.getChild("isClear").getValue()));
					
			List<?> aircraftsList = element.getChild("aircrafts").getChildren();
			
			for(int i = 0; i < aircraftsList.size(); ++i)
			{
				Element aircraft = (Element) aircraftsList.get(i);
				
				if(aircraft.getName().contains("Helicopter"))
				{
					// In loc de a folosi compare pe string-uri, o alta metoda ar fi
					// sa incercam sa apelam direct createHelicopter, si sa vedem ce ne returneaza ; 
					// daca e null, atunci apelam createPlane si vedem ce returneaza.					
					
					Helicopter helicopter = HelicopterFactory.getInstance().createHelicopter(aircraft.getName());
					
					helicopter.load(aircraft);
					
					aircrafts.add(helicopter);
				}
				else // Plane
				{
					Plane plane = PlaneFactory.getInstance().createPlane(aircraft.getName());
					
					plane.load(aircraft);
					
					aircrafts.add(plane);
				}
			}
		}
		catch (DataConversionException e) 
		{
			e.printStackTrace();
		}				
	}
}
