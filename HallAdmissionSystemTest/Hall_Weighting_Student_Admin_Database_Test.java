package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.Test;

import HallAdmissionSystem.Account;
import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.HallAdmissionSystem;
import HallAdmissionSystem.Student;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class Hall_Weighting_Student_Admin_Database_Test {
	@Test
	public void testApplyDSE() throws IOException, InvalidFileException{
		Account studentUser = new Student(40112202,"willprince","pwd02",true,2);;
		
		String input = "1" + System.getProperty("line.separator") +"1" + System.getProperty("line.separator") +"DSE" + System.getProperty("line.separator") +"20" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"3" + System.getProperty("line.separator") +"Kowloon" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	
	    String expected = "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Enter hall:\n"
	    		+ ">> Enter Exam Type: [DSE/IELTS]\n"
	    		+ ">> Enter Exam Score: \n"
	    		+ ">> Enter the number of in-hall activities: \n"
	    		+ ">> Enter Academic Score (cGPA): \n"
	    		+ ">> Input location: [Kowloon/Hong Kong Island/New Territories/Overseas]\n"
	    		+ ">> Application Created\n"
	    		+ "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
	@Test
	public void testApplyIELTS() throws IOException, InvalidFileException{
		Account studentUser = new Student(40112202,"chriswong","pwd01",true,2);;
		
		String input = "1" + System.getProperty("line.separator") +"1" + System.getProperty("line.separator") +"IELTS" + System.getProperty("line.separator") +"9" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"3" + System.getProperty("line.separator") +"Kowloon" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------\n"
	    		+ "Hi, chriswong!\n"
	    		+ "--------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Enter hall:\n"
	    		+ ">> Enter Exam Type: [DSE/IELTS]\n"
	    		+ ">> Enter Exam Score: \n"
	    		+ ">> Enter the number of in-hall activities: \n"
	    		+ ">> Enter Academic Score (cGPA): \n"
	    		+ ">> Input location: [Kowloon/Hong Kong Island/New Territories/Overseas]\n"
	    		+ ">> Application Created\n"
	    		+ "--------------\n"
	    		+ "Hi, chriswong!\n"
	    		+ "--------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
	@Test
	public void testDelete() throws IOException, InvalidFileException{
		Account studentUser = new Student(40112202,"willprince","pwd02",true,2);;
		
		String input = "2" + System.getProperty("line.separator") +"y" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Are you sure you want to delete your application? (y/n)\n"
	    		+ ">> Your Application has been deleted\n"
	    		+ "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
	@Test
	public void testDeleteNo() throws IOException, InvalidFileException{
		Account studentUser = new Student(40112202,"willprince","pwd02",true,2);;
		
		String input = "2" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Are you sure you want to delete your application? (y/n)\n"
	    		+ ">> Application was not deleted\n"
	    		+ "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
	@Test
	public void testViewApplication() throws IOException, InvalidFileException{
		Student studentUser = new Student(40112202,"willprince","pwd02",true,2);
		HallAdmissionSystem hs = HallAdmissionSystem.getInstance();
		
		
		String input = "3" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in; 
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    System.setIn(stdin);
	    String appDate = hs.getApplication(studentUser).getAppDate().toString();
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> -----------\n"
	    		+ "Application\n"
	    		+ "-----------\n"
	    		+ "* Application information * \n"
	    		+ "Date: "+ appDate + "\n"
	    		+ "Student ID: 40112202\n"
	    		+ "Academic Year: 2\n"
	    		+ "Student type: Local student\n"
	    		+ "Hall preference: 1\n"
	    		+ "Application total score is: 40\n"
	    		+ "Application state: You application is still in progress!\n"
	    		+ "\n"
	    		+ "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
	@Test
	public void testViewHallList() throws IOException, InvalidFileException{
		Account studentUser = new Student(40112202,"willprince","pwd02",true,2);;
		
		String input = "4" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    studentUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> ---------\n"
	    		+ "Hall List\n"
	    		+ "---------\n"
	    		+ "Hall	Capacity\n"
	    		+ "1	10\n"
	    		+ "2	8\n"
	    		+ "\n"
	    		+ "\n"
	    		+ "---------------\n"
	    		+ "Hi, willprince!\n"
	    		+ "---------------\n"
	    		+ "[1] Apply\n"
	    		+ "[2] Delete your application\n"
	    		+ "[3] View your application\n"
	    		+ "[4] View hall list\n"
	    		+ "[5] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
}
