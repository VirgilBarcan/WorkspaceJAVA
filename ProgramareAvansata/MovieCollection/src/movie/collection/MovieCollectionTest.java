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
 *
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

		System.out.println(theModel.getCategoriesList().get(0)
				.getCategoryName());

		theController.run();
		// theView.showMovieCollection();

		// serialize objects
		try {
			
			System.out.println("Serializing the movie collection");
			
			FileOutputStream output;
			output = new FileOutputStream("serializareObiecte.ser");
			ObjectOutputStream objOut = new ObjectOutputStream(output);

			objOut.writeObject(theModel);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// deserialize objects
		try {
			
			System.out.println("Deserializing the movie collection");
			
			FileInputStream output;
			output = new FileInputStream("serializareObiecte.ser");
			ObjectInputStream objIn = new ObjectInputStream(output);

			MovieCollection model = (MovieCollection) objIn.readObject(); 
			
			theView.showMovieCollection(model);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("Bye!");
	}

}
