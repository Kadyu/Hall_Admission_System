package HallAdmissionSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.Account;
import HallAdmissionSystem.Admin;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class Account_Test {
	
	@Test
	public void testAccounType() throws IOException, InvalidFileException{
		Account acc = new Admin("admin1", "pwd01");
		String expected = "admin1";
		assertEquals(expected,acc.getUsername());
	}
	
	@Test
	public void testAccounPassword() throws IOException, InvalidFileException {
		Account acc = new Admin("admin1", "pwd01");
		boolean output = acc.validatePassword("pwd01");
		assertEquals(true, output);
	}
	
	@Test
	public void testAccounPassword2() throws IOException, InvalidFileException {
		Account acc = new Admin("admin1", "pwd01");
		boolean output = acc.validatePassword("pwd00");
		assertEquals(false, output);
	}

}
