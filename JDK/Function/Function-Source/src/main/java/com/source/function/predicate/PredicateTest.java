package com.source.function.predicate;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PredicateTest {

    @Test
    public void dataFilter(){
        List<String> names = List.of("Tom","Jerry","Anna");
        Predicate<String> lengthGreaterThanThree = name -> name.length() > 3;

        List<String> stringList = names.stream()
                .filter(lengthGreaterThanThree)
                .collect(Collectors.toList());

        System.out.println(stringList);
    }

    @Test
    public void validUsername(){
        Predicate<String> isValidUsername = username -> !username.isBlank() && username.length() > 3;
        System.out.println(isValidUsername.test("Alice"));
        System.out.println(isValidUsername.test("Bob"));
        Predicate.isEqual("lixiwen");
    }

    @Test
    public void conditionCompound(){
        Predicate<Integer> isInRange = num -> num >= 10 && num <= 20;
        Predicate<Integer> isEven = num -> num % 2 == 0;

        Predicate<Integer> isInRangeAndEven = isInRange.and(isEven);
        System.out.println(isInRangeAndEven.test(12));
        System.out.println(isInRangeAndEven.test(25));
    }

    @Test
    public void processStream(){
        List<Integer> numbers = List.of(-1,0,3,5,-10);
        Predicate<Integer> isPositive = num -> num > 0;

        List<Integer> positiveList = numbers.stream()
                .filter(isPositive)
                .collect(Collectors.toList());

        System.out.println(positiveList);
    }

    @Test
    public void checkUserPermission(){
        User user = new User("Alice",List.of("ADMIN","USER"));
        Predicate<User> isAdmin = u -> u.hasRole("ADMIN");
        System.out.println(isAdmin.test(user));
    }

    @Test
    public void dataMonitoring(){
        DoublePredicate isHighCpuUsage = usage -> usage > 0.9;
        System.out.println(isHighCpuUsage.test(0.95));
        System.out.println(isHighCpuUsage.test(0.85));
    }

    @Test
    public void isEqualsPredicate(){
        Predicate<String> isHello = Predicate.isEqual("Hello");

        System.out.println(isHello.test("Hello")); // 输出：true
        System.out.println(isHello.test("World")); // 输出：false
        System.out.println(isHello.test(null));    // 输出：false
    }

    @Test
    public void notPredicate(){
        Predicate<Integer> isEvenNumber = num-> num %2 == 0;
        Predicate<Integer> not = Predicate.not(isEvenNumber);
        System.out.println(isEvenNumber.test(4));
        System.out.println(not.test(4));

        IntPredicate isEven = num -> num %2 == 0;
        IntPredicate negate = isEven.negate();
        System.out.println(isEven.test(4));
        System.out.println(negate.test(4));
    }
}
