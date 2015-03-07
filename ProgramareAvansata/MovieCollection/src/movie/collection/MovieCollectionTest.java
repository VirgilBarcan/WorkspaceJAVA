/**
 * 
 */
package movie.collection;

/**
 * @author Virgil Barcan
 *
 */
public class MovieCollectionTest {

	/**
	 * @param args
	*/
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		MovieCollection theModel = new MovieCollection();
		View theView = new View(theModel);
		Controller theController = new Controller(theModel, theView);
		
		Category category1 = new Category();
		category1.setCategoryName("Comedy");
		Category category2 = new Category();
		category2.setCategoryName("Drama");
		theModel.addCategory(category1);
		theModel.addCategory(category2);
		
		System.out.println(theModel.getCategoriesList().get(0).getCategoryName());
		
		theController.run();
		theView.showMovieCollection();
		
		System.out.println("Bye!");
	}
 
}
