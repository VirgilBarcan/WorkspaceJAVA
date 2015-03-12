/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.Serializable;

/**
 * @author Virgil Barcan
 *
 */
public class MovieCollection implements Serializable {

	private ArrayList<Movie> movieList;
	private ArrayList<Category> categoriesList;

	// implicit constructor
	/**
	 * 
	 */
	public MovieCollection() {
		initialize();
	}

	/**
	 * @param movieList
	 */
	public MovieCollection(ArrayList<Movie> movieList) {
		initialize();
		this.movieList = movieList;
	}

	/**
	 * 
	 */
	private void initialize() {
		movieList = new ArrayList<Movie>();
		categoriesList = new ArrayList<Category>();
	}

	/**
	 * @return the movieList
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the categoriesList
	 */
	public ArrayList<Category> getCategoriesList() {
		return categoriesList;
	}

	/**
	 * @param categoriesList
	 *            the categoriesList to set
	 */
	public void setCategoriesList(ArrayList<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}

	/**
	 * @param movie
	 *            the movie to add to the list
	 */
	public void addMovie(Movie movie) {
		if (existsMovie(movie) == false)
			movieList.add(movie);
	}

	/**
	 * @param category
	 *            the category to add to the list
	 */
	public void addCategory(Category category) {
		if (existsCategory(category) == false)
			categoriesList.add(category);
	}

	/**
	 * @param movie
	 *            the movie to delete from the list
	 */
	public void deleteMovie(Movie movie) {
		movieList.remove(movie);
	}

	/**
	 * @param movie
	 *            the movie to search for in the list
	 * @return the searched movie, if it exists
	 */
	public Movie searchMovie(Movie movie) {

		for (Movie m : movieList) {
			if (m.equals(movie) == true)
				return m;
		}

		return null;
	}

	/**
	 * @param String
	 *            title the title to search for in the list
	 * @return true if movie with title exists, false otherwise
	 */
	public boolean existsWithTitle(String title) {

		for (Movie m : movieList) {
			if (m.getTitle().equals(title) == true)
				return true;
		}

		return false;
	}

	/**
	 * @param movie
	 *            the category to check for
	 * @return true if the movie already exists, false otherwise
	 */
	private boolean existsMovie(Movie movie) {

		for (Movie m : movieList) {
			if (m.equals(movie) == true) {
				return true;
			}
		}

		return false;

	}

	/**
	 * @param category
	 *            the category to check for
	 * @return true if the category already exists, false otherwise
	 */
	private boolean existsCategory(Category category) {

		for (Category c : categoriesList) {
			if (c.equals(category) == true) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<Movie> sortBy(Comparator typeOfSort){
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>();
		
		sortedMovies = this.getMovieList();
		sortedMovies.sort(typeOfSort);
		
		return sortedMovies;
	}

}
