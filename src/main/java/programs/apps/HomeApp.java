package programs.apps;

import chat.Timeframe;
import io.file.FileHelper;
import programs.apps.options.ClippingOptions;
import util.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HomeApp {

    private Path twitchChatPath;
    private FileHelper fileHelper;
    private Parser parser;

    public HomeApp(Path twitchChatPath) {
        this.twitchChatPath = twitchChatPath;
        fileHelper = new FileHelper();
        parser = new Parser();
    }

    public void generateClips(ClippingOptions options) throws IOException {
        List<Timeframe> timeframes = parser.parse(twitchChatPath, options);

        //TODO
    }
}
