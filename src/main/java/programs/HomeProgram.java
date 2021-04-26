package programs;

import io.file.FileHelper;
import io.input.states.InputState;
import io.input.states.TwitchVodIDInputState;
import programs.apps.HomeApp;
import programs.apps.options.ClippingOptions;
import programs.apps.options.ReactionOptions;
import programs.apps.options.timeframelengthoptions.TimeframeLengthOptions;

import java.io.IOException;

public class HomeProgram implements Program {

    HomeApp homeApp;
    InputState inputState;
    ClippingOptions clippingOptions;
    ReactionOptions reactionOptions;

    public HomeProgram() {
        inputState = new TwitchVodIDInputState(this);
        clippingOptions = new ClippingOptions();
        reactionOptions = new ReactionOptions();
    }

    public void run() throws IOException {
        while (true) {
            inputState.getInput();
        }
    }

    @Override
    public void changeStage(InputState newState) {
        inputState = newState;
    }

    @Override
    public void setTwitchVODId(String twitchVODId) throws IOException {
        homeApp = new HomeApp(FileHelper.getFilePath(twitchVODId));
    }

    @Override
    public void setClippingOptions(ClippingOptions options) {
        clippingOptions = options;
    }

    @Override
    public void setReactionOptions(ReactionOptions options) {
        reactionOptions = options;
    }

    @Override
    public void generateClips() throws IOException {
        homeApp.generateClips(clippingOptions ,reactionOptions);
    }

}
