package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import HallAdmissionSystem.Account;
import HallAdmissionSystem.Admin;
import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class Weighting_ComponentHelper_Account_Admin_Test {
	
	@Test
	public void testAddHall() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "1" + System.getProperty("line.separator") +"7" + System.getProperty("line.separator") + "5" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") + "5" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Enter Hall: \n"
	    		+ ">> Enter Acceptance Capacity: \n"
	    		+ ">> Enter Academic Weight: \n"
	    		+ ">> Enter In-hall Activities Weight: \n"
	    		+ ">> Enter Exam Weight: \n"
	    		+ ">> Enter Location Weight: \n"
	    		+ ">> New Hall Created\n"
	    		+ "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
		
	}
	
	@Test
	public void testUpdateHall() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "2" + System.getProperty("line.separator") +"7" + System.getProperty("line.separator") + "5" + System.getProperty("line.separator") +"5" + System.getProperty("line.separator") + "5" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Enter hall:\n"
	    		+ ">> Enter New Academic Weight: \n"
	    		+ ">> Enter New In-hall Activities Weight: \n"
	    		+ ">> Enter New Exam Weight: \n"
	    		+ ">> Enter New Location Weight: \n"
	    		+ ">> Enter New Acceptance Capacity: \n"
	    		+ ">> Settings Changed\n"
	    		+ "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
		
	}
	@Test
	public void testViewHall() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "3" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> ---------\n"
	    		+ "Hall List\n"
	    		+ "---------\n"
	    		+ "Hall	Capacity\n"
	    		+ "1	10\n"
	    		+ "2	8\n"
	    		+ "7	6\n"
	    		+ "\n"
	    		+ "\n"
	    		+ "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
		
	}
	@Test
	public void testListAllApplications() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "4" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> ----------------\n"
	    		+ "Application List\n"
	    		+ "----------------\n"
	    		+ "student1	Hall 1		Total Score: 95	(Success)\n"
	    		+ "willprince	Hall 1		Total Score: 40	(Success)\n"
	    		+ "\n"
	    		+ "\n"
	    		+ "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
		
	}
	@Test
	public void testProcessApplication() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "5" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Done processing\n"
	    		+ "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}

	@Test
	public void testNotInMenu() throws IOException, InvalidFileException{
		Account adminUser = new Admin("petersmith","superpwd01");;
		
		String input = "7" + System.getProperty("line.separator") +"6" + System.getProperty("line.separator") +"n" + System.getProperty("line.separator");	      
	    InputStream stdin = System.in;
	    
	    System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    System.setOut(ps);
	      
	    CommandLineInterface.start();
	    adminUser.accessSystem();
	    CommandLineInterface.close();
	    
	    
	    System.setIn(stdin);
	    String outputText = byteArrayOutputStream.toString();     
	    System.out.println(outputText);
	    String expected = "--------------------\n"
	    		+ "Welcome, petersmith!\n"
	    		+ "--------------------\n"
	    		+ "[1] Create new hall\n"
	    		+ "[2] Update information of an existing hall\n"
	    		+ "[3] View hall list\n"
	    		+ "[4] List all applications\n"
	    		+ "[5] Process applications\n"
	    		+ "[6] Logout\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Selected option is not in the menu. Please input again!\n"
	    		+ "Please enter the number corresponding to the desired option.\n"
	    		+ ">> Logging out\n";
    
	    assertEquals(expected, outputText);  
	}
}
