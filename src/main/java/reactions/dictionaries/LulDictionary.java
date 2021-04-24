package reactions.dictionaries;

import reactions.dictionaries.ReactionDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LulDictionary implements ReactionDictionary {

    private Set<String> lulWords;

    public LulDictionary() {
        String[] lulWordsArray = new String[] {"shivfpslul", "shivfpskekw", "shivfpstroll", "lmao", "lmfao", "haha", "hahaha", "hahahaha", "hahahahaha", "lol", "omegalol",
        "omegalul", "xd", "XD", "XDD", "xD", "xDD", "XDDD", "lul", "kekw", "pepelaugh", "kappa", "trihard", "jebaited", "minglee", "forsencd", "5head", "4head",
                "lmao", "lmfao"};

        lulWords = new HashSet<>();
        lulWords.addAll(Arrays.asList(lulWordsArray));
    }

    public boolean contains(String word) {
        return lulWords.contains(word.toLowerCase());
    }
}
