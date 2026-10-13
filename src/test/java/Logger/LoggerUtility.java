package Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerUtility {

    private static final String suiteLogsPath = "target/logs/suite/";
    private static final String regressionLogsPath = "target/logs/";

    private static final Logger logger =
            LogManager.getLogger(LoggerUtility.class);


    public static synchronized void startTestCase(String testName) {
        ThreadContext.put("threadName", testName);
        logger.info("===== Execution started: {} =====", testName);
    }


    public static synchronized void endTestCase(String testName) {
        logger.info("===== Execution ended: {} =====", testName);
        ThreadContext.clearMap();
    }


    public static synchronized void infoTestCase(String messageName) {
        logger.info("{} {} {}", Thread.currentThread().getName(),
                getCallInfo(), messageName);
    }


    public static synchronized void errorLog(String message) {
        logger.error("{} {} {}", Thread.currentThread().getName(),
                getCallInfo(), message);
    }


    public static synchronized String getCallInfo() {
        StackTraceElement[] stackTrace =
                Thread.currentThread().getStackTrace();

        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();

            if (!className.equals(LoggerUtility.class.getName())
                    && !className.equals(Thread.class.getName())) {

                return className + " : "
                        + element.getMethodName() + " =>";
            }
        }

        return "Unknown class : Unknown method =>";
    }


    public static void mergeFiles() {
        File dir = new File(suiteLogsPath);

        if (!dir.exists() || !dir.isDirectory()) {
            logger.warn("Folderul de loguri nu exista: {}",
                    dir.getPath());
            return;
        }

        File[] files = dir.listFiles(
                (directory, name) -> name.endsWith(".log"));

        if (files == null || files.length == 0) {
            logger.warn("Nu exista fisiere log de unit.");
            return;
        }

        File outputFile = new File(
                regressionLogsPath, "RegressionLogs.log");

        try {
            File parent = outputFile.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (PrintWriter writer = new PrintWriter(outputFile)) {

                for (File file : files) {
                    writer.println(
                            "===== " + file.getName() + " =====");

                    try (BufferedReader reader =
                                 new BufferedReader(
                                         new FileReader(file))) {

                        String line;

                        while ((line = reader.readLine()) != null) {
                            writer.println(line);
                        }
                    }

                    writer.println();
                }
            }

            logger.info("Logurile au fost unite in: {}",
                    outputFile.getPath());

        } catch (IOException exception) {
            logger.error(
                    "Eroare la unirea fisierelor log.",
                    exception);
        }
    }
}

