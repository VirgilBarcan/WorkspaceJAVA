import java.util.ArrayList;
import java.util.List;
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
public class Airport 
{
	private static Airport instance = null;
	
	private ArrayList<Hangar> hangars;
	private ArrayList<Lane> lanes;	
	
	public static Airport getInstance()
	{
		return instance == null ? new Airport() : instance;
	}
	
	public void save()
	{
		Hangar hh = new Hangar();
		hangars.add(hh);
		
		File file = new File("db.xml");
		//if(file.isFile()) // Check if exists & is file
		{
			try 
			{			
				Element airport = new Element("airport");
				Document doc = new Document(airport);
				doc.setRootElement(airport);
				 
				int id = 1;
				for(Hangar h : hangars)
				{
					Element hangar = new Element("hangar");
					hangar.setAttribute(new Attribute("id", Integer.toString(id)));
					hangar.addContent(new Element("capacity").setText(Integer.toString(h.getCapacity())));
					hangar.addContent(new Element("planesInside").setText(Integer.toString(h.getNoOfPlanesInside())));
					
					// TODO -- add rest elements ( helicopters, planes )					
					
					doc.getRootElement().addContent(hangar);
					++id;
				}
				
				id = 1;
				for(Lane l : lanes)
				{
					Element lane = new Element("lane");
					lane.setAttribute(new Attribute("id", Integer.toString(id)));
					
					// TODO -- add rest elements ( helicopters, planes )					
					
					doc.getRootElement().addContent(lane);
					++id;
				}
				
				XMLOutputter xmlOutput = new XMLOutputter();
				 
				xmlOutput.setFormat(Format.getPrettyFormat()); // Nice Format
				xmlOutput.output(doc, new FileWriter(file)); // File
				xmlOutput.output(doc, System.out); // Output
				
				System.out.println("File Saved!");
			} 
			catch (IOException io) 
			{
				System.out.println(io.getMessage());
			}
		}
	}
	
	public void load()
	{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("db.xml");
 
		try 
		{ 
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			List<?> list = rootNode.getChildren();	 
			for (int i = 0; i < list.size(); i++) 
			{	 
				Element node = (Element) list.get(i);
				
				if(node.getName().equals("hangar"))
				{
					Hangar h = new Hangar();
					
					h.setCapacity(Integer.parseInt(node.getChildText("capacity")));
					h.setNoOfPlanesInside(Integer.parseInt(node.getChildText("planesInside")));
					
					// TODO -- add rest elements ( helicopters, planes )
					
					hangars.add(h);
				}
				else if(node.getName().equals("lane"))
				{
					Lane l = new Lane();

					// TODO -- add rest elements ( helicopters, planes )
					
					lanes.add(l);
				}
			}
 
		} 
		catch (IOException io) 
		{
			System.out.println(io.getMessage());
		} 
		catch (JDOMException jdomex) 
		{
			System.out.println(jdomex.getMessage());
		}		
	}
		
	private Airport()
	{
		Initialize();
	}
	
	private void Initialize()
	{
		hangars = new ArrayList<Hangar>();
		lanes   = new ArrayList<Lane>();
	}
	
	public boolean givePermissionToFly(IAircraft aircraft, Lane lane)
	{
		//TODO Find lane in lanes and get the isClear member to see if lane is free
		return true;
	}
	
	public boolean givePermissionToLand()
	{
		//TODO Find lane in lanes and get the isClear member to see if lane is free
		return true;
	}
}
