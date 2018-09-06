import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test methods in the Statistics class.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals(x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals(123.015, Statistics.average(y), TOL);
	}

	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals(12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for (int k = 0; k <= n / 2; k++) {
			x[k] -= 0.5 * k;
			x[n - k - 1] += 0.5 * k;
		}
		assertEquals(avg, Statistics.average(x), TOL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyArray() {
		double[] x = new double[0];
		Statistics.variance(x);
		Statistics.average(x);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSizeArray() {
		double[] x = { 1, 2, 3 };
		double[] y = new double[4];
		Statistics.covariance(x, y);
	}

	@Test
	public void testLargeArray() {
		double[] x = new double[999];
		double[] y = new double[999];
		for (int i = 0; i < x.length; i++) {
			x[i] = i * 10;
			y[i] = i * 999;

		}
		assertEquals(8.30835E8, Statistics.covariance(x, y), TOL);

	}

	@Test
	public void testVarianceWithOneElement() {
		double[] x = { 99 };
		assertEquals(0.0, Statistics.variance(x), TOL);
	}

	@Test
	public void testVariance() {
		double[] x = new double[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		assertEquals(8.25, Statistics.variance(x), TOL);
	}

	@Test
	public void testCovariance() {
		double[] x = { 1.012, 2.345, 3.684 };
		double[] y = { 4.342, 5.366, 6.128 };
		assertEquals(0.7952780, Statistics.covariance(x, y), TOL);
	}

}
