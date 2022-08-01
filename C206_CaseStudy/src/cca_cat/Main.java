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
	ArrayList<Category> obj = new ArrayList<Category>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.start();
	}
	
	public void start() {
		obj.add(new Category("Test" ));
//		obj.add(new CCADetails("Test","test2"));

		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter num 1-3 OR 4 to end > ");
			if (option == 1) {
				viewCat();
			} else if (option == 2) {
				addCat();
			} else if (option == 3) {
				removeCat();
			}
		}
	}
	
	public void menu() {
		Helper.line(30, "=");
		System.out.println("1. View All\n2. Add Cat\n3. Remove Cat\n4. End");
		Helper.line(30, "=");
	}
	public void viewCat() {
		for (Category C : obj) {
			System.out.println(C.getCname());
//			CCADetails S = (CCADetails) C;
//			if (!S.getName().equals(null)) {
//				System.out.println(S.getName());
//			}
			
		}
	}
	public void addCat() {
		String input = Helper.readString("Enter Category name > ");
		obj.add(new Category(input));
//		obj.add(new CCADetails(input, ""));
	}
	
	public void removeCat() {
		String input = Helper.readString("Enter Category name > ");
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getCname().equals(input)) {
				obj.remove(i);
			}
		}

	}

}
