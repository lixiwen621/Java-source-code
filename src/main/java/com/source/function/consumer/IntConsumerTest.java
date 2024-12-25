package com.source.function.consumer;

import java.util.function.IntConsumer;

public class IntConsumerTest {

    public void calculateMath(){
        IntConsumer doubleValue = value -> System.out.println(value*2);
        IntConsumer squareValue = value -> System.out.println(value*value);
        IntConsumer combined = doubleValue.andThen(squareValue);
        combined.accept(2);
    }

    public static void main(String[] args) {
        new IntConsumerTest().calculateMath();
    }
}
