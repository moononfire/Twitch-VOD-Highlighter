package chat;

import reactions.Reaction;
import util.ReactionUtil;

import java.util.*;

public class Timeframe {

    private int id;
    private List<Comment> comments;
    public boolean isFirstHalf;
    private String streamer;
    private String twitchVodId;
    Map<String, Integer> reactions;

    public Timeframe() {
        comments = new LinkedList<>();
        reactions = new HashMap<>();
        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            reactions.put(reaction.toString(), 0);
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean isFirstHalf() {
        return isFirstHalf;
    }

    public void setFirstHalf(boolean firstHalf) {
        isFirstHalf = firstHalf;
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
        return "chat.Timeframe #" + id +
                "\nPogs: " + reactions.get(Reaction.Pog().toString()) +
                "\nLuls: " + reactions.get(Reaction.Lul().toString()) +
                "\nComments: \n" + comments;
    }
}
