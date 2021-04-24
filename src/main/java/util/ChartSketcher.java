package util;

import chat.Timeframe;
import reactions.Reaction;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.List;

public class ChartSketcher {

    public void sketchQuickChart(List<Timeframe> timeframes, Reaction reaction) {
        double[] xData = new double[timeframes.size()];
        int i = 0;
        for (Timeframe timeframe : timeframes) {
            xData[i] = timeframe.getId() / 2;
            ++i;
        }

        double[] yData = new double[timeframes.size()];
        int j = 0;
        for (Timeframe timeframe : timeframes) {
            yData[j] = timeframe.getReaction(reaction);
            ++j;
        }

        // Create Chart
        XYChart chart = new XYChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
        chart.addSeries("" + i, xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();
    }
}
