package programs;

import io.input.states.InputState;
import programs.apps.options.ClippingOptions;
import programs.apps.options.ReactionOptions;
import programs.apps.options.timeframelengthoptions.TimeframeLengthOptions;

import java.io.IOException;

public interface Program {

    void run() throws IOException;

    void changeStage(InputState state);

    void setTwitchVODId(String id) throws IOException;

    void setClippingOptions(ClippingOptions options);

    void setReactionOptions(ReactionOptions options);

    void generateClips() throws IOException;
}
