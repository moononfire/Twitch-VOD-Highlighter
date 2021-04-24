package chat;

import reactions.Reaction;
import util.ReactionUtil;

import java.util.HashMap;
import java.util.Map;

public class Comment {

    private String author;
    private String comment;
    private String timestamp;
    private Map<String, Integer> reactions;

    public Comment() {
        reactions = new HashMap<>();
        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            reactions.put(reaction.toString(), 0);
        }
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReactions(Reaction reaction, int count) {
        reactions.put(reaction.toString(), count);
    }

    public int getReactions(Reaction reaction) {
        return reactions.get(reaction.toString());
    }

    private Map<String, Integer> getAllReactions() {
        return reactions;
    }

    @Override
    public String toString() {
        return
//                "\n\t" +
                "[" + timestamp + "]: " +
                author + ": " +
                comment + ", " +
                "Reactions: " + this.getAllReactions();
    }
}
