import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	static final int LENGTH = 1_000_000;
	static final int DEGREE = 360;
	private Random rand = new Random();

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}
	@Test
	public void testDotProductTypicalVectors(){
		// vector of length two
		double[] x = {1,5.2}; 
		double[] y = {2.4,1};
		double expected = x[0]*y[0] + x[1]*y[1];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		double[] x = new double[LENGTH];
		double[] y = new double[LENGTH];
		double product = 0.0;
		for(int k=0; k<LENGTH; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = rand.nextDouble();
			double yk = rand.nextDouble();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	/** 
	 * This test should throw an exception,
	 * but not after you change the spec for dotProduct!
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testDotProductLengthsNotSame() {
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.5, 4};
		assertEquals( 19.5, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 19.5, ArrayMath.dotProduct(y, x), TOL);
	}

}
