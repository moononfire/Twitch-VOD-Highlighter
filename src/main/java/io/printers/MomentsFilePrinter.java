package io.printers;

import chat.Clip;
import chat.Timeframe;
import io.printers.writers.MomentsFileWriter;
import reactions.Reaction;
import util.ReactionUtil;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class MomentsFilePrinter {

    private MomentsFileWriter fileWriter;

    public MomentsFilePrinter(MomentsFileWriter momentsFileWriter) {
        fileWriter = momentsFileWriter;
    }

    public void printFullMoments(Path filePath, List<Timeframe> timeframes) throws IOException {
        System.out.println("Saving best " + timeframes.size() + " moments to file...");

        timeframes.sort(Comparator.comparing(t -> ReactionUtil.getAllReactions(t, ReactionUtil.getAllReactions()), Comparator.reverseOrder()));

        int noLines = fileWriter.writeFullTimeframes(filePath, timeframes);
        System.out.println("Saved " + noLines + " timeframes");
    }

    public void printShortMoments(Path filePath, List<Timeframe> timeframes, Reaction reaction) throws IOException {
        System.out.println("Saving best " + timeframes.size() + " " + reaction.toString() + " moments to file...");

        timeframes.sort(Comparator.comparing(x -> x.getComments().get(0).getTimestamp()));

        int noLines = fileWriter.writeTimeframes(filePath, timeframes, reaction);
        System.out.println("Saved " + noLines + " timeframes");
    }

    public void printHighlights(Path filePath, List<Timeframe> timeframes, List<Reaction> reactions) throws IOException {
        System.out.println("Saving best " + timeframes.size() + " highlights to file...");

        timeframes.sort(Comparator.comparing(x -> x.getComments().get(0).getTimestamp()));

        int noLines = fileWriter.writeTimeframes(filePath, timeframes, reactions);
        System.out.println("Saved " + noLines + " highlights");
    }

    public void printClips(Path filePath, List<Clip> clips) throws IOException {
        System.out.println("Saving " + clips.size() + " clips to file...");

        clips.sort(Comparator.comparing(x -> x.getFirstTimestamp()));

        int noLines = fileWriter.writeClips(filePath, clips);
        System.out.println("Saved " + noLines + " clips");
    }

}
