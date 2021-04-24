package reactions;

import chat.Timeframe;
import reactions.dictionaries.ReactionDictionary;

public interface Reaction {

    static Reaction Pog() {
        return new Pog();
    }

    static Reaction Lul() {
        return new Lul();
    }

    int getReactions(Timeframe timeframe, Reaction reaction);

    int getMaxCountSout();

    int getMaxCountFile();

    int getMinValueSout();

    int getMinValueFile();

    ReactionDictionary getDictionary();
}
