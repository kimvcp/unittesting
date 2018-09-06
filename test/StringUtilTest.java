import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 * 
 * @author Ingkharat Jangchud
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}
	
	@Test
	public void testEmptyArray() {
		String[] fruit = {};
		assertEquals(-1, StringUtil.indexOf("Apple", fruit));
	}
	@Test
	public void testElementnotFound() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(-1, StringUtil.indexOf("Mango", fruit));
	}
	@Test
	public void testMorethanOne() {
		String[] fruit = {"Apple", "Banana", "Grapes" , "Apple"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}
	
	

}
