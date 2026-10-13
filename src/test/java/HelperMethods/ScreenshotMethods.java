package HelperMethods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotMethods {

    public static void captureScreenshot(
            WebDriver driver, String fileName) {


        if (!(driver instanceof TakesScreenshot)) {
            throw new IllegalArgumentException(
                    "Browserul nu suporta capturi de ecran."
            );
        }


        Path folderPath = Paths.get("screenshots");

        try {

            Files.createDirectories(folderPath);


            File sourceFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);


            Path destinationPath =
                    folderPath.resolve(fileName + ".png");


            Files.copy(
                    sourceFile.toPath(),
                    destinationPath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot salvat: "
                            + destinationPath.toAbsolutePath()
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Nu s-a putut salva screenshot-ul.",
                    e
            );
        }
    }
}
