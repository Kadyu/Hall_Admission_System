package HallAdmissionSystemTest;
import static org.junit.Assert.*;

import org.junit.Test;

import HallAdmissionSystem.ApplicationFail;
import HallAdmissionSystem.ApplicationState;

public class ApplicationFail_Test {
	@Test
	public void testApplicationFailIsProcessed() {
		ApplicationState appState = new ApplicationFail();
		boolean isProcessed = appState.isProcessed();
		assertEquals(isProcessed,true);
	}
	@Test
	public void testApplicationFailNotify() {
		ApplicationState appState = new ApplicationFail();
		String notfyMessage = appState.notifyStudent();
		assertEquals(notfyMessage,"Unfortunately, your application is unsuccessful");
	}
	@Test
	public void testApplicationFailGetString() {
		ApplicationState appState = new ApplicationFail();
		String stateApplication = appState.getStateString();
		assertEquals(stateApplication,"Failed");
	}
}
