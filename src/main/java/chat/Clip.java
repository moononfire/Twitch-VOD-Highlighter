package chat;

import java.util.ArrayList;
import java.util.List;

public class Clip {

    int id;
    List<Timeframe> timeframes;
    int lastAddedTimeframeId;

    String lastTimestamp;

    public Clip(int id) {
        this.id = id;
        this.timeframes = new ArrayList<>();
        lastTimestamp = "00:00:00";
    }

    public void addTimeframe(Timeframe timeframe) {
        timeframes.add(timeframe);
        lastAddedTimeframeId = timeframe.getId();
        lastTimestamp = timeframe.getComments().get(timeframe.getComments().size() - 1).getTimestamp();
    }

    public int getLastAddedTimeframeId() {
        return lastAddedTimeframeId;
    }

    public String getFirstTimestamp() {
        return timeframes.get(0).getComments().get(0).getTimestamp();
    }

    @Override
    public String toString() {
        String firstTimeframeTimestamp = timeframes.get(0).getComments().get(0).getTimestamp();

        return "chat.Clip # " + id + ": " + firstTimeframeTimestamp + "-" + lastTimestamp + " ";
    }
}
