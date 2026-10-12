
package Tests_Refactorizat;

import Logger.LoggerUtility;
import org.testng.annotations.Test;

public class LoggerTest {

    @Test
    public void mergeLogsTest() {

        LoggerUtility.startTestCase("mergeLogsTest");

        try {
            LoggerUtility.mergeFiles();
        } finally {
            LoggerUtility.endTestCase("mergeLogsTest");
        }
    }
}
