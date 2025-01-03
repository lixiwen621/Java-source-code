package com.source.function.supplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
public class BooleanSupplierTest {

    @Test
    public void supplierExample(){
        BooleanSupplier booleanSupplier = () -> {
            System.out.println("getBoolean");
            return 10 % 2 == 0;
        };

        System.out.println(booleanSupplier.getAsBoolean());
    }


}
