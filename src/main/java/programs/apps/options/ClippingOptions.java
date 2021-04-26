package programs.apps.options;

import programs.apps.options.timeframelengthoptions.TimeframeLengthOptions;
import programs.apps.options.timeframelengthoptions.TimeframeLengthOptions30Seconds;

public class ClippingOptions {

    int emptyTimeframesBeforeCuttingClip;
    private TimeframeLengthOptions timeframeLengthOptions;

    public ClippingOptions() {
        this.emptyTimeframesBeforeCuttingClip = 2;
        timeframeLengthOptions = new TimeframeLengthOptions30Seconds();
    }

    public ClippingOptions(int emptyTimeframesBeforeCuttingClip, TimeframeLengthOptions timeframeLengthOptions) {
        this.emptyTimeframesBeforeCuttingClip = emptyTimeframesBeforeCuttingClip;
        this.timeframeLengthOptions = timeframeLengthOptions;
    }

    public int getEmptyTimeframesBeforeCuttingClip() {
        return emptyTimeframesBeforeCuttingClip;
    }
}
