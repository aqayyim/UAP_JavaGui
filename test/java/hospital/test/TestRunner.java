import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PatientTest.class, DoctorTest.class);

        System.out.println("\n=== Test Results ===");
        if (result.wasSuccessful()) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Failed Tests:");
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }

        System.out.println("\nTest Summary:");
        System.out.println("Total tests: " + result.getRunCount());
        System.out.println("Failed: " + result.getFailureCount());
        System.out.println("Time: " + result.getRunTime() + "ms");
    }
}