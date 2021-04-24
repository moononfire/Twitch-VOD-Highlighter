package util;

import chat.Timeframe;
import reactions.Lul;
import reactions.Pog;
import reactions.Reaction;

import java.util.ArrayList;
import java.util.List;

public class ReactionUtil {

    public static List<Reaction> getAllReactions() {
        List<Reaction> all = new ArrayList<>();
        all.add(new Pog());
        all.add(new Lul());

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
