/**
 * 
 */
package movie.collection;

/**
 * @author Virgil Barcan
 *
 */
public class Category {

	private String categoryName;
	private String categoryDescription;
	
	//implicit constructor
	/**
	 * 
	 */
	public Category(){
		initialize();
	}
	
	//explicit constructors
	/**
	 * @param categoryName
	 * @param categoryDescription
	 */
	public Category(String categoryName, String categoryDescription) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	
	/**
	 * 
	 */
	private void initialize(){
		categoryName = new String();
		categoryDescription = new String();
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryDescription
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * @param categoryDescription the categoryDescription to set
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
}
