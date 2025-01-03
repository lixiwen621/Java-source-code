package com.source.function.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BinaryOperator;

@ExtendWith(MockitoExtension.class)
public class BinaryOperatorTest {

    @Test
    public void add(){
        BinaryOperator<Integer> add = (a,b)-> a + b;
        System.out.println(add.apply(5,6));
    }

}
