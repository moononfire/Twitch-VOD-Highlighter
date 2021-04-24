package io.printers.writers;

import chat.Clip;
import chat.Timeframe;
import reactions.Reaction;
import util.ReactionUtil;

import java.io.IOException;
import java.util.List;

public class MomentsConsoleWriter {
    public int writeTimeframes(List<Timeframe> timeframes, Reaction reaction) {
        int i = 0;
        for (Timeframe timeframe : timeframes) {

            System.out.println(timeframe.getComments().get(0).getTimestamp() + ", " + reaction.getReactions(timeframe, reaction));
            ++i;
        }

        return i;
    }

    public int writeTimeframes(List<Timeframe> timeframes, List<Reaction> reactions) {
        int i = 0;
        for (Timeframe timeframe : timeframes) {

            System.out.println(timeframe.getComments().get(0).getTimestamp() + ", " + ReactionUtil.getAllReactions(timeframe, reactions));
            ++i;
        }

        return i;
    }

    public int writeFullTimeframes(List<Timeframe> timeframes) throws IOException {
        int noLines = 0;
        for (Timeframe timeframe : timeframes) {

            System.out.println(timeframe);
            ++noLines;
        }

        return noLines;
    }

    public int writeClips(List<Clip> clips) {
        int noLines = 0;
        for (Clip clip : clips) {

            System.out.println(clip);
            ++noLines;
        }

        return noLines;
    }
}
