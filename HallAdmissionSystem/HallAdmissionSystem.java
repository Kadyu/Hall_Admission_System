package HallAdmissionSystem;

import java.io.IOException;
import java.util.ArrayList;

import HallAdmissionSystem.exceptions.InvalidFileException;

public class HallAdmissionSystem implements StudentInterface, AdminInterface {
	private static ArrayList<Application> applications;
	private static ArrayList<Hall> halls;

	private static HallAdmissionSystem instance = null;
	private DataProcessingSystem dataProcessingSystem = null;

	private HallAdmissionSystem() throws IOException, InvalidFileException {
		applications = new ArrayList<>();
		halls = Database.getInstance().getAllHalls();
	}

	public static HallAdmissionSystem getInstance() throws IOException, InvalidFileException {
		if (instance == null) {
			instance = new HallAdmissionSystem();
		}
		return instance;
	}

	@Override
	public void processStudentApplications() {
		this.dataProcessingSystem = new DataProcessingSystem(applications);
		dataProcessingSystem.startProcessingApplications(applications, halls);
	}

	public void addApplication(Student s, int hall, Score sc) throws IOException, InvalidFileException {
		for (Application application : applications) {
			if (application.getSid() == s.getSid()) {
				System.out.println("Application already exists!");
				return;
			}
		}
		applications.add(new Application(s, hall, sc));
		System.out.println("Application Created");
	}

	public void listAllApplication() {
		String out = "";
		for (Application application : applications) {
			out += application.getApplicationStateRow() + "\n";
		}

		CommandLineInterface.printHC("Application List", out);
	}

	public void viewHallList() {
		String out = "Hall\tCapacity\n";
		for (Hall h : halls) {
			out += h.getHallRow() + "\n";
		}

		CommandLineInterface.printHC("Hall List", out);
	}

	public Hall getHall(int hall) {
		for (Hall h : halls) {
			if (h.getHallID() == hall) {
				return h;
			}
		}
		return null;
	}

	public boolean isHallExists(int hall) {
		for (Hall h : halls) {
			if (hall == h.getHallID()) {
				return true;
			}
		}
		return false;
	}

	public Application getApplication(Student s) {
		for (Application a : applications) {
			if (a.getSid() == s.getSid()) {
				return a;
			}
		}
		return null;
	}

	public ArrayList<Hall> getHallList() {
		return halls;
	}

	public void updateHallInfo(int hall, int cap, Weighting w) {
		Hall h = getHall(hall);
		h.setCapacity(cap);
		h.setWeighting(w);
	}

	public void addHall(int hall, int cap, Weighting w) {
		halls.add(new Hall(hall, cap, w));
	}

	public void viewStudentApplication(Student s) {
		Application a = getApplication(s);
		if (a != null) {
			CommandLineInterface.printHC("Application", getApplication(s).toString());
		} else {
			System.out.println("Student has not applied yet!");
		}

	}

	public void removeApplication(Student s) {
		Application a = getApplication(s);
		HallAdmissionSystem.applications.remove(a);
	}

}
