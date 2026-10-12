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

        // Verificam daca browserul permite capturi de ecran.
        if (!(driver instanceof TakesScreenshot)) {
            throw new IllegalArgumentException(
                    "Browserul nu suporta capturi de ecran."
            );
        }

        // Folderul in care salvam imaginile.
        Path folderPath = Paths.get("screenshots");

        try {
            // Cream folderul daca nu exista.
            Files.createDirectories(folderPath);

            // Capturam imaginea paginii.
            File sourceFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            // Construim calea fisierului PNG.
            Path destinationPath =
                    folderPath.resolve(fileName + ".png");

            // Salvam captura si suprascriem fisierul daca exista.
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
