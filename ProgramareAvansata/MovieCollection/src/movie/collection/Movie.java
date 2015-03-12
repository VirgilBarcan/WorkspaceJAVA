/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

/**
 * @author Virgil Barcan
 *
 */
public class Movie implements Serializable {

	private String title;
	private String imdbID;
	private ArrayList<Category> categories;
	private String releaseDate;
	private Double rating;
	private String shortDescription;

	// implicit constructor
	/**
	 * 
	 */
	public Movie() {
		initialize();
	}

	// explicit constructors
	/**
	 * @param title
	 * @param imdbID
	 * @param categories
	 * @param releaseDate
	 * @param rating
	 * @param shortDescription
	 */
	public Movie(String title, String imdbID, ArrayList<Category> categories,
			String releaseDate, Double rating, String shortDescription) {
		initialize();

		this.title = title;
		this.imdbID = imdbID;
		this.categories = categories;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.shortDescription = shortDescription;
	}

	/**
	 * 
	 */
	private void initialize() {
		title = new String();
		imdbID = new String();
		categories = new ArrayList<Category>();
		releaseDate = new String();
		rating = 0.0;
		shortDescription = new String();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @param imdbID
	 *            the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @param category
	 *            the category to add to the list of categories
	 */
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 *            the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription
	 *            the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getCategoriesAsString(){
		String result = new String();
		
		for (int i = 0; i < this.categories.size(); ++i){
			result += categories.get(i).getCategoryName() + " ";
		}
		
		return result;
	}
	
}
