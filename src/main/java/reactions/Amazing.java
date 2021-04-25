package reactions;

import chat.Timeframe;
import reactions.dictionaries.AmazingDictionary;
import reactions.dictionaries.ReactionDictionary;

public class Amazing implements Reaction {

    @Override
    public ReactionDictionary getDictionary() {
        return new AmazingDictionary();
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
        return 5;
    }


    @Override
    public String toString() {
        return "Amazing";
    }

}
