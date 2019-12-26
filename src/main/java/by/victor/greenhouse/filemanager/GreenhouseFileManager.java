package by.victor.greenhouse.filemanager;

import java.io.File;
import java.util.Optional;

public class GreenhouseFileManager {

    private static Optional<File> fileToParse=Optional.empty();

    public static void setFileToParse(File newFileToParse) {
        fileToParse = Optional.ofNullable(newFileToParse);
    }

    public static Optional<File> getFileToParse() {
        return fileToParse;
    }
}
