/**
 * 
 */
package movie.collection;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Virgil Barcan
 *
 */

public class View {

	private MovieCollection movieCollection; //model in the MVC pattern
	private Scanner input;

	public View(MovieCollection movieCollection){
		this.movieCollection = movieCollection;
		
		try {
			input = new Scanner(System.in);
		} catch (Exception e) {
			System.out.println("Exception when creating the Scanner");
			e.printStackTrace();
		}
	}
	
	public void showMenu(){
		
		System.out.println("Menu");
		System.out.println(MenuItems.ADD);
		System.out.println(MenuItems.EDIT);
		System.out.println(MenuItems.DELETE);	
		System.out.println(MenuItems.IMPORT);	
		System.out.println(MenuItems.EXPORT);	
		System.out.println(MenuItems.EXIT);	
		
	}
	
	public void showMessage(String messageToShow){
		
		System.out.println(messageToShow); //could be Add Movie, Edit Movie...
		
	}
	
	public void showCategories(ArrayList<Category> categories){
		this.showMessage("Possible categories to choose from:");
		
		for (int i = 0; i < categories.size() - 1; ++i){
			System.out.print((categories.get(i)).getCategoryName() + ", ");
		}
		System.out.println(categories.get(categories.size() - 1).getCategoryName());
	}
	
	public String getUserInput(){
		String inputFromUser = new String();
		
		try {
			inputFromUser = input.nextLine();
		} catch (Exception e) {
			System.out.println("Exception when reading user input");
			e.printStackTrace();
		}
		
		return inputFromUser;
	}
	
	private enum MenuItems {
		ADD {
			//add movie to collection
			public String toString(){
				return "Add Movie";
			}
		}, 
		EDIT {
			//edit movie from collection
			public String toString(){
				return "Edit Movie";
			}
		}, 
		DELETE {
			//delete movie from collection
			public String toString(){
				return "Delete Movie";
			}
		}, 
		SEARCH {
			//search movie in collection
			public String toString(){
				return "Search Movie";
			}
		}, 
		IMPORT {
			//import collection file
			public String toString(){
				return "Import Movie Collection";
			}
		}, 
		EXPORT {
			//export collection
			public String toString(){
				return "Export Movie Collection";
			}
		},
		EXIT {
			//exit the application
			public String toString(){
				return "Exit";
			}
		}
	}

}
