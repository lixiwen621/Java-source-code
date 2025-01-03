package com.source.function.supplier.factory;


import com.source.function.supplier.chart.Chart;
import com.source.function.supplier.impl.HistogramChart;
import com.source.function.supplier.impl.LineChart;
import com.source.function.supplier.impl.PieChart;

import java.util.function.Supplier;

public class ChartFactory {
    public static Chart getChart(String type){
        Chart chart = null;
        // 下面这些违反了开闭原则
        if (type.equalsIgnoreCase("histogram")){
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图");
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置柱状图");
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("初始化设置折线图");
        }
        return chart;
    }

    /**
     * 采用Supplier 的方式来创建工厂对象
     * @param supplier
     * @return
     */
    public static Chart getChart(Supplier<Chart> supplier){
        return supplier.get();
    }
}
