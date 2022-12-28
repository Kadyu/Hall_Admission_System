package HallAdmissionSystemTest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import HallAdmissionSystem.*;

public class CommandLineInterface_HallAdmissionSystem_ComponentsHelper_Test {
	
	@Test
	public void testselectExistingHall_01() throws Exception {
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.selectExistingHall();
		CommandLineInterface.close();
		assertEquals(1, res);
	}
	
	@Test
	public void testselectExistingHall_02() throws Exception {
		String input = "4\r\n1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.selectExistingHall();
		CommandLineInterface.close();
		assertEquals(1, res);
	}
	
	@Test
	public void testselectNewHall_01() throws Exception {
		String input = "4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.selectNewHall();
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testselectNewHall_02() throws Exception {
		String input = "1\r\n4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.selectNewHall();
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testselectNewHall_03() throws Exception {
		String input = "a\r\n4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.selectNewHall();
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testcheckInteger_01() throws Exception {
		boolean res = ComponentsHelper.checkInteger(null);
		assertEquals(false, res);
	}
	
	@Test
	public void testcheckInteger_02() throws Exception {
		boolean res = ComponentsHelper.checkInteger("-1");
		assertEquals(false, res);
	}
	
	@Test
	public void testgetIntValue() throws Exception {
		String input = "a\r\n4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.getIntValue("Enter: ");
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testcheckDouble_01() throws Exception {
		boolean res = ComponentsHelper.checkDouble(null);
		assertEquals(false, res);
	}
	
	@Test
	public void testcheckDouble_02() throws Exception {
		boolean res = ComponentsHelper.checkDouble("-1");
		assertEquals(false, res);
	}
	
	@Test
	public void testcheckDouble_03() throws Exception {
		boolean res = ComponentsHelper.checkDouble("3.4");
		assertEquals(true, res);
	}
	
	@Test
	public void testcheckDouble_04() throws Exception {
		boolean res = ComponentsHelper.checkDouble("a");
		assertEquals(false, res);
	}
	
	@Test
	public void testgetDoubleValue_01() throws Exception {
		String input = "3.4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		double res = ComponentsHelper.getDoubleValue("Enter: ");
		CommandLineInterface.close();
		assertEquals(3.4, res, 0.01);
	}
	
	@Test
	public void testgetDoubleValue_02() throws Exception {
		String input = "a\r\n3.4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		double res = ComponentsHelper.getDoubleValue("Enter: ");
		CommandLineInterface.close();
		assertEquals(3.4, res, 0.01);
	}
	
	@Test
	public void testgetCappedIntValue_01() throws Exception {
		String input = "4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.getCappedIntValue("Enter: ", 1, 11);
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testgetCappedIntValue_02() throws Exception {
		String input = "0\r\n4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.getCappedIntValue("Enter: ", 1, 11);
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testgetCappedIntValue_03() throws Exception {
		String input = "20\r\n4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		int res = ComponentsHelper.getCappedIntValue("Enter: ", 1, 11);
		CommandLineInterface.close();
		assertEquals(4, res);
	}
	
	@Test
	public void testgetCappedDoubleValue_01() throws Exception {
		String input = "4.0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		double res = ComponentsHelper.getCappedDoubleValue("Enter: ", 0.0, 4.3);
		CommandLineInterface.close();
		assertEquals(4, res, 0.01);
	}
	
	@Test
	public void testgetCappedDoubleValue_02() throws Exception {
		String input = "0.1\r\n4.0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		double res = ComponentsHelper.getCappedDoubleValue("Enter: ", 0.5, 4.3);
		CommandLineInterface.close();
		assertEquals(4, res, 0.01);
	}
	
	@Test
	public void testgetCappedDoubleValue_03() throws Exception {
		String input = "5.0\r\n4.0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		double res = ComponentsHelper.getCappedDoubleValue("Enter: ", 0.0, 4.3);
		CommandLineInterface.close();
		assertEquals(4, res, 0.01);
	}
	
	@Test
	public void testgetExamType() throws Exception {
		String input = "DSE";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = ComponentsHelper.getExamType();
		CommandLineInterface.close();
		assertEquals("DSE", res);
	}
	
	@Test
	public void testgetLocation() throws Exception {
		String input = "Kowloon";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		CommandLineInterface.start();
		String res = ComponentsHelper.getLocation();
		CommandLineInterface.close();
		assertEquals("Kowloon", res);
	}
	
}
