package programs;

import io.input.states.InputState;
import programs.apps.options.ClippingOptions;

public interface Program {

    void changeStage(InputState state);

    void setTwitchVODId(String id);

    void setClippingOptions(ClippingOptions options);

    void generateClips();
}
