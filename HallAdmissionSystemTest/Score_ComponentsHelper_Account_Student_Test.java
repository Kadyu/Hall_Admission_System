package HallAdmissionSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.Account;
import HallAdmissionSystem.Application;
import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.ComponentsHelper;
import HallAdmissionSystem.Score;
import HallAdmissionSystem.Student;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class Score_ComponentsHelper_Account_Student_Test {
	
	@Test
	public void testIsAccountStudent() throws IOException, InvalidFileException{
		Account acc = new Student(1, "student1", "pwd01", true, 1);
		String output = acc.getUsername();
		assertEquals("student1", output);
	}
	
	
	@Test
	public void testInputExpectedScores() throws IOException, InvalidFileException{
		
		String inp = "Kowloon";
		
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(inp.getBytes()));
	
		  
		CommandLineInterface.start();
		String loc = ComponentsHelper.getLocation();
		CommandLineInterface.close();

		System.setIn(stdin);  
		
		Score sc = new Score(4,5,25,"DSE",loc);
		int[] output = sc.getScores();
		int[] expected = new int[] {20,25,5,5};
		
		Assert.assertArrayEquals(expected, output);
	}
	
	
	@Test
	public void testInputLocationScore() throws IOException, InvalidFileException{
		
		
		
		Student st = new Student(1, "student1", "pwd01", true, 1);
		String inp = "Hong Kong Island";
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(inp.getBytes()));
		  
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		System.setOut(ps);
		  
		CommandLineInterface.start();
		String loc = ComponentsHelper.getLocation();
		CommandLineInterface.close();

		System.setIn(stdin);  
		
		Score sc = new Score(4,7,25,"DSE",loc);
		Application ac = new Application(st,1,sc);
		
		
		int[] output = ac.getScore().getScores();
		int[] expected = new int[] {20,25,7,8};
		
		Assert.assertArrayEquals(expected, output);
		
	
	}

}
