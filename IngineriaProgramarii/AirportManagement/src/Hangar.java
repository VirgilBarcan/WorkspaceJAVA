import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

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
	
	public void setID(int id){
		hangarID = id;
		
		if (Hangar.lastID < id) 
			Hangar.lastID = id;
	}
	
	public void save(Element rootElement)
	{
		rootElement.setAttribute(new Attribute("id", Integer.toString(this.getID())));
		rootElement.addContent(new Element("capacity").setText(Integer.toString(this.getCapacity())));
		//rootElement.addContent(new Element("aircrafts").setText(Integer.toString(this.getNoOfPlanesInside())));
		
		Element aircraftsTag = new Element("aircrafts");
		aircraftsTag.setAttribute(new Attribute("size", Integer.toString(this.getNoOfPlanesInside())));
		
		PlaneFactory pf = new PlaneFactory();
		PassengerPlane pp = (PassengerPlane) pf.createPlane("PassengerPlane");
		
		aircrafts.add(pp);
		
		for (IAircraft aircraft : aircrafts)
		{
			Element aircraftTag = new Element("aircraft");
			
			aircraftsTag.addContent(aircraftTag);
		}
		
		rootElement.addContent(aircraftsTag);
	}
	
	public void load(){
		
	}
}
