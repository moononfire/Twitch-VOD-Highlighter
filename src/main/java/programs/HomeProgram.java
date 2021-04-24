package programs;

import io.input.states.InputState;
import io.input.states.TwitchVodIDInputState;
import programs.apps.HomeApp;
import programs.apps.options.ClippingOptions;

import java.io.IOException;

public class HomeProgram implements Program {

    HomeApp homeApp;
    InputState inputState;
    ClippingOptions clippingOptions;

    public HomeProgram() {
        inputState = new TwitchVodIDInputState(this);
        clippingOptions = new ClippingOptions();
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
    public void setTwitchVODId(String twitchVODId) {
        homeApp = new HomeApp(twitchVODId);
    }

    @Override
    public void setClippingOptions(ClippingOptions options) {
        clippingOptions = options;
    }

    @Override
    public void generateClips() {
        homeApp.generateClips(clippingOptions);
    }

}
