package HallAdmissionSystemTest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.InputStream;
import org.junit.*;
import HallAdmissionSystem.CommandLineInterface;


public class CommandLineInterface_Test {
	
	@Test
	public void testprintHeading_01() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		CommandLineInterface.printHeading("This is a Heading");
		String output = baos.toString();
		assertEquals("-----------------\nThis is a Heading\n-----------------\n", output);
	}
	
	@Test
	public void testprintHeading_02() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		CommandLineInterface.printHeading("H");
		String output = baos.toString();
		assertEquals("-\nH\n-\n", output);
	}
	
	@Test
	public void testprintHeading_03() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		CommandLineInterface.printHeading("");
		String output = baos.toString();
		assertEquals("\n\n\n", output);
	}
	
	@Test
	public void testgetInp() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		String input = "Testing...";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = CommandLineInterface.getInp("Enter: ");
		CommandLineInterface.close();
		String output = baos.toString();
		assertEquals("Enter: \n>> ", output);
	    assertEquals("Testing...", res);
	}
	
	@Test
	public void testprintHC() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		CommandLineInterface.printHC("Heading", "This is Content");
		String output = baos.toString();
		assertEquals("-------\nHeading\n-------\nThis is Content\n\n", output);
	}
	
	@Test
	public void testgetMenuSelection_01() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = CommandLineInterface.getMenuSelection("Heading", opt);
		CommandLineInterface.close();
		String output = baos.toString();
		String resString = "-------\nHeading\n"
				+ "-------\n[1] Option 1\n"
				+ "Please enter the number corresponding to the desired option.\n>> ";
		assertEquals(resString, output);
		assertEquals(1, res);
	}
	
	@Test
	public void testgetMenuSelection_02() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		opt.add("Option 2");
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = CommandLineInterface.getMenuSelection("Heading", opt);
		CommandLineInterface.close();
		String output = baos.toString();
		String resString = "-------\nHeading\n"
				+ "-------\n[1] Option 1\n"
				+ "[2] Option 2\n"
				+ "Please enter the number corresponding to the desired option.\n>> ";
		assertEquals(resString, output);
		assertEquals(1, res);
	}
	
	
	
	@Test
	public void testgetMenuSelection_03() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		String input = "0\n1";
		InputStream sis = System.in;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		CommandLineInterface.start();
		int res = CommandLineInterface.getMenuSelection("Heading", opt);
		CommandLineInterface.close();
		System.setIn(sis);
		String output = baos.toString();
		String resString = "-------\nHeading\n"
				+ "-------\n[1] Option 1\n"
				+ "Please enter the number corresponding to the desired option.\n>> "
				+ "Selected option is not in the menu. Please input again!\n"
				+ "Please enter the number corresponding to the desired option.\n>> ";
		assertEquals(resString, output);
		assertEquals(1, res);
	}
	
	@Test
	public void testgetMenuSelection_04() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		String input = "4\n1";
		InputStream sis = System.in;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		CommandLineInterface.start();
		int res = CommandLineInterface.getMenuSelection("Heading", opt);
		CommandLineInterface.close();
		System.setIn(sis);
		String output = baos.toString();
		String resString = "-------\nHeading\n"
				+ "-------\n[1] Option 1\n"
				+ "Please enter the number corresponding to the desired option.\n>> "
				+ "Selected option is not in the menu. Please input again!\n"
				+ "Please enter the number corresponding to the desired option.\n>> ";
		assertEquals(resString, output);
		assertEquals(1, res);
	}
	
	
	@Test
	public void testgetEnumerateSelection_01() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		String input = "Option 1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = CommandLineInterface.getEnumerateSelection("Choices:", opt);
		CommandLineInterface.close();
		String output = baos.toString();
		String resString = "Choices: [Option 1]\n>> ";
		assertEquals(resString, output);
		assertEquals("Option 1", res);
	}
	
	@Test
	public void testgetEnumerateSelection_02() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		opt.add("Option 2");
		String input = "Option 1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = CommandLineInterface.getEnumerateSelection("Choices:", opt);
		CommandLineInterface.close();
		String output = baos.toString();
		String resString = "Choices: [Option 1/Option 2]\n>> ";
		assertEquals(resString, output);
		assertEquals("Option 1", res);
	}
	
	@Test
	public void testgetEnumerateSelection_03() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		opt.add("Option 1");
		opt.add("Option 2");
		String input = "Option 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = CommandLineInterface.getEnumerateSelection("Choices:", opt);
		CommandLineInterface.close();
		String output = baos.toString();
		String resString = "Choices: [Option 1/Option 2]\n>> ";
		assertEquals(resString, output);
		assertEquals("Option 2", res);
	}
	
	@Test
	public void testgetEnumerateSelection_04() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		ArrayList<String> opt = new ArrayList<String>();
		String input = "Option 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		try {
			String res = CommandLineInterface.getEnumerateSelection("Choices:", opt);
		}
		catch (Exception e) {}
		String output = baos.toString();
		CommandLineInterface.close();
		String resString = "Choices: []\n>> Selected option does not exist. Please input again!\nChoices: []\n>> ";
		assertEquals(resString, output);
	}
	
	
}
