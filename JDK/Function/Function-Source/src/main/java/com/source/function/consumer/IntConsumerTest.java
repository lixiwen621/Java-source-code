package com.source.function.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.IntConsumer;

@ExtendWith(MockitoExtension.class)
public class IntConsumerTest {

    @Test
    public void calculateMath(){
        IntConsumer doubleValue = value -> System.out.println(value*2);
        IntConsumer squareValue = value -> System.out.println(value*value);
        IntConsumer combined = doubleValue.andThen(squareValue);
        combined.accept(2);
    }


}
