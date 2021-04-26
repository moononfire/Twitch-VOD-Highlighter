package programs.apps.options.timeframelengthoptions;

import chat.Comment;

public class TimeframeLengthOptions30Seconds implements TimeframeLengthOptions {

    @Override
    public int getTimeframeIndex(Comment comment) {
        String[] time = comment.getTimestamp().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);


        return 2 * (hours * 60 + minutes) + seconds / 30;
    }
}
