package programs.apps;

import chat.Timeframe;
import io.file.FileHelper;
import programs.apps.options.ClippingOptions;
import programs.apps.options.ReactionOptions;
import util.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HomeApp {

    private Path twitchChatPath;
    private Parser parser;

    public HomeApp(Path twitchChatPath) {
        this.twitchChatPath = twitchChatPath;
        parser = new Parser();
    }

    public void generateClips(ClippingOptions clippingOptions, ReactionOptions reactionOptions) throws IOException {

        List<Timeframe> timeframes = parser.parse(twitchChatPath, clippingOptions, reactionOptions);

        //TODO
    }
}
