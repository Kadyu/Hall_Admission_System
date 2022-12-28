package HallAdmissionSystemTest;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.util.Map.Entry;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import HallAdmissionSystem.*;

public class ApplicationFailSuccess_ApplicationQueue_DataProcessingSystem_Test {
	
	@Test
	public void testDataProcessingSystem() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		
		ArrayList<Application> up = dps.getunprocessedApplications();
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		HashMap<Hall, ArrayList<Application>> am = dps.getadmittedMap();
		
		System.out.print(up);
		HashMap<Hall, ApplicationQueue> exp = new HashMap<>();
		HashMap<Hall, ArrayList<Application>> exp1 = new HashMap<>();
		String output = baos.toString();
		
		String res = "[* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!]";
		assertEquals(res, output);
		assertEquals(exp, qm);
		assertEquals(exp1, am);
	}
	
	@Test
	public void testinitializeLists_01() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 2, w);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		
		ArrayList<Application> up = dps.getunprocessedApplications();
		System.out.println(up);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.print(hExp);
			System.out.print(getString(arr));
		}
		
		String output = baos.toString();
		HashMap<Hall, ArrayList<Application>> am = dps.getadmittedMap();
		
		HashMap<Hall, ArrayList<Application>> exp1 = new HashMap<>();
		exp1.put(h, new ArrayList<>());
		
		String res = "[* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!]\n"
                		+ "Hall 1";
		assertEquals(res, output);
		assertEquals(exp1, am);
	}
	
	@Test
	public void testinitializeLists_02() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 2, w);
		Hall h1 = new Hall(2, 1, w);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		halls.add(h1);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		
		ArrayList<Application> up = dps.getunprocessedApplications();
		System.out.println(up);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.print(hExp);
			System.out.println(getString(arr));
		}
		
		HashMap<Hall, ArrayList<Application>> am = dps.getadmittedMap();
		
		HashMap<Hall, ArrayList<Application>> exp1 = new HashMap<>();
		exp1.put(h, new ArrayList<>());
		exp1.put(h1, new ArrayList<>());
		String output = baos.toString();
		
		String res = "[* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!]\n"
                		+ "Hall 2\nHall 1\n";
		assertEquals(res, output);
		assertEquals(exp1, am);
	}
	
	@Test
	public void testloadApplicationQueues_01() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		dps.loadApplicationQueues();
		
		ArrayList<Application> up = dps.getunprocessedApplications();		
		System.out.print(up);
		String output = baos.toString();
		
		String res = "[]";
		assertEquals(res, output);
	}
	
	@Test
	public void testloadApplicationQueues_02() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		a.setState(new ApplicationSuccess());
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 2, w);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		dps.loadApplicationQueues();
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.print(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1";
		assertEquals(res, output);
	}
	
	@Test
	public void testloadApplicationQueues_03() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		a.setState(new ApplicationSuccess());
		Score sc1 = new Score(2, 9, 2, "DSE", "Hong Kong Island");
		Student s1 = new Student(87743, "Smith", "pwd1", true, 2);
		Application a1 = new Application(s1, 1, sc1);
		a1.setState(new ApplicationSuccess());
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		apps.add(a1);
		
		Weighting w = new Weighting(1,2,3,4);
		Hall h = new Hall(1, 2, w);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		dps.loadApplicationQueues();
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.print(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1";
		assertEquals(res, output);
	}
	
	@Test
	public void testloadApplicationQueues_04() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.initializeLists(apps, halls);
		dps.loadApplicationQueues();
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\n"
				+ "* Application information * " + "\n" +
                "Date: " + new Date() + "\n" +
                "Student ID: " + "89713" + "\n" +
                "Academic Year: 3" + "\n" +
                "Student type: " + "Local student" + "\n" +
                "Hall preference: " + "1" + "\n" +
                "Application total score is: " + "36" + "\n" +
                "Application state: " + "You application is still in progress!\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_01() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		ArrayList<Application> up = dps.getunprocessedApplications();		
		System.out.print(up);
		String output = baos.toString();
		
		String res = "[]";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_02() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		
		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_03() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		
		Hall h = Database.getInstance().getHall(1);
		Hall h1 = Database.getInstance().getHall(2);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		halls.add(h1);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\nHall 2\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_04() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_05() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		
		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_06() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		Score sc1 = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s1 = new Student(89713, "John", "pwd", false, 3);
		Application a1 = new Application(s1, 1 , sc1);
		Score sc2 = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s2 = new Student(89713, "John", "pwd", true, 3);
		Application a2 = new Application(s2, 1 , sc2);
		Score sc3 = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s3 = new Student(89713, "John", "pwd", true, 3);
		Application a3 = new Application(s3, 1 , sc3);
		
		ArrayList<Application> apps = new ArrayList<Application>();
		apps.add(a);
		apps.add(a1);
		apps.add(a2);
		apps.add(a3);
		
		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		HashMap<Hall, ApplicationQueue> qm = dps.getqueueMap();
		for (Entry<Hall, ApplicationQueue> entry : qm.entrySet()) {
			Hall hExp = entry.getKey();
			ApplicationQueue arr = entry.getValue();
			System.out.println(hExp);
			System.out.print(getString(arr));
		}
		String output = baos.toString();
		
		String res = "Hall 1\n";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_07() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();

		Hall h = Database.getInstance().getHall(1);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		
		for (int i = 0; i <= h.getCapacity(); i++) {apps.add(a);}
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		PriorityQueue<Application> pa = dps.getpendingApplications();
		System.out.print(pa);
		String output = baos.toString();
		
		String res = "[]";
		assertEquals(res, output);
	}
	
	@Test
	public void teststartProcessingApplications_08() throws Exception{	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		
		ArrayList<Application> apps = new ArrayList<Application>();

		Hall h = Database.getInstance().getHall(1);
		Hall h1 = Database.getInstance().getHall(2);
		
		ArrayList<Hall> halls = new ArrayList<Hall>();
		halls.add(h);
		halls.add(h1);
		
		for (int i = 0; i <= h.getCapacity(); i++) {apps.add(a);}
		
		DataProcessingSystem dps = new DataProcessingSystem(apps);
		dps.startProcessingApplications(apps, halls);
		
		PriorityQueue<Application> pa = dps.getpendingApplications();
		System.out.print(pa);
		String output = baos.toString();
		
		String res = "[]";
		assertEquals(res, output);
	}
	
	
	//Helper Function
		
		private String getString(ApplicationQueue q) {
			String result = "";
			Application application;
			while ((application = q.getTopNonLocal()) != null) {
				result += application.toString() + "\n";
			}
			while ((application = q.getTopLocal()) != null) {
				result += application.toString() + "\n";
			}
			return result;
		}
}
