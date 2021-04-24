package io.file;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {

    private final String PROJECT_LOCATION_PATH = System.getProperty("user.dir") + "/";

    public boolean isFileAvailable(String twitchVodId) {
        return Files.exists(Paths.get(PROJECT_LOCATION_PATH + "/IN/" + twitchVodId + ".txt"));
    }
}
