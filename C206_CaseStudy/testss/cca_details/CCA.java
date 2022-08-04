/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ahmad Dzaki Bin Osman, 21007915, 26 Jul 2022 8:39:17 pm
 */

package cca_details;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ahmad
 *
 */
public class CCA {

	private String title;
	private String description;
	private int classSize;
	private String day;
	private String time;
	private String venue;
	private String name;

	public CCA(String title, String description, int classSize, String day, String time, String venue, String name) {
		super();
		this.title = title;
		this.description = description;
		this.classSize = classSize;
		this.day = day;
		this.time = time;
		this.venue = venue;
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the classSize
	 */
	public int getClassSize() {
		return classSize;
	}

	/**
	 * @param classSize the classSize to set
	 */
	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	// for students/parents to see CCA details
	public String display() {
		
		String output = String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n",title,description,classSize,
				day,time,venue,name);
		return output;
	}
}
