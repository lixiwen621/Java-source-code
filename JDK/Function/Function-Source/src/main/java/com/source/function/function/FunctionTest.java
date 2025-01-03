package com.source.function.function;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.function.Function;

@ExtendWith(MockitoExtension.class)
public class FunctionTest {

    /**
     *  数据类型转换
     *  data type conversion
     */
    @Test
    public void StringToInteger(){
        Function<String,Integer> stringIntegerFunction = Integer::valueOf;
        Integer apply = stringIntegerFunction.apply("023");
        Object number = StringConvertNumber("lixiwen", Integer::valueOf);
        System.out.println(apply);
        System.out.println(number);
    }

    private Object StringConvertNumber(String number,Function<String,Number> function){
        Objects.requireNonNull(number);
        if (StringUtils.isNumeric(number)){
            return function.apply(number);
        }
        return number;
    }

    @Test
    public void processData(){
        Function<String,String> trimFunction = String::trim;
        Function<String,Integer> lengthFunction = String::length;

        Function<String,Integer> processFunction = trimFunction.andThen(lengthFunction);
        Integer apply = processFunction.apply("  hello world  ");
        System.out.println(apply);
    }

    @Test
    public void useStream(){
        List<String> strings = Arrays.asList("apple","banana","cherry");

        List<Integer> list = strings.stream()
                .map(String::length)
                .toList();

        System.out.println(list);
    }

    @Test
    public void conditionalLogic(){
        Function<Integer,String> sizeDescription = x -> {
            if (x < 10) return "Small";
            else if (x < 100) return "Medium";
            else return "Large";
        };

        System.out.println(sizeDescription.apply(5));
        System.out.println(sizeDescription.apply(50));
        System.out.println(sizeDescription.apply(500));
    }

}
