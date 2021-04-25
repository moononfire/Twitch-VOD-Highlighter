package programs.apps.options;

public class ClippingOptions {

    int emptyTimeframesBeforeCuttingClip;
    int timeframeLength;

    public ClippingOptions() {
        this.emptyTimeframesBeforeCuttingClip = 2;
        this.timeframeLength = 30;
    }

    public ClippingOptions(int emptyTimeframesBeforeCuttingClip, int timeframeLength) {
        this.emptyTimeframesBeforeCuttingClip = emptyTimeframesBeforeCuttingClip;
        this.timeframeLength = timeframeLength;
    }
}
