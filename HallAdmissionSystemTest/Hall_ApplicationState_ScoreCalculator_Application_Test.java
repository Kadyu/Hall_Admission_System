package HallAdmissionSystemTest;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import org.junit.Test;
import HallAdmissionSystem.*;

public class Hall_ApplicationState_ScoreCalculator_Application_Test {
	
	@Test
	public void testApplication_01() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		System.out.print(a);
		String output = baos.toString();
		String exp = "* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Non-local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!";
		assertEquals(exp, output);
	}
	
	@Test
	public void testApplication_02() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		System.out.print(a);
		String output = baos.toString();
		String exp = "* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!";
		assertEquals(exp, output);
	}
	
	@Test
	public void testcompareto_01() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(3.9, 12, 5, "IELTS", "Kowloon");
		Student s1 = new Student(89903, "Smith", "pwd1", false, 2);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(1, a.compareTo(a1));
	}
	
	@Test
	public void testcompareto_02() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(3.9, 12, 5, "IELTS", "Kowloon");
		Student s1 = new Student(89903, "Smith", "pwd1", false, 2);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(-1, a1.compareTo(a));
	}
	
	@Test
	public void testcompareto_03() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s1 = new Student(89903, "Smith", "pwd1", false, 2);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(0, a1.compareTo(a));
	}
	
	@Test
	public void testequals_01() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		assertEquals(true, a.equals(a));
	}
	
	@Test
	public void testequals_02() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Application a1 = null;
		assertEquals(false, a.equals(a1));
	}
	
	@Test
	public void testequals_03() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		assertEquals(false, a.equals(s));
	}
	
	@Test
	public void testequals_04() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(3.9, 12, 5, "IELTS", "Kowloon");
		Student s1 = new Student(89903, "Smith", "pwd1", false, 2);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(false, a.equals(a1));
	}
	
	@Test
	public void testequals_05() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(3.9, 12, 5, "IELTS", "Kowloon");
		Student s1 = new Student(89713, "Smith", "pwd1", false, 2);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(true, a.equals(a1));
	}
	
	@Test
	public void testequals_06() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(3.9, 12, 5, "IELTS", "Kowloon");
		Student s1 = new Student(89713, "Smith", "pwd1", false, 2);
		Thread.sleep(10);
		Application a1 = new Application(s1, 1 , sc1);
		assertEquals(false, a.equals(a1));
	}
	
	@Test
	public void testgetApplicationStateRow() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		String res = "John" + "\t" + "Hall 1" + "\t\tTotal Score: " + "36" + "\t("
                + "In Progress" + ")";
		assertEquals(res, a.getApplicationStateRow());
	}
	
	@Test
	public void testisProcessed() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		assertEquals(false, a.isProcessed());
	}
	
	@Test
	public void testgetState() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		ApplicationState as = new ApplicationSuccess();
		a.setState(as);
		assertEquals(as, a.getState());
	}
	
}
