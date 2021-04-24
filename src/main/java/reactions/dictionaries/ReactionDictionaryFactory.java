package reactions.dictionaries;

import reactions.Reaction;

public class ReactionDictionaryFactory {

    public ReactionDictionary getDictionary(Reaction reaction) {
        return reaction.getDictionary();
    }
}
