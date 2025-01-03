package com.source.function.supplier.impl;


import com.source.function.supplier.chart.Chart;

public class LineChart implements Chart {
    public LineChart(){
        System.out.println("创建折线图");
    }
    @Override
    public void display() {
        System.out.println("显示折线图");
    }
}
