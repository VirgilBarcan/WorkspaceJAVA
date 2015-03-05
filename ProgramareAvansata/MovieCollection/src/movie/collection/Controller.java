/**
 * 
 */
package movie.collection;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class Controller {

	private MovieCollection theModel;
	private View theView;
	
	/**
	 * @param theModel a MovieCollection object
	 * @param theView a View object, which will take care of user interaction
	 */
	public Controller(MovieCollection theModel, View theView){
		initialize();
		
		this.theModel = theModel;
		this.theView = theView;
	}
	
	private void initialize(){
		theModel = new MovieCollection();
		theView = new View(theModel);
	}
	
	public void run(){
		
		String inputFromUser;
		
		theView.showMenu();
		
		do{
			
			inputFromUser = theView.getUserInput();
			
			//TODO see what command the user has given and act accordingly
			
			if (inputFromUser.toUpperCase().equals("ADD") == true){
				String title;
				String imdbID;
				String releaseDate;
				String shortDescription;
				ArrayList<Category> modelCategories;
				ArrayList<Category> movieCategories;
				String inputCategories;
				
				//process title input
				theView.showMessage("Add Movie> Title: ");
				title = theView.getUserInput();
				
				while (checkTitle(title) == false){
					theView.showMessage("Add Movie> There exists a movie with the same title! Insert another title");
					theView.showMessage("Add Movie> Title: ");
					title = theView.getUserInput();
				}

				//process categories input
				theView.showMessage("Add Movie> Now that you inserted the title, please select the movie categories");
				modelCategories = theModel.getCategoriesList();
				theView.showMessage("Add Movie> ");
				theView.showCategories(modelCategories);
				theView.showMessage("Add Movie> Insert your movie`s categories followed by commas");
				theView.showMessage("Add Movie> You can add from that list or put new ones");
				inputCategories = theView.getUserInput();
				
				movieCategories = createMovieCategoriesList(inputCategories);
				
			}
			
		}while (inputFromUser.toUpperCase().equals("EXIT") == false);
		
	}
	
	/**
	 * @param title the title that we want to check
	 * @return true if the title is good, false otherwise 
	 */
	private boolean checkTitle(String title){
		return theModel.existsWithTitle(title);
	}
	
	/**
	 * @param String inputCategories the categories separated by commas
	 * @return ArrayList<Category> the movie's categories derived from inputCategories
	 */
	private ArrayList<Category> createMovieCategoriesList(String inputCategories){
		//TODO create implementation
		return null;
	}
	
}
