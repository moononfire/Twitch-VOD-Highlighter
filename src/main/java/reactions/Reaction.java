package reactions;

import chat.Timeframe;
import reactions.dictionaries.ReactionDictionary;

public interface Reaction {

    static Reaction Pog() {
        return new Amazing();
    }

    static Reaction Lul() {
        return new Funny();
    }

    int getReactions(Timeframe timeframe, Reaction reaction);

    int getMaxCountSout();

    int getMaxCountFile();

    int getMinValueSout();

    int getMinValueFile();

    ReactionDictionary getDictionary();
}
