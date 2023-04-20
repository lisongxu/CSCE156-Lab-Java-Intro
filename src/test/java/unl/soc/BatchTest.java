package unl.cse;

import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a batch test file used by grading scripts to generate a full roster
 * grade report.
 * 
 * @author cbourke
 *
 */
public class BatchTest {
	
	public static final int LAB_POINTS = 20;

	SummaryGeneratingListener listener = new SummaryGeneratingListener();
	
	public void runAll(List<String> testClasses) {
		LauncherDiscoveryRequestBuilder builder = LauncherDiscoveryRequestBuilder.request();	
		for(String testClass : testClasses) {
			builder = builder.selectors(selectClass(testClass));
		}
		LauncherDiscoveryRequest request = builder.build();
		Launcher launcher = LauncherFactory.create();
		TestPlan testPlan = launcher.discover(request);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}

	public void runAll() {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass("unl.cse.StatisticsTests"))
				.build();
		Launcher launcher = LauncherFactory.create();
		TestPlan testPlan = launcher.discover(request);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}

	public static void main(String[] args) {

		BatchTest bt = new BatchTest();
		
		if(args.length > 0) {
			List<String> testClasses = new ArrayList<>(Arrays.asList(args));
			bt.runAll(testClasses);			
		} else {
			bt.runAll();			
		}

		TestExecutionSummary summary = bt.listener.getSummary();
		// summary.printTo(new PrintWriter(System.out));

		long numTests = summary.getTestsFoundCount();
		long numFail = summary.getTestsFailedCount();
		long numPass = summary.getTestsSucceededCount();

		// prints total number of points, number of pass/fail
		// and total tests in csv format
		System.out.printf("%d,%d,%d,%d", 
				        numFail == 0 ? LAB_POINTS : 0, 
						numPass, 
						numFail, 
						numTests);

	}

}

