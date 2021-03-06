package reactions;

import chat.Timeframe;
import reactions.dictionaries.FunnyDictionary;
import reactions.dictionaries.ReactionDictionary;

public class Funny implements Reaction {

    @Override
    public ReactionDictionary getDictionary() {
        return new FunnyDictionary();
    }

    @Override
    public int getReactions(Timeframe timeframe, Reaction reaction) {
        return timeframe.getReaction(reaction);
    }

    @Override
    public int getMaxCountSout() {
        return 150;
    }

    @Override
    public int getMaxCountFile() {
        return 1000;
    }

    @Override
    public int getMinValueSout() {
        return getUnifiedMinValue();
    }

    @Override
    public int getMinValueFile() {
        return getUnifiedMinValue();
    }

    private int getUnifiedMinValue() {
        return 6;
    }

    @Override
    public String toString() {
        return "Funny";
    }
}
