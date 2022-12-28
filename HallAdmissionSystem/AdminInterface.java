package HallAdmissionSystem;

public interface AdminInterface {
	void processStudentApplications();

	void viewHallList();

	void listAllApplication();

	void addHall(int hall, int cap, Weighting w);

	void updateHallInfo(int hall, int cap, Weighting w);
}
