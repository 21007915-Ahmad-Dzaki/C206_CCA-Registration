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
			menuCCA();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				viewAllCCA(ccaList);
			}
			else if (option == 2) {
				CCA cca = inputCCAadd(daysList);
				addCCA(ccaList,cca);
				System.out.println("CCA has been added!");
			}
			else if (option == 3) {
				CCA cca = inputCCAdel(ccaList);
				deleteCCA(ccaList,cca);
				System.out.println("CCA has been deleted!");
			}
			else if (option == 4) {
				System.out.println("Thank you for using our App!");
			}
			
		}
		
		
	}
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

		for (int i = 0;i<ccaList.size();i++) {
			output += ccaList.get(i).display();
		}
		return output;
	}
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "\nLIST OF CCA\n";
		output += Helper.line(12,"-");
		output += String.format("%-23s %-25s %-13s %-12s %-18s %-15s %-10s\n", 
				"TITLE","DESCRIPTION","CLASS SIZE","DAY","TIME","VENUE","IN-CHARGE");
		output += retrieveAllCCA(ccaList);
		
		System.out.println(output);
	}
	
	public static CCA inputCCAadd(String[] daysList) {
		String title = Helper.readString("Enter CCA Title > ");
		String desc = Helper.readString("Enter CCA Description > ");
		int classSize = Helper.readInt("Enter CCA Class Size > ");

		
		while(classSize>50 || classSize<0) {
			System.out.println("Class Size should be 50 or less");
			classSize = Helper.readInt("Enter CCA Class Size > ");		
		}
		
		String day = Helper.readString("Enter Day of CCA > ");
		
//		for (int i = 0;i<daysList.length;i++) {
//			while(day.equals(daysList[i])){
//				System.out.println("Enter a valid day");
//				day = Helper.readString("Enter Day of CCA > ");
//			}
//
//		}
		String time = Helper.readString("Enter Duration of CCA (__pm -__pm)> ");
		String venue = Helper.readString("Enter venue of CCA > ");
		String name = Helper.readString("Enter Name of Instructor In-Charge > ");

		CCA cca= new CCA(title,desc,classSize,day,time,venue,name);
		return cca;
		
	}
	
	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {		
		ccaList.add(cca);
	}
	
	public static void menuCCA() {
		System.out.println("WELCOME TO CCA MANAGEMENT SYSTEM");
		Helper.lines(32, "-");
		System.out.println("1. View All");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Quit");
	}
	public static CCA inputCCAdel(ArrayList<CCA> ccaList) {
		String title = Helper.readString("Enter CCA Title > ");
		String desc = "";
		int classSize = 0;
		String day = "";
		String time = "";
		String venue = "";
		String name = "";


		for (CCA c: ccaList) {
			if (title.equals(c.getTitle())){
				title = c.getTitle();
				desc = c.getDescription();
				classSize = c.getClassSize();
				day = c.getDay();
				time = c.getTime();
				venue = c.getVenue();
				name = c.getName();
			}
		}
		CCA cca= new CCA(title,desc,classSize,day,time,venue,name);
		return cca;	
	}
	public static void deleteCCA(ArrayList<CCA> ccaList,CCA cca) {
		System.out.println("DELETING CCA....");
		ccaList.remove(cca);
	}
}
