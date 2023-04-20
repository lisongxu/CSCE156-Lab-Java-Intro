package unl.soc;

import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a batch test file used by grading scripts to generate a full roster
 * grade report.
 * 
 * This is a single, generic batch testing utility to be used for all java-based
 * labs. Invoke this class by providing a (space delimited) list of fully
 * qualified package/class JUnit test classes. Example:
 * 
 * unl.soc.StatisticsTests unl.soc.OtherTests
 * 
 * @author cbourke
 *
 */
@SuppressWarnings("unused")
public class BatchTest {

	public static final int LAB_POINTS = 20;

	private final SummaryGeneratingListener listener = new SummaryGeneratingListener();
	private final List<String> testClasses;

	public BatchTest(List<String> testClasses) {
		this.testClasses = testClasses;
	}

	public void runAll() {
		LauncherDiscoveryRequestBuilder builder = LauncherDiscoveryRequestBuilder.request();
		for (String testClass : this.testClasses) {
			builder = builder.selectors(selectClass(testClass));
		}
		LauncherDiscoveryRequest request = builder.build();
		Launcher launcher = LauncherFactory.create();
		TestPlan testPlan = launcher.discover(request);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}

	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("You must provide one or more fully qualified path/class references for testing.");
			System.exit(1);
		}

		BatchTest bt = new BatchTest(Arrays.asList(args));

		// suppress standard output while tests are run
		PrintStream original = new PrintStream(System.out);
		PrintStream nps;
		try {
			nps = new PrintStream(new FileOutputStream("/dev/null"));
			System.setOut(nps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		bt.runAll();

		// restore standard output for report
		System.setOut(original);

		TestExecutionSummary summary = bt.listener.getSummary();

		long numTests = summary.getTestsFoundCount();
		long numFail = summary.getTestsFailedCount();
		long numPass = summary.getTestsSucceededCount();

		// prints total number of points, number of pass/fail
		// and total tests in csv format
		System.out.printf("%d,%d,%d,%d", numFail == 0 ? LAB_POINTS : 0, numPass, numFail, numTests);

	}

}
