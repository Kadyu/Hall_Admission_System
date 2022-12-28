package HallAdmissionSystemTest;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import HallAdmissionSystem.*;

public class Score_Test{
	
	@Test
	public void testgetScores_01() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		for(int scr : sc.getScores()) System.out.print(scr);
		String output = baos.toString();
		assertEquals("20358", output);
	}
	
	@Test
	public void testgetScores_02() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(3.5, 15, 3, "CIE", "Kowloon");
		for(int scr : sc.getScores()) System.out.print(scr);
		String output = baos.toString();
		assertEquals("150105", output);
	}
	
	@Test
	public void testgetScores_03() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(3.1, 15, 10, "IELTS", "New Territories");
		for(int scr : sc.getScores()) System.out.print(scr);
		String output = baos.toString();
		assertEquals("10301012", output);
	}
	
	@Test
	public void testgetScores_04() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(1.2, 15, 10, "IELTS", "Lantau Island");
		for(int scr : sc.getScores()) System.out.print(scr);
		String output = baos.toString();
		assertEquals("5301018", output);
	}

}
