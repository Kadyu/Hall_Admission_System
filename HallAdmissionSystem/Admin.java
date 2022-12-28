package HallAdmissionSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import HallAdmissionSystem.exceptions.InvalidFileException;

public class Admin extends Account {

	public Admin(String username, String password) throws IOException, InvalidFileException {
		super(username, password);
	}

	@Override
	public void accessSystem() throws IOException, InvalidFileException {
		AdminInterface hallAdmissionSystem = HallAdmissionSystem.getInstance();
		boolean isLoggedIn = true;

		while (isLoggedIn) {
			String menuHeading = "Welcome, " + this.username + "!";

			Integer userInput = CommandLineInterface.getMenuSelection(menuHeading, getMenu());
			switch (userInput) {
				case 1:
					createNewHall();
					break;
				case 2:
					updateExistingHall();
					break;
				case 3:
					hallAdmissionSystem.viewHallList();
					break;
				case 4:
					hallAdmissionSystem.listAllApplication();
					break;
				case 5:
					hallAdmissionSystem.processStudentApplications();
					System.out.println("Done processing");
					break;
				case 6:
					isLoggedIn = false;
					System.out.println("Logging out");
					break;
				default:
					System.out.println("The option you entered is not in the menu!");
			}
		}

	}

	private void createNewHall() throws IOException, InvalidFileException {
		AdminInterface hallAdmissionSystem = HallAdmissionSystem.getInstance();
		int hall = ComponentsHelper.selectNewHall();
		int acceptanceCap = ComponentsHelper.getIntValue("Enter Acceptance Capacity: ");
		int academicW = ComponentsHelper.getIntValue("Enter Academic Weight: ");
		int inHallActivitiesW = ComponentsHelper.getIntValue("Enter In-hall Activities Weight: ");
		int examW = ComponentsHelper.getIntValue("Enter Exam Weight: ");
		int locationW = ComponentsHelper.getIntValue("Enter Location Weight: ");
		Weighting w = new Weighting(academicW, examW, inHallActivitiesW, locationW);
		hallAdmissionSystem.addHall(hall, acceptanceCap, w);
		System.out.println("New Hall Created");
	}

	private void updateExistingHall() throws IOException, InvalidFileException {
		AdminInterface hallAdmissionSystem = HallAdmissionSystem.getInstance();
		int hall = ComponentsHelper.selectExistingHall();
		int academicW = ComponentsHelper.getIntValue("Enter New Academic Weight: ");
		int inHallActivitiesW = ComponentsHelper.getIntValue("Enter New In-hall Activities Weight: ");
		int examW = ComponentsHelper.getIntValue("Enter New Exam Weight: ");
		int locationW = ComponentsHelper.getIntValue("Enter New Location Weight: ");
		int acceptanceCap = ComponentsHelper.getIntValue("Enter New Acceptance Capacity: ");
		Weighting w = new Weighting(academicW, examW, inHallActivitiesW, locationW);
		hallAdmissionSystem.updateHallInfo(hall, acceptanceCap, w);
		System.out.println("Settings Changed");
	}

	private ArrayList<String> getMenu() {
		return new ArrayList<>(Arrays.asList("Create new hall", "Update information of an existing hall",
				"View hall list", "List all applications", "Process applications", "Logout"));
	}
}
