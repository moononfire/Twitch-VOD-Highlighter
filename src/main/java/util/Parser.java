package util;

import chat.Comment;
import chat.Timeframe;
import reactions.Reaction;
import reactions.dictionaries.ReactionDictionary;
import reactions.dictionaries.ReactionDictionaryFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Parser {

    public List<Timeframe> parse(Path chatFilePath) throws IOException {
        List<Timeframe> timeframes = new ArrayList<>();

        Timeframe timeFrame = new Timeframe();
        timeFrame.setId(1);
        timeFrame.setFirstHalf(true);
        timeframes.add(timeFrame);

        try (BufferedReader br = Files.newBufferedReader(chatFilePath)) {
            String line;

            while ((line = br.readLine()) != null) {
                Comment comment = parseComment(line);
                timeFrame = determineTimeframeForComment(timeFrame, comment, timeframes);
            }
        }

        for (Timeframe timeframe : timeframes) {
            countAllReactionsInTimeframe(timeframe);
        }

        return timeframes;
    }

    private Comment parseComment(String line) {
        if (line.charAt(0) != '[') {
            line = line.substring(1);
        }

        Comment comment = new Comment();
        String[] commentValues = line.split(" ", 3);
        comment.setTimestamp(commentValues[0].substring(1).substring(0, commentValues[0].length() - 2));
        comment.setAuthor(commentValues[1].substring(0, commentValues[1].length() - 1));
        comment.setComment(commentValues[2]);

        return comment;
    }

    private Timeframe determineTimeframeForComment(Timeframe timeframe, Comment comment, List<Timeframe> timeframes) {
        String seconds = comment.getTimestamp().split(":")[2].substring(0, 2);
        Timeframe newTimeframe = null;
        if (timeframe.isFirstHalf() && Integer.parseInt(seconds) >= 30 || !timeframe.isFirstHalf() && Integer.parseInt(seconds) < 30) {
            newTimeframe = new Timeframe();
            newTimeframe.setId(timeframe.getId() + 1);
            newTimeframe.setFirstHalf(!timeframe.isFirstHalf());
            timeframes.add(newTimeframe);
        }

        if (newTimeframe == null) {
            timeframe.addComment(comment);
        } else {
            newTimeframe.addComment(comment);
        }

        return newTimeframe == null ? timeframe : newTimeframe;
    }

    private void countAllReactionsInTimeframe(Timeframe timeframe) {
        List<Reaction> reactions = ReactionUtil.getAllReactions();

        for (Reaction reaction : reactions) {
            int reactionCount = 0;

            for (Iterator i = timeframe.getComments().iterator(); i.hasNext();) {
                reactionCount += countReactions((Comment) i.next(), reaction);
            }

            timeframe.incrementReaction(reaction, reactionCount);
        }
    }

    private int countReactions(Comment comment, Reaction reaction) {
        ReactionDictionaryFactory factory = new ReactionDictionaryFactory();
        ReactionDictionary dictionary = factory.getDictionary(reaction);

        String[] words = comment.getComment().split(" ");
        for (String word : words) {
            if (dictionary.contains(word)) {
                comment.setReactions(reaction, comment.getReactions(reaction) + 1);
            }
        }

        comment.setReactions(reaction, Math.min(comment.getReactions(reaction), 3));

        return comment.getReactions(reaction);
    }

}
