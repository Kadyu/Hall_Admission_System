package HallAdmissionSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import HallAdmissionSystem.exceptions.InvalidFileException;

public class Student extends Account {
	private int studentID;
	private boolean isLocal;
	private int year;

	public Student(int id, String username, String password, boolean local, int yearOfStudy) {
		super(username, password);
		this.studentID = id;
		this.isLocal = local;
		this.year = yearOfStudy;
	}

	public int getSid() {
		return this.studentID;
	}

	public int getYear() {
		return this.year;
	}

	public boolean getIsLocalStudent() {
		return isLocal;
	}

	@Override
	public void accessSystem() throws IOException, InvalidFileException {
		StudentInterface hallSystem = HallAdmissionSystem.getInstance();

		boolean isLoggedIn = true;
		while (isLoggedIn) {

			String menuHeading = "Hi, " + this.username + "!";

			Integer userInput = CommandLineInterface.getMenuSelection(menuHeading, getMenu());

			switch (userInput) {
				case 1:
					apply();
					break;
				case 2:
					String del = CommandLineInterface.getInp("Are you sure you want to delete your application? (y/n)");
					if (del.equals("y")) {
						hallSystem.removeApplication(this);
						System.out.println("Your Application has been deleted");
					} else {
						System.out.println("Application was not deleted");
					}
					break;
				case 3:
					hallSystem.viewStudentApplication(this);
					break;
				case 4:
					hallSystem.viewHallList();
					break;
				case 5:
					System.out.println("Logging out");
					isLoggedIn = false;
					break;
				default:
					System.out.println("The option you entered is not in the menu!");
			}
		}
	}

	private void apply() throws IOException, InvalidFileException {
		StudentInterface hallAdmissionSystem = HallAdmissionSystem.getInstance();
		int hall = ComponentsHelper.selectExistingHall();
		String examType = ComponentsHelper.getExamType();
		int lowerLimit, upperLimit;
		if (examType.equals("DSE")) {
			lowerLimit = 0;
			upperLimit = 25;
		} else {
			lowerLimit = 1;
			upperLimit = 9;
		}
		int examScore = ComponentsHelper.getCappedIntValue("Enter Exam Score: ", lowerLimit, upperLimit);
		int inHallActivities = ComponentsHelper.getIntValue("Enter the number of in-hall activities: ");
		double academicScore = ComponentsHelper.getCappedDoubleValue("Enter Academic Score (cGPA): ", 0, 4.3);
		String location = ComponentsHelper.getLocation();

		Score score = new Score(academicScore, inHallActivities, examScore, examType, location);
		hallAdmissionSystem.addApplication(this, hall, score);
	}

	private ArrayList<String> getMenu() {
		return new ArrayList<>(Arrays.asList("Apply", "Delete your application",
				"View your application", "View hall list", "Logout"));
	}

}
