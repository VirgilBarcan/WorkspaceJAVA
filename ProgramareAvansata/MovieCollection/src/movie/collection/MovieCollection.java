/**
 * 
 */
package movie.collection;

import java.util.ArrayList;

/**
 * @author Virgil Barcan
 *
 */
public class MovieCollection {

	private ArrayList<Movie> movieList;
	
	//implicit constructor
	/**
	 * 
	 */
	public MovieCollection(){
		initialize();
	}
	
	/**
	 * @param movieList
	 */
	public MovieCollection(ArrayList<Movie> movieList) {
		super();
		this.movieList = movieList;
	}



	/**
	 * 
	 */
	private void initialize(){
		movieList = new ArrayList<Movie>();
	}

	/**
	 * @return the movieList
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList the movieList to set
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
}
