package airportManagement;
public class Main 
{
	public static void main(String[] args) 
	{
		Airport p1 = new Airport();
		Airport p2 = new Airport();
		
		p1.save();
		p2.load();
		
		System.out.println("Second save:");
		p2.save();
	}
}
