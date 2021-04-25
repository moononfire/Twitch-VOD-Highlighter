package programs.apps.options;

import reactions.Reaction;
import util.ReactionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReactionOptions {

    List<Reaction> reactions;
    Map<Reaction, Integer> minReactionsInTimeframeToAddAsClip;
    Map<Reaction, Integer> maxReactionsToCountIn1Comment;

    public ReactionOptions() {
        reactions = ReactionUtil.getAllReactions();

        minReactionsInTimeframeToAddAsClip = new HashMap<>();
        maxReactionsToCountIn1Comment = new HashMap<>();

        for (Reaction reaction : reactions) {
            minReactionsInTimeframeToAddAsClip.put(reaction, 10);
            maxReactionsToCountIn1Comment.put(reaction, 3);
        }
    }

    public ReactionOptions(Map<Reaction, Integer> minReactionsInTimeframeToAddAsClip, Map<Reaction, Integer> maxReactionsToCountIn1Comment) {
        reactions = ReactionUtil.getAllReactions();
        this.minReactionsInTimeframeToAddAsClip = minReactionsInTimeframeToAddAsClip;
        this.maxReactionsToCountIn1Comment = maxReactionsToCountIn1Comment;
    }
}
