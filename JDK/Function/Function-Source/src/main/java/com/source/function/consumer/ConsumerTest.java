package com.source.function.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.function.Consumer;

@ExtendWith(MockitoExtension.class)
public class ConsumerTest {

    @Test
    public void consumerTest(){
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLength = s -> System.out.println("Length: "+s.length());

        Consumer<String> combined = printUpperCase.andThen(printLength);
        combined.accept("hello");

    }

    @Test
    public void foreachList(){
        List<String> nameList = List.of("zhangsan","Bob","lixiwen","wangDa");
        Consumer<String> printName = name -> System.out.println("Name: "+name);
        nameList.forEach(printName);

    }

    @Test
    public void handlePersonExample(){
        Person person = new Person("Tong",25);
        Consumer<Person> increaseAge = p -> p.age+=1;
        Consumer<Person> printInfo = p -> System.out.println(p.name + " is now " + p.age);
        increaseAge.andThen(printInfo).accept(person);
    }

    @Test
    public void handleConsumerException(){
        Consumer<String> safePrint = s -> {
            try {
                System.out.println(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + s);
            }
        };

        safePrint.accept("123"); // 输出：123
        safePrint.accept("abc"); // 输出：Invalid number: abc
    }


}
