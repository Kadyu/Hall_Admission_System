package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Test;

import HallAdmissionSystem.*;

public class Hall_Test {
	@Test
	public void testgetHallRow(){
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		assertEquals("1\t100", h.getHallRow());
	}
	
	@Test
	public void testgetHallID(){
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		assertEquals(1, h.getHallID());
	}
	
	@Test
	public void testtoString() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		System.out.print(h);
		String output = baos.toString();
		assertEquals("Hall 1", output);
	}
	
	@Test
	public void testsetCapacitygetCapacity(){
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		h.setCapacity(150);
		assertEquals(150, h.getCapacity());
	}
	
	@Test
	public void testsetWeightinggetWeighting() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		Weighting w1 = new Weighting(2,5,3,8);
		h.setWeighting(w1);
		for (int i: h.getWeighting().getWeights()){
			System.out.print(i);
		}
		String output = baos.toString();
		assertEquals("2538", output);
	}
	
	@Test
	public void testgetAllApplication() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Student s = new Student(89713, "John", "pwd", false, 3);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Application a = new Application(s, 1, sc);
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 100, w);
		h.addApplication(a);
		for (Application _a: h.getAllApplication()){
			System.out.print(_a);
		}
		String output = baos.toString();
		
		String exp = "* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\nAcademic Year: 3\n" +
                "Student type: " + "Non-local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!";
		assertEquals(exp, output);
	}
}
