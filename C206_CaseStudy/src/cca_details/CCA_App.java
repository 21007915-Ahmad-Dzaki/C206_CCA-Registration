/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ahmad Dzaki Bin Osman, 21007915, 26 Jul 2022 8:39:02 pm
 */

package cca_details;

import java.util.ArrayList;

/**
 * @author ahmad
 *
 */
public class CCA_App {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		String[] daysList = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		ccaList.add(new CCA("Little League Soccer", "Soccer Club for Boys", 30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat" ));
		ccaList.add(new CCA("LEGO Expert", "LEGO building masters", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon" ));
		
		int option = 0;
		
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				viewAllCCA(ccaList);
			}
			else if (option == 2) {
				addCCA(daysList,ccaList);
			}
			else if (option == 3) {
				deleteCCA(ccaList);
			}
			else if (option == 4) {
				System.out.println("Thank you for using our App!");
			}
			
		}
		
		
	}
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "\nLIST OF CCA\n";
		output += Helper.line(12,"-");
		for (int i = 0;i<ccaList.size();i++) {
			output += String.format((i+1) + ". %s\n", ccaList.get(i).getTitle());
		}
		System.out.println(output);
	}
	
	public static void addCCA(String[] daysList,ArrayList<CCA> ccaList) {
		
		boolean add = false;
		String output = String.format("%-23s %-25s %-13s %-12s %-18s %-15s %-10s\n", 
				"TITLE","DESCRIPTION","CLASS SIZE","DAY","TIME","VENUE","IN-CHARGE");
		
		String title = Helper.readString("Enter CCA Title > ");
		String desc = Helper.readString("Enter CCA Description > ");
		int classSize = Helper.readInt("Enter CCA Class Size > ");
		String day = Helper.readString("Enter Day of CCA > ");
		String time = Helper.readString("Enter Duration of CCA > ");
		String venue = Helper.readString("Enter venue of CCA > ");
		String name = Helper.readString("Enter Name of Instructor In-Charge > ");
		
		if(classSize<=50) {
			for (int i = 0;i<daysList.length;i++) {
				if(daysList[i].equalsIgnoreCase(day)) {
					ccaList.add(new CCA(title,desc,classSize,day,time,venue,name));
					add = true;
				}else {
					System.out.println("Please enter a valid day!");
					break;
				}
			}
		}else {
			System.out.println("Class size must not be more than 50!");
			
		}
		
		if(add) {
			System.out.println("CCA added!");
		}else {
			System.out.println("Failed to add CCA");
		}
	}
	
	public static void menu() {
		System.out.println("WELCOME TO CCA MANAGEMENT SYSTEM");
		Helper.lines(32, "-");
		System.out.println("1. View All");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Quit");
	}
	
	public static void deleteCCA(ArrayList<CCA> ccaList) {
		String output = String.format("%-23s %-25s %-13s %-12s %-18s %-15s %-10s\n", 
				"TITLE","DESCRIPTION","CLASS SIZE","DAY","TIME","VENUE","IN-CHARGE");
		System.out.println("DELETING CCA");
		String name = Helper.readString("Enter name of CCA > ");
		boolean del = false;
		boolean removed = false;
		
		for (CCA c:ccaList) {
			if (c.getName().equalsIgnoreCase(name)) {
				output += c.display();
				del = Helper.readBoolean("Confirm to delete? (Y/N)");
				if (del) {
					ccaList.remove(c);
					removed = true;
				}
			}
		}
		if (removed) {
			System.out.println("CCA has been deleted");
		}else {
			System.out.println("Failed to delete CCA");
		}
	}
}
