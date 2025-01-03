package com.source.function.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.UnaryOperator;

@ExtendWith(MockitoExtension.class)
public class UnaryOperatorTest {

    @Test
    public void toUpperCase(){
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("hello"));
    }

    @Test
    public void square(){
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));
    }


}
