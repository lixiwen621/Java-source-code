package com.source.function.supplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class SupplierTest {

    /**
     *  Lazy loading
     *  The optionalObject will not be loaded until it meets the orElseGet condition.
     *  在 optionalObject没有满足orElseGet条件前是不会加载的
     *
     */
    @Test
    public void supplierExample(){
        Optional<String> optionalObject = Optional.empty();

        Supplier<String> defaultSupplier = () -> {
            System.out.println("Providing default value");
            return "defaultValue";
        };

        String result = optionalObject.orElseGet(defaultSupplier);
        System.out.println(result);

        Supplier<String> stringSupplier = () -> "Stream Element";

        Stream.generate(stringSupplier)
                .limit(5)
                .forEach(System.out::println);
    }

}
