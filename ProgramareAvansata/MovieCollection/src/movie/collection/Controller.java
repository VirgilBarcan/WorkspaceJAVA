/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Date;

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
			
			//TODO import and export file
			
			if (inputFromUser.toUpperCase().equals("ADD") == true){
				inputAddMovie();
			}
			
			if (inputFromUser.toUpperCase().equals("EDIT") == true){
				inputEditMovie();
			}
			
			if (inputFromUser.toUpperCase().equals("DELETE") == true){
				inputDeleteMovie();
			}
			
			if (inputFromUser.toUpperCase().equals("SEARCH") == true){
				inputSearchMovie();
			}
			
			if (inputFromUser.toUpperCase().equals("IMPORT") == true){
				
			}
			
			if (inputFromUser.toUpperCase().equals("EXPORT") == true){
				inputExportCollection();
			}
			
			theView.showMenu();
			
		}while (inputFromUser.toUpperCase().equals("EXIT") == false);
		
	}

	private void inputAddMovie(){
		String title;
		String imdbID;
		String releaseDate;
		String rating;
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
		
		//process releaseDate
		theView.showMessage("Add Movie> Now that you inserted the categories, please insert the release date");
		theView.showMessage("Add Movie> Release Date (dd-mm-yyyy): ");
		releaseDate = theView.getUserInput();
		
		while (isValidDate(releaseDate) == false){
			theView.showMessage("Add Movie> The date you inserted is not correct! Please follow the format");
			theView.showMessage("Add Movie> Release Date (dd-mm-yyyy): ");
			releaseDate = theView.getUserInput();
		}
		
		//process imdbID
		theView.showMessage("Add Movie> Now that you inserted the release date, please insert the IMDB ID");
		theView.showMessage("Add Movie> For now, we can't check the ID, but we will implement that soon so please be careful to insert a good value!");
		theView.showMessage("Add Movie> IMDB ID: ");
		imdbID = theView.getUserInput();
		
		//process rating
		theView.showMessage("Add Movie> Now that you inserted the IMDB ID, please insert the rating");
		theView.showMessage("Add Movie> Rating (1-10): ");
		rating = theView.getUserInput();
		
		while (isValidRating(rating) == false){
			theView.showMessage("Add Movie> The rating you have given is not correct! Please follow the rule");
			theView.showMessage("Add movie> Rating (1-10: ");
			rating = theView.getUserInput();
		}
		
		//process shortDescription
		theView.showMessage("Add Movie> Now that you added everything, add and a short description. You can also leave it blank. Press Enter when you finish");
		theView.showMessage("Add Movie> Short Description: ");
		shortDescription = theView.getUserInput();
		
		Movie movieToAdd = new Movie();
		movieToAdd.setTitle(title);
		movieToAdd.setImdbID(imdbID);
		movieToAdd.setReleaseDate(releaseDate);
		movieToAdd.setCategories(movieCategories);
		movieToAdd.setRating(Double.parseDouble(rating));
		movieToAdd.setShortDescription(shortDescription);
		
		theModel.addMovie(movieToAdd);
	}
	
	private void inputEditMovie(){
		String selectTitle;
		
		//what movie to edit?
		theView.showMessage("Edit Movie> Title: ");
		selectTitle = theView.getUserInput();
		
		if (existsWithTitle(selectTitle) == true){
			Movie movie = getMovieWithTitle(selectTitle);
			String newTitle;
			
			theView.showMessage("Edit Movie> Set the new Title: ");
			newTitle = theView.getUserInput();
			theView.showMessage("Edit Movie> The other fields' edit will be added later");
			
			movie.setTitle(newTitle);
			
			if (movie.getTitle().equals(newTitle) == true){
				theView.showMessage("Edit Movie> Movie edited!");
			}
			else{
				theView.showMessage("Edit Movie> Movie not edited!");
			}
			
		}
	}
	
	private void inputDeleteMovie(){
		String selectTitle;
		
		//what movie to delete?
		theView.showMessage("Delete Movie> Title: ");
		selectTitle = theView.getUserInput();
		
		if (existsWithTitle(selectTitle) == true){
			Movie movie = getMovieWithTitle(selectTitle);
			
			theModel.deleteMovie(movie);
		}
	}
	
	private void inputSearchMovie(){
		String selectTitle;
		
		//what movie to search for
		theView.showMessage("Search Movie> Title");
		selectTitle = theView.getUserInput();
		
		if (existsWithTitle(selectTitle) == true){
			Movie movie = getMovieWithTitle(selectTitle);
			
			theView.showMovie(movie);
		}
	}
	
	private void inputExportCollection(){
		File exportFile = new File("exportMovieCollection.xml");
		//if(file.isFile()) // Check if exists & is file
			try 
			{			
				ArrayList<Movie> movieList = theModel.getMovieList();
				
				Element collection = new Element("movieCollection");
				Document doc = new Document(collection);
				doc.setRootElement(collection);
				
				Element moviesTag = new Element("movies");
				moviesTag.setAttribute(new Attribute("size", Integer.toString(theModel.getMovieList().size())));
				doc.getRootElement().addContent(moviesTag);
				
				for(Movie movie : movieList){
					Element movieTag = new Element("movie");
					
					Element imdbIDTag = new Element("imbdID");
					imdbIDTag.addContent(movie.getImdbID());
					movieTag.addContent(imdbIDTag);
					
					Element titleTag = new Element("title");
					titleTag.addContent(movie.getTitle());
					movieTag.addContent(titleTag);
					
					Element releaseDateTag = new Element("releaseDate");
					releaseDateTag.addContent(movie.getReleaseDate());
					movieTag.addContent(releaseDateTag);					

					Element ratingTag = new Element("rating");
					ratingTag.addContent(movie.getRating().toString());
					movieTag.addContent(ratingTag);
					
					Element shortDescriptionTag = new Element("shortDescription");
					shortDescriptionTag.addContent(movie.getShortDescription());
					movieTag.addContent(shortDescriptionTag);					
					
					Element categoriesTag = new Element("categories");
					categoriesTag.setAttribute(new Attribute("size", Integer.toString(movie.getCategories().size())));
					
					ArrayList<Category> movieCategories = movie.getCategories();
					
					for (Category category : movieCategories){
						Element categoryTag = new Element("category");
						categoryTag.setAttribute(new Attribute("name", category.getCategoryName()));
						categoryTag.setAttribute(new Attribute("description", category.getCategoryDescription()));
						
						categoriesTag.addContent(categoryTag);
					}
					
					movieTag.addContent(categoriesTag);
					
					moviesTag.addContent(movieTag);
				}
				
				XMLOutputter xmlOutput = new XMLOutputter();
				 
				xmlOutput.setFormat(Format.getPrettyFormat()); // Nice Format
				xmlOutput.output(doc, new FileWriter(exportFile)); // File
				xmlOutput.output(doc, System.out); // Output
				
				System.out.println("File Saved!");
			} 
			catch (IOException io) 
			{
				System.out.println(io.getMessage());
			}
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

		String[] categories = inputCategories.split(", ");
		ArrayList<Category> movieCategoriesList = new ArrayList<Category>();
		
		for (String cat : categories){
			Category category = new Category();
			category.setCategoryName(cat);
			
			movieCategoriesList.add(category);
		}
		
		return movieCategoriesList;
	}
	
	/**
	 * @param date a string in which the date is saved
	 * @return true if the date is a valid one, false otherwise
	 */
	private boolean isValidDate(String inputDate){
		
		String[] theDate = inputDate.split("-");
		
		if (theDate.length != 3){
			return false;
		}
		if (Integer.parseInt(theDate[0]) <= 0 || Integer.parseInt(theDate[0]) >= 32){
			//the day
			return false;
		}
		if (Integer.parseInt(theDate[1]) <=0 || Integer.parseInt(theDate[1]) >= 13){
			//the month
			return false;
		}
		if (Integer.parseInt(theDate[2]) <= 1900 || Integer.parseInt(theDate[2]) >= 2016){
			//the year
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param inputRating the rating given as a string
	 * @return true if the rating is correct (between 1-10), false otherwise
	 */
	private boolean isValidRating(String inputRating){
		
		if (Integer.parseInt(inputRating) <=0 || Integer.parseInt(inputRating) >=11){
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param title the title of the movie
	 * @return the movie that has the title equal with title, null otherwise
	 */
	private Movie getMovieWithTitle(String title){
		ArrayList<Movie> movieList = theModel.getMovieList();
		
		for (Movie movie : movieList){
			if (movie.getTitle().equals(title) == true)
				return movie;
		}
		
		return null;
	}
	
	/**
	 * @param title the title of the movie
	 * @return true if there exists a movie with that title, false otherwise
	 */
	private boolean existsWithTitle(String title){
		
		if (getMovieWithTitle(title) == null)
			return false;
		
		return true;
	}
	
}
