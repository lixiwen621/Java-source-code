package com.source.function.predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BiPredicate;

@ExtendWith(MockitoExtension.class)
public class BiPredicateTest {

    @Test
    public void bothPositive(){
        BiPredicate<Integer,Integer> bothPositive = (a,b)-> a > 0 && b > 0;
        System.out.println(bothPositive.test(2,2));
        System.out.println(bothPositive.test(2,-1));
    }


}
