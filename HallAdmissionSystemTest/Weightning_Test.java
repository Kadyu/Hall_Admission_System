package HallAdmissionSystemTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import HallAdmissionSystem.Weighting;

public class Weightning_Test {
	
	@Test
	public void testGetWeights(){
		Weighting w = new Weighting(10, 10, 10, 5);
		int expected[]  = new int[]{10,10,10,5};
		int output[] = w.getWeights();
		Assert.assertArrayEquals(expected, output);
	}

}
