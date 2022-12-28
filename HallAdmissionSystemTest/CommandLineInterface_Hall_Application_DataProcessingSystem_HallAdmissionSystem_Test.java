package HallAdmissionSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.Hall;
import HallAdmissionSystem.HallAdmissionSystem;
import HallAdmissionSystem.Score;
import HallAdmissionSystem.Student;
import HallAdmissionSystem.exceptions.InvalidFileException;


public class CommandLineInterface_Hall_Application_DataProcessingSystem_HallAdmissionSystem_Test {
	
	@Test
	public void testIsHallExist() throws IOException, InvalidFileException{
		
		HallAdmissionSystem hs = HallAdmissionSystem.getInstance();
		boolean output = hs.isHallExists(2);
		assertEquals(true, output);
		
	}
	
	
	@Test
	public void testgetHallsList() throws IOException, InvalidFileException{
		
		int[] expected = {1,2};
		int[] output = new int[2];
		
		HallAdmissionSystem hs = HallAdmissionSystem.getInstance();
		ArrayList<Hall> hsList = hs.getHallList();

		for (int i=0;i<hsList.size();i++) {
			Hall h = hsList.get(i);
			output[i] = h.getHallID();
		}
		Assert.assertArrayEquals(expected, output);	
		
	}
	
	
	@Test
	public void testListAllApplication() throws IOException, InvalidFileException{
		
		HallAdmissionSystem hs = HallAdmissionSystem.getInstance();
		
		Student st = new Student(1, "student1", "pwd01", true, 1);
		Score sc = new Score(3,5,75,"DSE","Kowloon");		
		hs.addApplication(st, 1, sc);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	    
	    hs.listAllApplication();
		
	    String output = byteArrayOutputStream.toString();
	    
	    String expected = "----------------\n"
	    		+ "Application List\n"
	    		+ "----------------\n"
	    		+ "student1	Hall 1		Total Score: 95	(In Progress)\n"
	    		+ "\n"
	    		+ "\n";
		
	    assertEquals(expected, output);
		
	}
	
	
	@Test
	public void testViewStudentApplication() throws IOException, InvalidFileException{
		
		HallAdmissionSystem hs = HallAdmissionSystem.getInstance();
		
		Student st = new Student(1, "student1", "pwd01", true, 1);
		Score sc = new Score(3,5,75,"DSE","Kowloon");		
		hs.addApplication(st, 1, sc);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	    
	    hs.viewStudentApplication(st);
		
	    String output = byteArrayOutputStream.toString();
	    
	    String expected = "-----------\n"
	    		+ "Application\n"
	    		+ "-----------\n"
	    		+ "* Application information * \n"
	    		+ "Date: " + hs.getApplication(st).getAppDate() + "\n"
	    		+ "Student ID: 1\n"
	    		+ "Academic Year: 1\n"
	    		+ "Student type: Local student\n"
	    		+ "Hall preference: 1\n"
	    		+ "Application total score is: 95\n"
	    		+ "Application state: You application is still in progress!\n"
	    		+ "\n";
		
	    assertEquals(expected, output);
		
	}

}
