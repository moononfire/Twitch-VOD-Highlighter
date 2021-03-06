package reactions.dictionaries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FunnyDictionary implements ReactionDictionary {

    private Set<String> funnyWords;

    public FunnyDictionary() {
        String[] lulWordsArray = new String[] {"shivfpslul", "shivfpskekw", "shivfpstroll", "lmao", "lmfao", "haha", "hahaha", "hahahaha", "hahahahaha", "lol", "omegalol",
        "omegalul", "xd", "XD", "XDD", "xD", "xDD", "XDDD", "lul", "kekw", "pepelaugh", "kappa", "trihard", "jebaited", "minglee", "forsencd", "5head", "4head",
                "lmao", "lmfao"};

        funnyWords = new HashSet<>();
        funnyWords.addAll(Arrays.asList(lulWordsArray));
    }

    public boolean contains(String word) {
        return funnyWords.contains(word.toLowerCase());
    }
}
