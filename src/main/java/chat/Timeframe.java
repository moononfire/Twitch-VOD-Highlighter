package chat;

import reactions.Reaction;
import util.ReactionUtil;

import java.util.*;

public class Timeframe {

    private int id;
    private List<Comment> comments;
    Map<String, Integer> reactions;

    public Timeframe() {
        comments = new LinkedList<>();
        reactions = new HashMap<>();
        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            reactions.put(reaction.toString(), 0);
        }
    }

    public Timeframe(List<Reaction> reactions) {
        comments = new LinkedList<>();
        this.reactions = new HashMap<>();
        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            this.reactions.put(reaction.toString(), 0);
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Integer getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void incrementReaction(Reaction reaction, int value) {
        int oldValue = reactions.get(reaction.toString());
        reactions.put(reaction.toString(), oldValue + value);
    }

    public int getReaction(Reaction reaction) {
        return reactions.get(reaction.toString());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder("Timeframe #" + id + "\n");

        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            stringBuilder.append("\n").append(reaction.toString()).append(": ").append(reactions.get(reaction.toString()));
        }

        stringBuilder.append("\nComments: \n").append(comments);

        return stringBuilder.toString();
    }
}
