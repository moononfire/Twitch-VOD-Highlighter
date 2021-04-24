package io.printers.writers;

import chat.Clip;
import chat.Timeframe;
import reactions.Reaction;
import util.ReactionUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MomentsFileWriter {
    public int writeTimeframes(Path filePath, List<Timeframe> timeframes, Reaction reaction) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(filePath);

        int noLines = 0;
        for (Timeframe timeframe : timeframes) {

            bw.write(timeframe.getComments().get(0).getTimestamp() + ", " + reaction.getReactions(timeframe, reaction) + "\n");
            ++noLines;
        }

        bw.close();

        return noLines;
    }

    public int writeTimeframes(Path filePath, List<Timeframe> timeframes, List<Reaction> reactions) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(filePath);

        int noLines = 0;
        for (Timeframe timeframe : timeframes) {

            bw.write(timeframe.getComments().get(0).getTimestamp() + ", " + ReactionUtil.getAllReactions(timeframe, reactions) + "\n");
            ++noLines;
        }
        bw.close();

        return noLines;
    }

    public int writeFullTimeframes(Path filePath, List<Timeframe> timeframes) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(filePath);

        int noLines = 0;
        for (Timeframe timeframe : timeframes) {

            bw.write(timeframe.toString());
            ++noLines;
        }
        bw.close();

        return noLines;
    }

    public int writeClips(Path filePath, List<Clip> clips) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(filePath);

        int noLines = 0;
        for (Clip clip : clips) {

            bw.write(clip.toString() + "\n");
            ++noLines;
        }
        bw.close();

        return noLines;
    }

}
