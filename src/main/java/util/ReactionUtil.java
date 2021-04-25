package util;

import chat.Timeframe;
import reactions.Funny;
import reactions.Amazing;
import reactions.Reaction;

import java.util.ArrayList;
import java.util.List;

public class ReactionUtil {

    public static List<Reaction> getAllReactions() {
        List<Reaction> all = new ArrayList<>();
        all.add(new Amazing());
        all.add(new Funny());

        return all;
    }

    public static int getAllReactions(Timeframe timeframe, List<Reaction> reactions) {
        int reactionCount = 0;
        for (Reaction reaction : reactions) {
            reactionCount += reaction.getReactions(timeframe, reaction);
        }

        return reactionCount;
    }

    public static double getMinValuePogHighlight(double pogs) {
        return pogs * 1.2;
    }

    public static double getMinValueLulHighlight(double luls) { return luls * 1.2; }
}
