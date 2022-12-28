package HallAdmissionSystemTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import HallAdmissionSystem.*;

public class Application_ApplicationQueue_Test {
	
	@Test
	public void testgetTopLocal() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", true, 3);
		Application a = new Application(s, 1 , sc);
		ApplicationQueue aq = new ApplicationQueue();
		aq.addApplication(a);
		assertEquals(a, aq.getTopLocal());
	}
		
	@Test
	public void testgetTopNonLocal() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		ApplicationQueue aq = new ApplicationQueue();
		aq.addApplication(a);
		assertEquals(a, aq.getTopNonLocal());
	}
}

