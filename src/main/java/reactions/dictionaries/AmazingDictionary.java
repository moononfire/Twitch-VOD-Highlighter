package reactions.dictionaries;

import java.util.*;

public class AmazingDictionary implements ReactionDictionary {

    private Set<String> amazingWords;

    public AmazingDictionary() {
        String[] pogWordsArray = new String[] {"pog", "pogchamp", "wow", "pogu", "poggies", "pogg", "shivfpschamp", "shivfps",
                "shivfpshypers", "shivfps", "shivfpsaimbot", "shivfps", "shivfpspoggers", "shivfpslasered", "shivfpssmart",
                "shivfps200iq", "shivfpssparkle", "shivfpskekw", "shivfpstroll", "shivfpsholypoop", "shivfps5head", "insane", "omg", "holy", "hero", "hard", "carry",
                "shit", "wow!", "omfg", "ezclap", "ez", "clip", "what", "fuck", "fucking", "!!!", "poggers", "jebaited",
                "coggers", "monkagiga", "squadw", "bloodtrail", "sheesh", "sheeesh", "cracked", "aimbot",
                "kreygasm", "seemsgood", "kkomrade"};

        amazingWords = new HashSet<>();
        amazingWords.addAll(Arrays.asList(pogWordsArray));
    }

    public boolean contains(String word) {
        return amazingWords.contains(word.toLowerCase());
    }
}
