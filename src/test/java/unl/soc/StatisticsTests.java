package unl.soc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticsTests {

	/**
	 * Tests that the {@link Statistics#getSum(int[])} method correctly sums the
	 * elements in the given array for a fixed array.
	 */
	@Test
	void getSumFixedTest01() {
		int arr[] = { 1, 2, 3 };
		int expected = 6;
		int result = Statistics.getSum(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getSum(int[])} method correctly sums the
	 * elements in the given array for a fixed array.
	 */
	@Test
	void getSumFixedTest02() {
		int arr[] = { 1, 6, 2, 7, 3, 8, 4, 9, 5, 10 };
		int expected = 55;
		int result = Statistics.getSum(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getSum(int[])} method correctly sums the
	 * elements in the given array for a fixed array.
	 */
	@Test
	void getSumFixedTest03() {
		int arr[] = { -4, 3, -42, 21, 0, 3, 3, 3, 3 };
		int expected = -10;
		int result = Statistics.getSum(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getSum(int[])} method correctly sums the
	 * elements in the given array for a fixed array.
	 */
	@Test
	void getSumFixedTest04() {
		int arr[] = { -1, -2, -3, -4, -5 };
		int expected = -15;
		int result = Statistics.getSum(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getSum(int[])} method correctly sums the
	 * elements in the given array for a fixed array.
	 */
	@Test
	void getSumFixedTest05() {
		int arr[] = { -1, -2, 3, 2, -3, 1 };
		int expected = 0;
		int result = Statistics.getSum(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMax(int[])} method correctly returns the
	 * maximal element in the given array for a fixed array.
	 */
	@Test
	void getMaxFixedTest01() {
		int arr[] = { 1, 2, 3 };
		int expected = 3;
		int result = Statistics.getMax(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMax(int[])} method correctly returns the
	 * maximal element in the given array for a fixed array.
	 */
	@Test
	void getMaxFixedTest02() {
		int arr[] = { 1, 6, 2, 7, 3, 8, 4, 9, 5, 10 };
		int expected = 10;
		int result = Statistics.getMax(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMax(int[])} method correctly returns the
	 * maximal element in the given array for a fixed array.
	 */
	@Test
	void getMaxFixedTest03() {
		int arr[] = { -4, 3, -42, 21, 0, 3, 3, 3, 3 };
		int expected = 21;
		int result = Statistics.getMax(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMax(int[])} method correctly returns the
	 * maximal element in the given array for a fixed array.
	 */
	@Test
	void getMaxFixedTest04() {
		int arr[] = { -1, -2, -3, -4, -5 };
		int expected = -1;
		int result = Statistics.getMax(arr);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Statistics#getMax(int[])} method correctly returns the
	 * maximal element in the given array for a fixed array.
	 */
	@Test
	void getMaxFixedTest05() {
		int arr[] = { -1, -2, 3, 2, -3, 1 };
		int expected = 3;
		int result = Statistics.getMax(arr);
		Assertions.assertEquals(expected, result);
	}

}
