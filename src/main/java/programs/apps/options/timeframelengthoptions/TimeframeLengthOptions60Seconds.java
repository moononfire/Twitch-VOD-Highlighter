package programs.apps.options.timeframelengthoptions;

import chat.Comment;

public class TimeframeLengthOptions60Seconds implements TimeframeLengthOptions {

    @Override
    public int getTimeframeIndex(Comment comment) {
        int hours = Integer.parseInt(comment.getTimestamp().split(":")[0]);
        int minutes = Integer.parseInt(comment.getTimestamp().split(":")[1]);


        return hours * 60 + minutes;
    }
}
