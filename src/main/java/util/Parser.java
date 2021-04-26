package util;

import chat.Comment;
import chat.Timeframe;
import programs.apps.options.ClippingOptions;
import programs.apps.options.ReactionOptions;
import programs.apps.options.timeframelengthoptions.TimeframeLengthOptions;
import reactions.Reaction;
import reactions.dictionaries.ReactionDictionary;
import reactions.dictionaries.ReactionDictionaryFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Parser {

    public Parser() {
        TimeframeLengthOptions timeframeLengthOptions
    }

    public List<Timeframe> parse(Path chatFilePath, ClippingOptions clippingOptions, ReactionOptions reactionOptions) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(chatFilePath)) {
            List<Timeframe> timeframes = new ArrayList<>();
            List<Comment> comments = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                comments.add(CommentUtil.parseComment(line));
                timeframes.add(TimeframeLengthOptions.)
            }

            timeFrame = determineTimeframeForComment(timeFrame, comment, timeframes);
            Map<String, Integer> reactions = new HashMap<>();
        }



        for (Timeframe timeframe : timeframes) {
            countAllReactionsInTimeframe(timeframe);
        }

        return timeframes;
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
