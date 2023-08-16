package unl.soc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A demonstration test file.
 * 
 * @author cbourke, Lisong
 *
 */

public class StatisticsTests {

	/**
	 * Tests that the {@link Statistics#getMin(int[])} method correctly returns the
	 * minimum element in the given array for a fixed array.
	 */
	@Test
	void getMinFixedTest01() {
		int arr[] = { 1, 2, 3 };
		int expected = 1;
		int result = Statistics.getMin(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMin(int[])} method correctly returns the
	 * minimum element in the given array for a fixed array.
	 */
	@Test
	void getMinFixedTest02() {
		int arr[] = { 6, 2, 7, 3, 8, 4, 9, 5, 10 };
		int expected = 2;
		int result = Statistics.getMin(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMin(int[])} method correctly returns the
	 * minimum element in the given array for a fixed array.
	 */
	@Test
	void getMinFixedTest03() {
		int arr[] = { -4, 3, -42, 21, 0, 3, 3, 3, 3 };
		int expected = -42;
		int result = Statistics.getMin(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMin(int[])} method correctly returns the
	 * minimum element in the given array for a fixed array.
	 */
	@Test
	void getMinFixedTest04() {
		int arr[] = { -1, -2, -3, -4, -5 };
		int expected = -5;
		int result = Statistics.getMin(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMin(int[])} method correctly returns the
	 * minimum element in the given array for a fixed array.
	 */
	@Test
	void getMinFixedTest05() {
		int arr[] = { -1, -2, 3, 2, -3, 1 };
		int expected = -3;
		int result = Statistics.getMin(arr);
		Assertions.assertEquals(expected, result);
	}

}
