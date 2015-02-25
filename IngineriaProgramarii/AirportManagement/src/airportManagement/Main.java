package airportManagement;
public class Main 
{
	public static void main(String[] args) 
	{
		Airport p = Airport.getInstance();
		
		p.save();
		p.load();		
	}
}
