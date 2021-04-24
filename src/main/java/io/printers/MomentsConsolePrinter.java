package io.printers;

import chat.Clip;
import chat.Timeframe;
import io.printers.writers.MomentsConsoleWriter;
import reactions.Reaction;

import java.io.*;
import java.util.*;

public class MomentsConsolePrinter {

    private MomentsConsoleWriter consoleWriter;

    public MomentsConsolePrinter(MomentsConsoleWriter momentsConsoleWriter) {
        consoleWriter = momentsConsoleWriter;
    }

    public void printFullMoments(List<Timeframe> timeframes) throws IOException {
        System.out.println("Printing best " + timeframes.size() + " moments:");

        timeframes.sort(Comparator.comparing(x -> x.getComments().get(0).getTimestamp()));

        int noLines = consoleWriter.writeFullTimeframes(timeframes);
        System.out.println("Printed " + noLines + " timeframes");
    }

    public void printShortMoments(List<Timeframe> timeframes, Reaction reaction) {
        System.out.println("Printing best " + timeframes.size() + " " + reaction.toString() + " moments...");

        timeframes.sort(Comparator.comparing(x -> x.getComments().get(0).getTimestamp()));

        int noLines = consoleWriter.writeTimeframes(timeframes, reaction);
        System.out.println("Printed " + noLines + " timeframes");
    }

    public void printHighlights(List<Timeframe> timeframes, List<Reaction> reactions) throws IOException {
        System.out.println("Printing best " + timeframes.size() + " highlights:");

        timeframes.sort(Comparator.comparing(x -> x.getComments().get(0).getTimestamp()));

        int noLines = consoleWriter.writeTimeframes(timeframes, reactions);
        System.out.println("Printed " + noLines + " highlights");
    }

    public void printClips(List<Clip> clips) {
        System.out.println("Printing highlighted clips:");

        clips.sort(Comparator.comparing(x -> x.getFirstTimestamp()));

        int noLines = consoleWriter.writeClips(clips);
        System.out.println("Printed " + noLines + " clips");
    }

}
