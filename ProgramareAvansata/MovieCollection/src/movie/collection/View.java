/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Virgil Barcan
 * @author Alex Munteanu
 */

public class View {

	private MovieCollection movieCollection; // model in the MVC pattern
	private Scanner input;

	/**
	 * 
	 * @param movieCollection the model for the view
	 */
	public View(MovieCollection movieCollection) {
		this.movieCollection = movieCollection;

		try {
			input = new Scanner(System.in);
		} catch (Exception e) {
			System.out.println("Exception when creating the Scanner");
			e.printStackTrace();
		}
	}

	/**
	 * the function that prints the menu for the application
	 */
	public void showMenu() {

		System.out.println("Menu");
		System.out.println(MenuItems.ADD);
		System.out.println(MenuItems.EDIT);
		System.out.println(MenuItems.DELETE);
		System.out.println(MenuItems.IMPORT);
		System.out.println(MenuItems.EXPORT);
		System.out.println(MenuItems.REPORT);
		System.out.println(MenuItems.SERIALIZE);
		System.out.println(MenuItems.DESERIALIZE);
		System.out.println(MenuItems.EXIT);

	}

	/**
	 * 
	 * @param messageToShow the message to print to the user
	 */
	public void showMessage(String messageToShow) {

		System.out.println(messageToShow); // could be Add Movie, Edit Movie...

	}

	/**
	 * 
	 * @param categories the categories inserted in the application
	 */
	public void showCategories(ArrayList<Category> categories) {
		this.showMessage("Possible categories to choose from:");

		for (int i = 0; i < categories.size() - 1; ++i) {
			System.out.print((categories.get(i)).getCategoryName() + ", ");
		}
		System.out.println(categories.get(categories.size() - 1)
				.getCategoryName());
	}

	/**
	 * 
	 * @param movieCollection the model to be shown
	 */
	public void showMovieCollection(MovieCollection movieCollection) {

		ArrayList<Movie> movieList = movieCollection.getMovieList();

		System.out.println("Movie Collection");

		for (Movie movie : movieList) {
			System.out.println("Title: " + movie.getTitle());
			System.out.println("IMDB ID: " + movie.getImdbID());

			ArrayList<Category> categories = movie.getCategories();

			System.out.print("Categories: ");
			for (Category category : categories) {
				System.out.print(category.getCategoryName() + " ");
			}
			System.out.println();
			System.out.println("Release Date: " + movie.getReleaseDate());
			System.out.println("Rating: " + movie.getRating());
			System.out.println("Short Description: "
					+ movie.getShortDescription());

			System.out.println();
		}

	}

	/**
	 * 
	 * @param movie the movie to be shown
	 */
	public void showMovie(Movie movie) {
		System.out.println("Title: " + movie.getTitle());
		System.out.println("IMDB ID: " + movie.getImdbID());

		ArrayList<Category> categories = movie.getCategories();

		System.out.print("Categories: ");
		for (Category category : categories) {
			System.out.print(category.getCategoryName() + " ");
		}
		System.out.println();
		System.out.println("Release Date: " + movie.getReleaseDate());
		System.out.println("Rating: " + movie.getRating());
		System.out.println("Short Description: " + movie.getShortDescription());

		System.out.println();
	}

	/**
	 * 
	 * @return the input from the user
	 */
	public String getUserInput() {
		String inputFromUser = new String();

		try {
			inputFromUser = input.nextLine();
		} catch (Exception e) {
			System.out.println("Exception when reading user input");
			e.printStackTrace();
		}

		return inputFromUser;
	}

	/**
	 * 
	 * @author Virgil Barcan
	 *
	 * An enum which stores all the possible menu items
	 */
	private enum MenuItems {
		ADD {
			// add movie to collection
			public String toString() {
				return "Add Movie";
			}
		},
		EDIT {
			// edit movie from collection
			public String toString() {
				return "Edit Movie";
			}
		},
		DELETE {
			// delete movie from collection
			public String toString() {
				return "Delete Movie";
			}
		},
		SEARCH {
			// search movie in collection
			public String toString() {
				return "Search Movie";
			}
		},
		IMPORT {
			// import collection file
			public String toString() {
				return "Import Movie Collection";
			}
		},
		EXPORT {
			// export collection
			public String toString() {
				return "Export Movie Collection";
			}
		},
		REPORT {
			//generate xls report
			public String toString() {
				return "Generate Report";
			}
		},
		SERIALIZE {
			//generate the serialized objects
			public String toString() {
				return "Serialize";
			}
		},
		DESERIALIZE {
			//recreate the objects from the serialized ones
			public String toString() {
				return "Deserialize";
			}
		},
		EXIT {
			// exit the application
			public String toString() {
				return "Exit";
			}
		}
	}

}
