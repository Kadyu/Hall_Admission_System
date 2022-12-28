package HallAdmissionSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.CommandLineInterface;
import HallAdmissionSystem.ComponentsHelper;
import HallAdmissionSystem.exceptions.InvalidFileException;

public class CommandLineInterface_HallAdmissionSystem_ComponentsHeler_Test {
	
	@Test
	public void testSelectExistingHall() throws IOException, InvalidFileException{
		
		
		String inp = "1";
		
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream(inp.getBytes()));
	      
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      System.setOut(ps);
	      
	      CommandLineInterface.start();
	      int output = ComponentsHelper.selectExistingHall();
	      CommandLineInterface.close();

	      System.setIn(stdin);    
	      assertEquals(1, output);
		
	}

}
