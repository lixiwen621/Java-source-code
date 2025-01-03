package com.source.function.operator;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.BinaryOperator;

public class DoubleUtils {
    private static final Map<String, BinaryOperator<Double>> operatorMap = Maps.newHashMap();

    public static void registerOperation(String symbol, BinaryOperator<Double> operator) {
        operatorMap.put(symbol, operator);
    }

    static {
        DoubleUtils.registerOperation("+", (a, b) -> {
            BigDecimal adecimal = BigDecimal.valueOf(a);
            BigDecimal bdecimal = BigDecimal.valueOf(b);
            return adecimal.add(bdecimal).doubleValue();
        });
        DoubleUtils.registerOperation("-", (a, b) -> {
            BigDecimal adecimal = BigDecimal.valueOf(a);
            BigDecimal bdecimal = BigDecimal.valueOf(b);
            return adecimal.subtract(bdecimal).doubleValue();
        });
        DoubleUtils.registerOperation("*", (a, b) -> {
            BigDecimal adecimal = BigDecimal.valueOf(a);
            BigDecimal bdecimal = BigDecimal.valueOf(b);
            return adecimal.multiply(bdecimal).doubleValue();
        });
        DoubleUtils.registerOperation("/", (a, b) -> {
            BigDecimal adecimal = BigDecimal.valueOf(a);
            BigDecimal bdecimal = BigDecimal.valueOf(b);
            if (bdecimal.compareTo(new BigDecimal("0")) == 0) {
                return 0D;
            }
            return adecimal.divide(bdecimal, 6, BigDecimal.ROUND_HALF_UP).doubleValue();
        });
    }

    /**
     * double计算的通用方法
     *
     * @param a
     * @param symbol 这个为String的 "+", "-", "*", "/"
     * @param b
     * @return
     */
    public static Double calculate(Double a, String symbol, Double b) {
        BinaryOperator<Double> binaryOperator = operatorMap.get(symbol);
        return binaryOperator.apply(a, b);
    }
}
