package util;

import chat.Comment;

public class CommentUtil {

    public static Comment parseComment(String line) {
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
}
