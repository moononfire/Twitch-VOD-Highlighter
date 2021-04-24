package util;

import chat.Timeframe;

import java.util.ArrayList;
import java.util.List;

public class TimeframeConverter {

    public static List<Timeframe> limitByCount(List<Timeframe> timeframes, int limit) {
        List<Timeframe> result = new ArrayList<>();

        int counter = 0;
        for (Timeframe timeframe : timeframes) {
            result.add(timeframe);
            ++counter;

            if (counter == limit) {
                break;
            }
        }

        return result;
    }
}
