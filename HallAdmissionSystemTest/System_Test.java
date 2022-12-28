package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.Main;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class System_Test {
	@Test
	public void testSystem() throws IOException, InvalidFileException{
		          
	      String input = "chriswong" + System.getProperty("line.separator")
	      + "pwd01" + System.getProperty("line.separator")+ "4" + System.getProperty("line.separator")
	      + "5" + System.getProperty("line.separator") + "n" + System.getProperty("line.separator");	      
	      
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      
	      CommandLineInterface.start();
	      Main.main(new String[0]);
	      CommandLineInterface.close();

	      System.setIn(stdin);
	      String outputText = byteArrayOutputStream.toString();
	        
	      String expected = "---------------------\n"
	      		+ "Authentication System\n"
	      		+ "---------------------\n"
	      		+ "Please login to continue\n"
	      		+ "\n"
	      		+ "Enter username\n"
	      		+ ">> Enter password\n"
	      		+ ">> --------------\n"
	      		+ "Hi, chriswong!\n"
	      		+ "--------------\n"
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
	      		+ "--------------\n"
	      		+ "Hi, chriswong!\n"
	      		+ "--------------\n"
	      		+ "[1] Apply\n"
	      		+ "[2] Delete your application\n"
	      		+ "[3] View your application\n"
	      		+ "[4] View hall list\n"
	      		+ "[5] Logout\n"
	      		+ "Please enter the number corresponding to the desired option.\n"
	      		+ ">> Logging out\n"
	      		+ "Login as another user? (y/n)\n"
	      		+ ">> ";
      
	      assertEquals(expected, outputText);    
	}
	
	
	@Test
	public void testSystemFailedPassword() throws IOException, InvalidFileException{
		          
	      String input = "chriswong" + System.getProperty("line.separator")
	      + "pwd03" +  "n" + System.getProperty("line.separator");	      
	      
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      
	      CommandLineInterface.start();
	      Main.main(new String[0]);
	      CommandLineInterface.close();

	      System.setIn(stdin);
	      String outputText = byteArrayOutputStream.toString();
	        
	      String expected = "---------------------\n"
	      		+ "Authentication System\n"
	      		+ "---------------------\n"
	      		+ "Please login to continue\n"
	      		+ "\n"
	      		+ "Enter username\n"
	      		+ ">> Enter password\n"
	      		+ ">> ------\n"
	      		+ "ERROR!\n"
	      		+ "------\n"
	      		+ "Password not correct for user [chriswong]!\n"
	      		+ "\n";
      
	      assertEquals(expected, outputText);    
	}
	
	@Test
	public void testSystemFailedResource() throws IOException, InvalidFileException{
		          
	      String input = "testing1" + System.getProperty("line.separator")
	      + "pwd03" +  "n" + System.getProperty("line.separator");	      
	      
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      
	      CommandLineInterface.start();
	      Main.main(new String[0]);
	      CommandLineInterface.close();

	      System.setIn(stdin);
	      String outputText = byteArrayOutputStream.toString();
	        
	      String expected = "---------------------\n"
	      		+ "Authentication System\n"
	      		+ "---------------------\n"
	      		+ "Please login to continue\n"
	      		+ "\n"
	      		+ "Enter username\n"
	      		+ ">> Enter password\n"
	      		+ ">> ------\n"
	      		+ "ERROR!\n"
	      		+ "------\n"
	      		+ "Account with username [testing1] not found!\n"
	      		+ "\n";
      
	      assertEquals(expected, outputText);    
	}
	
	
	

}
