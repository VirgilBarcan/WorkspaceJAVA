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
public class Hangar 
{
	private int hangarID;
	private ArrayList<IAircraft> aircrafts;
	private boolean hasSpace;
	private int capacity;
	private int noOfPlanesInside;
	
	private static int lastID = 0;
	
	public Hangar()
	{
		Initialize();
		
		hangarID = Hangar.lastID;
		++Hangar.lastID;
	}
	
	private void Initialize()
	{
		aircrafts = new ArrayList<IAircraft>();
		hasSpace  = true;
		capacity  = 0;
		noOfPlanesInside = 0;
	}
	
	public boolean getHasSpace()
	{
		return hasSpace;
	}
	
	private void setHasSpace(boolean hasSpace)
	{
		this.hasSpace = hasSpace;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	public int getNoOfPlanesInside()
	{
		return noOfPlanesInside;
	}
	
	public void setNoOfPlanesInside(int noOfPlanesInside)
	{
		this.noOfPlanesInside = noOfPlanesInside;
	}
	
	public int getID(){
		return hangarID;
	}
	
	public void setID(int id)
	{
		hangarID = id;
		
		if (Hangar.lastID < id) 
			Hangar.lastID = id;
	}
	
	public void save(Element rootElement)
	{
		rootElement.setAttribute(new Attribute("id", Integer.toString(this.getID())));
		rootElement.addContent(new Element("capacity").setText(Integer.toString(this.getCapacity())));
				
		Element aircraftsTag = new Element("aircrafts");
		aircraftsTag.setAttribute(new Attribute("size", Integer.toString(this.getNoOfPlanesInside())));
		
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
		aircrafts.add(fh); aircrafts.add(fh); aircrafts.add(fh); aircrafts.add(fh); aircrafts.add(fh);

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
			this.setCapacity(Integer.parseInt(element.getChild("capacity").getValue()));
			
			List<?> aircraftsList = element.getChild("aircrafts").getChildren();
			
			for(int i = 0; i < aircraftsList.size(); ++i)
			{
				Element aircraft = (Element) aircraftsList.get(i);
				
				// In loc de a folosi compare pe string-uri, o alta metoda ar fi
				// sa incercam sa apelam direct createHelicopter, si sa vedem ce ne returneaza ; 
				// daca e null, atunci apelam createPlane si vedem ce returneaza.
				
				if(aircraft.getName().contains("Helicopter"))
				{
					Helicopter helicopter = HelicopterFactory.getInstance().createHelicopter(aircraft.getName());
					
					helicopter.load(aircraft);
					
					aircrafts.add(helicopter);
				}
				else if(aircraft.getName().contains("Plane"))// Plane
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
