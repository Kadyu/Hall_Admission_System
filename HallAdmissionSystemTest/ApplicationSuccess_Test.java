package HallAdmissionSystemTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HallAdmissionSystem.ApplicationState;
import HallAdmissionSystem.ApplicationSuccess;

public class ApplicationSuccess_Test {
	@Test
	public void testApplicationSuccessIsProcessed() {
		ApplicationState appState = new ApplicationSuccess();
		boolean isProcessed = appState.isProcessed();
		assertEquals(isProcessed,true);
	}
	@Test
	public void testApplicationSuccessNotify() {
		ApplicationState appState = new ApplicationSuccess();
		String notfyMessage = appState.notifyStudent();
		assertEquals(notfyMessage,"Congratulations! Your application is successful!");
	}
	@Test
	public void testApplicationSuccessGetState() {
		ApplicationState appState = new ApplicationSuccess();
		String stateApplication = appState.getStateString();
		assertEquals(stateApplication,"Success");
	}
}
