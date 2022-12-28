package HallAdmissionSystemTest;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import HallAdmissionSystem.*;

public class Weighting_Hall_ScoreCalculator_Test {
	
	@Test
	public void testcalculateScore() throws Exception{
		Score sc = new Score(4, 5, 3, "DSE", "Hong Kong Island");
		Student s = new Student(89713, "John", "pwd", false, 3);
		Application a = new Application(s, 1 , sc);
		ScoreCalculator scCalc = new ScoreCalculator(a);
		assertEquals(36, scCalc.calculateScore());
	}
	
}
