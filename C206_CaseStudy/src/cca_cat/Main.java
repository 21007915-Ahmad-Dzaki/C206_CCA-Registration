package cca_cat;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author 21010539
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Category> obj = new ArrayList<Category>();
		obj.add(new Category("Test" ));
		Main main = new Main();
		main.start(obj);
	}
	
	public void start(ArrayList<Category> obj) {

		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter num 1-3 OR 4 to end > ");
			if (option == 1) {
				viewCat(obj);
			} else if (option == 2) {
				addCat(obj, inputAddCat());
			} else if (option == 3) {
				removeCat(obj);
			}
		}
	}

	public void menu() {
		Helper.line(30, "=");
		System.out.println("1. View All\n2. Add Cat\n3. Remove Cat\n4. End");
		Helper.line(30, "=");
	}

	//View All Cat
	private static void viewCat(ArrayList<Category> obj) {
		// TODO Auto-generated method stub
		String output = "Categories: ";
		output += loadData(obj);
		System.out.println(output);
	}
	
	//Add Cat
	public static Category inputAddCat() {
		String input = Helper.readString("Enter Category name > ");
		Category input2 = new Category(input);
		return input2;
	}
	
	public static void addCat(ArrayList<Category> obj, Category input) {
		obj.add(input);
	}
	
	//Remove Cat
	public static boolean isExist(ArrayList<Category> obj, String input) {
		boolean check = false;
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getCname().equalsIgnoreCase(input)) {
				obj.remove(i);
				check = true;
			}
		}
		return check;
	}
	public static void removeCat(ArrayList<Category> obj) {
		String input = Helper.readString("Enter Category name > ");
		boolean check = isExist(obj, input);
		
		if (check == true) {
			System.out.println("Remove Successful");
		} else if (check == false) {
			System.out.println("Name does not exist! Remove fail!");
		}
	}
	
	//Load ArrayData
	public static String loadData(ArrayList<Category> obj) {
		String output = "";
		for (Category C : obj) {
			output += "\n" + C.getCname();
		}
		return output;
	}

	
}
