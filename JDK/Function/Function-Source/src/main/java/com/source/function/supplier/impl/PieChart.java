package com.source.function.supplier.impl;


import com.source.function.supplier.chart.Chart;

public class PieChart implements Chart {
    public PieChart(){
        System.out.println("创建饼状图");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图");
    }
}
