/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.util.List;

/**
 * @author Virgil Barcan
 * @author Alex Munteanu
 */
public class Controller {

	private MovieCollection theModel;
	private View theView;

	/**
	 * @param theModel
	 *            a MovieCollection object
	 * @param theView
	 *            a View object, which will take care of user interaction
	 */
	public Controller(MovieCollection theModel, View theView) {
		initialize();

		this.theModel = theModel;
		this.theView = theView;
	}

	/**
	 * the function that initializes the data
	 */
	private void initialize() {
		theModel = new MovieCollection();
		theView = new View(theModel);
	}

	/**
	 * the function where all the interaction with the user is done
	 */
	public void run() {

		String inputFromUser;

		try {

			do {

				theView.showMenu();

				inputFromUser = theView.getUserInput();

				try {
					if (inputFromUser.toUpperCase().equals("ADD") == true) {
						inputAddMovie();
					}
				} catch (SameTitleMovieException sameTitle) {
					System.out.println("SameTitleMovieException: "
							+ sameTitle.getMessage());
				}

				if (inputFromUser.toUpperCase().equals("EDIT") == true) {
					inputEditMovie();
				}

				if (inputFromUser.toUpperCase().equals("DELETE") == true) {
					inputDeleteMovie();
				}

				if (inputFromUser.toUpperCase().equals("SEARCH") == true) {
					inputSearchMovie();
				}

				if (inputFromUser.toUpperCase().equals("IMPORT") == true) {
					String filePath;
					theView.showMessage("Import Collection> Give the path to the file: ");
					filePath = theView.getUserInput();
					try {
						inputImportCollection(filePath);
					} catch (JDOMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (inputFromUser.toUpperCase().equals("EXPORT") == true) {
					String filePath;
					theView.showMessage("Export Collection> Give the name of the file (and the path, if you want it in a specific place): ");
					filePath = theView.getUserInput();
					inputExportCollection(filePath);
				}
				
				if ((inputFromUser.toUpperCase().equals("GENERATE REPORT") == true) || (inputFromUser.toUpperCase().equals("REPORT") == true) || (inputFromUser.toUpperCase().equals("GENERATE") == true)){
					String filePath;
					theView.showMessage("Generate Report> Give the name of the file (and the path, if you want it in a specific place): ");
					filePath = theView.getUserInput();
					inputGenerateReport(filePath);
				}
				
				if (inputFromUser.toUpperCase().equals("SERIALIZE") == true){
					String filePath;
					theView.showMessage("Serialize> Give the name of the file (and the path, if you want it in a specific place): ");
					filePath = theView.getUserInput();
					inputSerialize(filePath);
				}
				if (inputFromUser.toUpperCase().equals("DESERIALIZE") == true){
					String filePath;
					theView.showMessage("Deserialize> Give the path to the file: ");
					filePath = theView.getUserInput();
					inputDeserialize(filePath);
				}

			} while (inputFromUser.toUpperCase().equals("EXIT") == false);
		} catch (BadFileFormatException badFile) {
			System.out.println("BadFileFormatException: "
					+ badFile.getMessage());
		}
	}

	/**
	 * the function that handles the add of a new movie
	 */
	private void inputAddMovie() {
		String title;
		String imdbID;
		String releaseDate;
		String rating;
		String shortDescription;
		ArrayList<Category> modelCategories;
		ArrayList<Category> movieCategories;
		String inputCategories;

		// process title input
		theView.showMessage("Add Movie> Title: ");
		title = theView.getUserInput();

		while (checkTitle(title) == false) {
			theView.showMessage("Add Movie> There exists a movie with the same title! Insert another title");
			theView.showMessage("Add Movie> Title: ");
			title = theView.getUserInput();
		}

		// process categories input
		theView.showMessage("Add Movie> Now that you inserted the title, please select the movie categories");
		modelCategories = theModel.getCategoriesList();
		theView.showMessage("Add Movie> ");
		theView.showCategories(modelCategories);
		theView.showMessage("Add Movie> Insert your movie`s categories followed by commas");
		theView.showMessage("Add Movie> You can add from that list or put new ones");
		inputCategories = theView.getUserInput();

		movieCategories = createMovieCategoriesList(inputCategories);

		// process releaseDate
		theView.showMessage("Add Movie> Now that you inserted the categories, please insert the release date");
		theView.showMessage("Add Movie> Release Date (dd-mm-yyyy): ");
		releaseDate = theView.getUserInput();

		while (isValidDate(releaseDate) == false) {
			theView.showMessage("Add Movie> The date you inserted is not correct! Please follow the format");
			theView.showMessage("Add Movie> Release Date (dd-mm-yyyy): ");
			releaseDate = theView.getUserInput();
		}

		// process imdbID
		theView.showMessage("Add Movie> Now that you inserted the release date, please insert the IMDB ID");
		theView.showMessage("Add Movie> For now, we can't check the ID, but we will implement that soon so please be careful to insert a good value!");
		theView.showMessage("Add Movie> IMDB ID: ");
		imdbID = theView.getUserInput();

		// process rating
		theView.showMessage("Add Movie> Now that you inserted the IMDB ID, please insert the rating");
		theView.showMessage("Add Movie> Rating (1-10): ");
		rating = theView.getUserInput();

		while (isValidRating(rating) == false) {
			theView.showMessage("Add Movie> The rating you have given is not correct! Please follow the rule");
			theView.showMessage("Add movie> Rating (1-10: ");
			rating = theView.getUserInput();
		}

		// process shortDescription
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

	/**
	 * the function that handles the edit of a movie
	 */	
	private void inputEditMovie() {
		String selectTitle;

		// what movie to edit?
		theView.showMessage("Edit Movie> Title: ");
		selectTitle = theView.getUserInput();

		if (existsWithTitle(selectTitle) == true) {
			Movie movie = getMovieWithTitle(selectTitle);
			String newTitle;

			theView.showMessage("Edit Movie> Set the new Title: ");
			newTitle = theView.getUserInput();
			theView.showMessage("Edit Movie> The other fields' edit will be added later");

			movie.setTitle(newTitle);

			if (movie.getTitle().equals(newTitle) == true) {
				theView.showMessage("Edit Movie> Movie edited!");
			} else {
				theView.showMessage("Edit Movie> Movie not edited!");
			}

		}
	}
	
	/**
	 * the function that handles the deletion of a movie
	 */	
	private void inputDeleteMovie() {
		String selectTitle;

		// what movie to delete?
		theView.showMessage("Delete Movie> Title: ");
		selectTitle = theView.getUserInput();

		if (existsWithTitle(selectTitle) == true) {
			Movie movie = getMovieWithTitle(selectTitle);

			theModel.deleteMovie(movie);
		}
	}

	/**
	 * the function that handles the search of a movie
	 */
	private void inputSearchMovie() {
		String selectTitle;

		// what movie to search for
		theView.showMessage("Search Movie> Title");
		selectTitle = theView.getUserInput();

		if (existsWithTitle(selectTitle) == true) {
			Movie movie = getMovieWithTitle(selectTitle);

			theView.showMovie(movie);
		}
	}

	/**
	 * 
	 * @param filePath the file path to where the .xml file would be created
	 */
	private void inputExportCollection(String filePath) {
		File exportFile = new File(filePath);
		// if(file.isFile()) // Check if exists & is file
		try {
			ArrayList<Movie> movieList = theModel.getMovieList();

			Element collection = new Element("movieCollection");
			Document doc = new Document(collection);
			doc.setRootElement(collection);

			Element moviesTag = new Element("movies");
			moviesTag.setAttribute(new Attribute("size", Integer
					.toString(theModel.getMovieList().size())));
			doc.getRootElement().addContent(moviesTag);

			for (Movie movie : movieList) {
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
				categoriesTag.setAttribute(new Attribute("size", Integer
						.toString(movie.getCategories().size())));

				ArrayList<Category> movieCategories = movie.getCategories();

				for (Category category : movieCategories) {
					Element categoryTag = new Element("category");
					categoryTag.setAttribute(new Attribute("name", category
							.getCategoryName()));
					categoryTag.setAttribute(new Attribute("description",
							category.getCategoryDescription()));

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
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	/**
	 * @param filePath the file path to where the .xml file from which the import is being done
	 * @throws JDOMException
	 * @throws BadFileFormatException
	 */
	private void inputImportCollection(String filePath) throws JDOMException, BadFileFormatException {
		SAXBuilder fileBuilder = new SAXBuilder();

		File importFile = new File(filePath);

		try {

			Document doc = (Document) fileBuilder.build(importFile);
			Element rootNode = doc.getRootElement();

			List<?> list = rootNode.getChildren(); // movieCollection

			for (int i = 0; i < list.size(); ++i) {
				Element moviesNode = (Element) list.get(i); // movies

				if (moviesNode.getName().equals("movies") == true) {

					List<?> moviesList = moviesNode.getChildren();

					for (int k = 0; k < moviesList.size(); ++k) {

						Element movieNode = (Element) moviesList.get(k); // movie

						Movie m = new Movie();

						List<?> movieTags = movieNode.getChildren();

						Element imdbID = (Element) movieTags.get(0);
						m.setImdbID(imdbID.getText());
						Element title = (Element) movieTags.get(1);
						m.setTitle(title.getText());
						Element releaseDate = (Element) movieTags.get(2);
						m.setReleaseDate(releaseDate.getText());
						Element rating = (Element) movieTags.get(3);
						m.setRating(Double.valueOf(rating.getText()));
						Element shortDescription = (Element) movieTags.get(4);
						m.setShortDescription(shortDescription.getText());
						Element categoriesNode = (Element) movieTags.get(5);

						List<?> categoriesList = categoriesNode.getChildren();

						for (int l = 0; l < categoriesList.size(); ++l) {
							Element tag = (Element) categoriesList.get(l);

							Category category = new Category();

							category.setCategoryName(tag.getAttribute("name")
									.getValue());
							category.setCategoryDescription(tag.getAttribute(
									"description").getValue());

							m.addCategory(category);

							theModel.addCategory(category);
						}

						theModel.addMovie(m);

					}

				} else {
					throw new BadFileFormatException();
				}

			}

			System.out.println("File Imported!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	/**
	 * 
	 * @param filePath to where the .xls file is saved
	 */
	private void inputGenerateReport(String filePath){
		
		ArrayList<Movie> moviesSortedByTitle = new ArrayList<Movie>();
		ArrayList<Movie> moviesSortedByRating = new ArrayList<Movie>();
		ArrayList<Movie> moviesSortedByReleaseDate = new ArrayList<Movie>();
		
		moviesSortedByTitle = theModel.getMovieList();
		moviesSortedByRating = theModel.getMovieList();
		moviesSortedByReleaseDate = theModel.getMovieList();
		
		moviesSortedByTitle.sort(new Comparator<Movie>(){
			public int compare(Movie m1, Movie m2){
				return m1.getTitle().compareTo(m2.getTitle());
			}
		});
		
		moviesSortedByRating.sort(new Comparator<Movie>(){
			public int compare(Movie m1, Movie m2){
				if (m1.getRating() < m2.getRating()){
					return 1;
				}
				return 0;
			}
		});
		
		moviesSortedByReleaseDate.sort(new Comparator<Movie>(){
			public int compare(Movie m1, Movie m2){
				String[] release1 = m1.getReleaseDate().split("-");
				String[] release2 = m2.getReleaseDate().split("-");
				int day1 = Integer.parseInt(release1[0]);
				int day2 = Integer.parseInt(release2[0]);
				int mon1 = Integer.parseInt(release1[1]);
				int mon2 = Integer.parseInt(release2[1]);
				int yr1 = Integer.parseInt(release1[2]);
				int yr2 = Integer.parseInt(release2[2]);
				
				Date d1 = new Date(day1, mon1, yr1);
				Date d2 = new Date(day2, mon2, yr2);
				
				return d1.compareTo(d2);
			}
		});
		
		
		for (int i = 0; i < moviesSortedByReleaseDate.size(); ++i)
			System.out.println(moviesSortedByReleaseDate.get(i).getTitle() + " " + moviesSortedByReleaseDate.get(i).getReleaseDate());
		
		ReportGenerator reportGenerator = new ReportGenerator(moviesSortedByTitle, moviesSortedByRating, moviesSortedByReleaseDate);
		reportGenerator.generateReport(filePath);
		
	}
	
	/**
	 * 
	 * @param filePath to where the .ser file is saved
	 */
	private void inputSerialize(String filePath){
		try {
			FileOutputStream output;
			output = new FileOutputStream(filePath);
			ObjectOutputStream objOut = new ObjectOutputStream(output);

			objOut.writeObject(theModel);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param filePath to where the input .ser file from which the deserialize is being done
	 */
	private void inputDeserialize(String filePath){
		try {	
			FileInputStream output;
			output = new FileInputStream(filePath);
			ObjectInputStream objIn = new ObjectInputStream(output);

			MovieCollection model = (MovieCollection) objIn.readObject(); 
			
			theView.showMovieCollection(model);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}

	}
	
	/**
	 * @param title
	 *            the title that we want to check
	 * @return true if the title is good, false otherwise
	 */
	private boolean checkTitle(String title) throws SameTitleMovieException {
		if (theModel.existsWithTitle(title) == true) {
			return false;
			//throw new SameTitleMovieException();
		} else
			return true;
	}

	/**
	 * @param String
	 *            inputCategories the categories separated by commas
	 * @return ArrayList<Category> the movie's categories derived from
	 *         inputCategories
	 */
	private ArrayList<Category> createMovieCategoriesList(String inputCategories) {

		String[] categories = inputCategories.split(", ");
		ArrayList<Category> movieCategoriesList = new ArrayList<Category>();

		for (String cat : categories) {
			Category category = new Category();
			category.setCategoryName(cat);

			movieCategoriesList.add(category);
		}

		return movieCategoriesList;
	}

	/**
	 * @param date
	 *            a string in which the date is saved
	 * @return true if the date is a valid one, false otherwise
	 */
	private boolean isValidDate(String inputDate) {

		String[] theDate = inputDate.split("-");

		if (theDate.length != 3) {
			return false;
		}
		if (Integer.parseInt(theDate[0]) <= 0
				|| Integer.parseInt(theDate[0]) >= 32) {
			// the day
			return false;
		}
		if (Integer.parseInt(theDate[1]) <= 0
				|| Integer.parseInt(theDate[1]) >= 13) {
			// the month
			return false;
		}
		if (Integer.parseInt(theDate[2]) <= 1900
				|| Integer.parseInt(theDate[2]) >= 2016) {
			// the year
			return false;
		}

		return true;
	}

	/**
	 * @param inputRating
	 *            the rating given as a string
	 * @return true if the rating is correct (between 1-10), false otherwise
	 */
	private boolean isValidRating(String inputRating) {

		if (Integer.parseInt(inputRating) <= 0
				|| Integer.parseInt(inputRating) >= 11) {
			return false;
		}

		return true;
	}

	/**
	 * @param title
	 *            the title of the movie
	 * @return the movie that has the title equal with title, null otherwise
	 */
	private Movie getMovieWithTitle(String title) {
		ArrayList<Movie> movieList = theModel.getMovieList();

		for (Movie movie : movieList) {
			if (movie.getTitle().equals(title) == true)
				return movie;
		}

		return null;
	}

	/**
	 * @param title
	 *            the title of the movie
	 * @return true if there exists a movie with that title, false otherwise
	 */
	private boolean existsWithTitle(String title) {

		if (getMovieWithTitle(title) == null)
			return false;

		return true;
	}

	private class BadFileFormatException extends RuntimeException {
		static final String message = "The file does not have a correct format! Please check it!";

		public BadFileFormatException() {
			super(message);
		}
	}

	private class SameTitleMovieException extends RuntimeException {
		static final String message = "Another movie already has the same title! Please give another one to this one!";

		public SameTitleMovieException() {
			super(message);
		}
	}

}
