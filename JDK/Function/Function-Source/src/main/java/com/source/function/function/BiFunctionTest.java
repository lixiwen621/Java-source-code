package com.source.function.function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BiFunction;

@ExtendWith(MockitoExtension.class)
public class BiFunctionTest {

    @Test
    public void calculateMultiply(){
        BiFunction<Integer,Integer,Integer> multiplyFunction = (a,b) -> a*b;
        System.out.println(multiplyFunction.apply(5,6));
    }
}
