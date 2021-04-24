package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    private String CHAT_FILE_NAME;

    private String PROJECT_LOCATION_PATH;

    private String INPUT_FOLDER_PATH;
    private String OUTPUT_FOLDER_PATH;

    private String POG_OUTPUT_FILE_NAME;
    private String LUL_OUTPUT_FILE_NAME;
    private String MOMENTS_OUTPUT_FILE_NAME;
    private String HIGHLIGHTS_OUTPUT_NAME;
    private String CLIPS_OUTPUT_NAME;

    public FileHandler(String CHAT_FILE_NAME) {
        this.CHAT_FILE_NAME = CHAT_FILE_NAME;

        PROJECT_LOCATION_PATH = System.getProperty("user.dir") + "/";

        INPUT_FOLDER_PATH = PROJECT_LOCATION_PATH + "IN/";
        OUTPUT_FOLDER_PATH = PROJECT_LOCATION_PATH + "OUT/" + CHAT_FILE_NAME + "/";

        POG_OUTPUT_FILE_NAME = CHAT_FILE_NAME + "_pog.txt";
        LUL_OUTPUT_FILE_NAME = CHAT_FILE_NAME + "_lul.txt";
        MOMENTS_OUTPUT_FILE_NAME = CHAT_FILE_NAME + "_best_moments.txt";
        HIGHLIGHTS_OUTPUT_NAME = CHAT_FILE_NAME + "_highlights.txt";
        CLIPS_OUTPUT_NAME = CHAT_FILE_NAME + "_clips.txt";
    }

    public Path getPath(String folder, String fileName) {
        return Paths.get(folder + fileName);
    }

    public Path removeAndGetPath(String folder, String fileName) throws IOException {
        Path folderPath = Paths.get(folder);
        Files.createDirectories(folderPath);

        Path filePath = Paths.get(folder + fileName);
        Files.deleteIfExists(filePath);

        return Files.createFile(filePath);
    }

    public Path getInputFilePath() throws IOException {
        return getPath(INPUT_FOLDER_PATH, CHAT_FILE_NAME + ".txt");
    }

    public Path getMomentsOutputPath() throws IOException {
        return removeAndGetPath(OUTPUT_FOLDER_PATH, MOMENTS_OUTPUT_FILE_NAME);
    }

    public Path getPogsOutputPath() throws IOException {
        return removeAndGetPath(OUTPUT_FOLDER_PATH, POG_OUTPUT_FILE_NAME);
    }

    public Path getLulsOutputPath() throws IOException {
        return removeAndGetPath(OUTPUT_FOLDER_PATH, LUL_OUTPUT_FILE_NAME);
    }

    public Path getHighlightedOutputPath() throws IOException {
        return removeAndGetPath(OUTPUT_FOLDER_PATH, HIGHLIGHTS_OUTPUT_NAME);
    }

    public Path getClipsOutputPath() throws IOException {
        return removeAndGetPath(OUTPUT_FOLDER_PATH, CLIPS_OUTPUT_NAME);
    }
}
