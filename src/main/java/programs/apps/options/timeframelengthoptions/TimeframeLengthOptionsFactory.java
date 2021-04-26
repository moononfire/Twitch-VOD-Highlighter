package programs.apps.options.timeframelengthoptions;

public class TimeframeLengthOptionsFactory {

    public TimeframeLengthOptions getTimeframeLengthOptions(String timeframeLenght) {
        switch (timeframeLenght) {
            case "60":
                return new TimeframeLengthOptions60Seconds();
            case "30":
                return new TimeframeLengthOptions30Seconds();
            case "15":
                return new TimeframeLengthOptions15Seconds();
        }

        return new TimeframeLengthOptions30Seconds();
    }
}
