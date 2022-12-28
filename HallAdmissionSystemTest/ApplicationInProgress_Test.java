package HallAdmissionSystemTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.ApplicationInProgress;
import HallAdmissionSystem.ApplicationState;

public class ApplicationInProgress_Test {
	
	@Test
	public void testApplicationInPogressNotify(){
		ApplicationState state = new ApplicationInProgress();
		String expected = "You application is still in progress!";
		String output = state.notifyStudent();
		assertEquals(expected, output);
	}
	
	@Test
	public void testApplicationInPogressGetString(){
		ApplicationState state = new ApplicationInProgress();
		String expected = "In Progress";
		String output = state.getStateString();
		assertEquals(expected, output);
	}
	
	@Test
	public void testApplicationInProgressIsProcessed(){
		ApplicationState state = new ApplicationInProgress();
		boolean output = state.isProcessed();
		assertEquals(false, output);
	}

}
