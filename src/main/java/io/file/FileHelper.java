package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    private static final String PROJECT_LOCATION_PATH = System.getProperty("user.dir") + "/";

    public boolean isFileAvailable(String twitchVodId) {
        return Files.exists(Paths.get(PROJECT_LOCATION_PATH + "/IN/" + twitchVodId + ".txt"));
    }

    public static Path getFilePath(String twitchVodId) throws IOException {
        return Files.createFile(Paths.get(PROJECT_LOCATION_PATH + "/IN/" + twitchVodId + ".txt"));
    }
}
