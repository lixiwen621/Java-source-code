package com.source.function.supplier.main;

import com.source.function.supplier.chart.Chart;
import com.source.function.supplier.factory.ChartFactory;
import com.source.function.supplier.impl.LineChart;

public class Client {
    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart("histogram");
        chart.display();
        Chart lineChart = ChartFactory.getChart(LineChart::new);
        lineChart.display();
    }
}
