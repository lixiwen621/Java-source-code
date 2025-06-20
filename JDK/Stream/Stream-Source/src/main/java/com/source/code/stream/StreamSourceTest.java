package com.source.code.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class StreamSourceTest {

    @Test
    public void createStream(){
        // 集合创建
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        Stream<String> stream = list.stream();
        System.out.println(stream);
        // 数组创建
        String[] array = {"Apple", "Banana", "Orange"};
        Stream<String> stream2 = Arrays.stream(array);
        System.out.println(stream2);
        // 使用 Stream.of 创建
        Stream<String> stream3 = Stream.of("Apple", "Banana", "Orange");
        // 生成无限流
        Stream<Integer> infiniteStream = Stream.generate(() -> 1).limit(10);
        List<Integer> integerList = infiniteStream.collect(Collectors.toList());
        System.out.println(integerList);

        // 生成有限流 初始值为0 后续每个元素是前一个元素 + 2
        Stream<Integer> finiteStream = Stream.iterate(0, n -> n + 2).limit(5);
        List<Integer> collected = finiteStream.collect(Collectors.toList());
        System.out.println(collected);

    }

    @Test
    public void filter(){
        Stream<String> stream = Stream.of("Apple", "Banana", "Orange");
        List<String> filterList = stream.filter(s -> s.length() > 4)
                .toList();
        System.out.println(filterList);
    }

    @Test
    public void map(){
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        List<Integer> integerList = list.stream().map(a -> a.length() * 2)
                .toList();
        System.out.println(integerList);

        List<String> words = Arrays.asList(" java ", " stream " );
        List<String> list2 = words.stream()
                .map(String::strip)
                .map(String::toUpperCase)
                .toList();
        System.out.println(list2);
    }

    @Test
    public void flatMap(){
        // 展开嵌套集合
        List<List<Integer>> nestedList = Arrays.asList(
          Arrays.asList(1,2),
          Arrays.asList(3,4)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);

        // 分割字符串为单词
        List<String> lines = Arrays.asList("Hello World", "Java Stream API");
        List<String> list = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .toList();
        System.out.println(list);

        // 合并多个流
        Stream<Integer> stream1 = Stream.of(5, 6);
        Stream<Integer> stream2 = Stream.of(7, 8);
        List<Integer> merged = Stream.of(stream1, stream2)
                //将每个 Stream 合并为一个流
                .flatMap(s -> s)
                .collect(Collectors.toList());

        System.out.println(merged);



    }
}
