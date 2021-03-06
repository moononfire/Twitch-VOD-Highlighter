package util;

import chat.Clip;
import chat.Timeframe;
import reactions.Funny;
import reactions.Amazing;
import reactions.Reaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TimeframeUtil {

    static Amazing amazing = new Amazing();
    static Funny funny = new Funny();

    public static double calculateAverageReactions(List<Timeframe> timeframes, Reaction reaction) {
        int calculated = 0;

        for (Timeframe timeframe : timeframes) {
            calculated += timeframe.getReaction(reaction);
        }

        double average = calculated / timeframes.size();
        return average;
    }

    public static int getReactionMomentsCountSout(Reaction reaction, int listSize) {
        return Math.min(reaction.getMaxCountSout(), listSize);
    }

    public static List<Timeframe> getFilteredSout(List<Timeframe> timeframes, List<Reaction> reactions) {
        List<Timeframe> filtered = new ArrayList<>();

        for (Reaction reaction : reactions) {
            filtered.addAll(timeframes.stream().filter(t -> t.getReaction(reaction) >= reaction.getMinValueSout()).limit(reaction.getMaxCountSout()).collect(Collectors.toList()));
        }

        return filtered;
    }

    public static List<Timeframe> getFilteredSout(List<Timeframe> timeframes, Reaction reaction) {
        return timeframes.stream().filter(t -> t.getReaction(reaction) >= reaction.getMinValueSout()).limit(reaction.getMaxCountSout()).collect(Collectors.toList());
    }

    public static List<Timeframe> getFilteredFile(List<Timeframe> timeframes, List<Reaction> reactions) {
        List<Timeframe> filtered = new ArrayList<>();

        for (Reaction reaction : reactions) {
            filtered.addAll(timeframes.stream().filter(t -> t.getReaction(reaction) >= reaction.getMinValueFile()).limit(reaction.getMaxCountFile()).collect(Collectors.toList()));
        }

        return filtered;
    }

    public static List<Timeframe> getFilteredFile(List<Timeframe> timeframes, Reaction reaction) {
        return timeframes.stream().filter(t -> t.getReaction(reaction) >= reaction.getMinValueFile()).limit(reaction.getMaxCountFile()).collect(Collectors.toList());
    }

    public static List<Timeframe> getFilteredHighlightedFile(List<Timeframe> timeframes, List<Reaction> reactions) {
        List<Timeframe> highlighted = new ArrayList<>();

        for (Reaction reaction : reactions) {
            List<Timeframe> filtered = getFilteredFile(timeframes, reaction);
            double averageReactions = calculateAverageReactions(filtered, reaction);
            double minReactionsForHighlight = ReactionUtil.getMinValuePogHighlight(averageReactions);
            highlighted.addAll(filtered.stream().filter(t -> t.getReaction(reaction) >= minReactionsForHighlight).collect(Collectors.toList()));
        }

        return highlighted;
    }

    public static List<Clip> getClipsFromTimeframes(List<Timeframe> timeframes) {
        if (timeframes.size() <= 2) {
            System.out.println("Only 2 timeframes - that is an error!");
            return null;
        }

        List<Clip> clips = new ArrayList<>();
        Clip firstClip = new Clip(1);

        firstClip.addTimeframe(timeframes.get(0));
        firstClip.addTimeframe(timeframes.get(1));
        clips.add(firstClip);

        Clip lastClip = firstClip;
        int clipCount = 1;
        for (int i = 2; i < timeframes.size(); ++i) {
            Timeframe currentTimeframe = timeframes.get(i);

            if (currentTimeframe.getId() - 2 == lastClip.getLastAddedTimeframeId() || currentTimeframe.getId() - 1 == lastClip.getLastAddedTimeframeId()) {
                lastClip.addTimeframe(currentTimeframe);
            } else {
                ++clipCount;
                Clip newClip = new Clip(clipCount);
                newClip.addTimeframe(currentTimeframe);
                clips.add(newClip);
                lastClip = newClip;
            }
        }

        return clips;
    }

    public static String[] availableTimeframeLengthOptions() {
        return new String[]{"15", "30", "60"};
    }

}
