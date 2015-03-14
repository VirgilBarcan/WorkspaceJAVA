/**
 * 
 */
package movie.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Virgil Barcan
 * @author Alex Munteanu
 */
public class MovieCollectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieCollection theModel = new MovieCollection();
		View theView = new View(theModel);
		Controller theController = new Controller(theModel, theView);

		Category category1 = new Category();
		category1.setCategoryName("Comedy");
		Category category2 = new Category();
		category2.setCategoryName("Drama");
		theModel.addCategory(category1);
		theModel.addCategory(category2);

		theController.run();
		// theView.showMovieCollection();

		System.out.println("Bye!");
	}

}
