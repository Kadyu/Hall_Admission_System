package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import HallAdmissionSystem.Account;
import HallAdmissionSystem.AuthenticationSystem;
import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.Main;
import HallAdmissionSystem.exceptions.AuthenticationFailException;
import HallAdmissionSystem.exceptions.InvalidFileException;
import HallAdmissionSystem.exceptions.ResourceNotFoundException;

public class CommandLineInterface_Database_Account_Authentication_Test {
	@Test
	public void testLoginStudent() throws IOException, InvalidFileException, AuthenticationFailException, ResourceNotFoundException{
		          
	      String input = "chriswong" + System.getProperty("line.separator")
	      + "pwd01" +System.getProperty("line.separator")+ "5" +System.getProperty("line.separator")+  "n" + System.getProperty("line.separator");	      
	      
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      AuthenticationSystem authenticationSystem;
	      CommandLineInterface.start();
	      authenticationSystem = AuthenticationSystem.getInstance();
          Account account = authenticationSystem.login();
          account.accessSystem();
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
	      		+ ">> Logging out\n";
	   
      
	      assertEquals(expected, outputText);    
	}
	
	@Test
	public void testLoginAdmin() throws IOException, InvalidFileException, AuthenticationFailException, ResourceNotFoundException{
		          
	      String input = "petersmith" + System.getProperty("line.separator")
	      + "superpwd01" +System.getProperty("line.separator")+ "6" +System.getProperty("line.separator")+  "n" + System.getProperty("line.separator");	      
	      
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(input.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      AuthenticationSystem authenticationSystem;
	      CommandLineInterface.start();
	      authenticationSystem = AuthenticationSystem.getInstance();
          Account account = authenticationSystem.login();
          account.accessSystem();
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
	      		+ ">> --------------------\n"
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
}
