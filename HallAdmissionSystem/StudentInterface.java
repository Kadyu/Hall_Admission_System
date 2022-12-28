package HallAdmissionSystem;

import java.io.IOException;

import HallAdmissionSystem.exceptions.InvalidFileException;

public interface StudentInterface {
	void addApplication(Student s, int hall, Score sc) throws IOException, InvalidFileException;

	void removeApplication(Student s);

	void viewStudentApplication(Student s);

	void viewHallList();

	Hall getHall(int hall);
}
