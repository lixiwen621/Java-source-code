package com.source.function.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@ExtendWith(MockitoExtension.class)
public class BiConsumerTest{

    @Test
    public void foreachMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Alice",25);
        map.put("Bob",30);
        map.put("Charlie",31);

        BiConsumer<String,Integer> printEntry = (key,value) ->
                System.out.println("Key: "+key+ ", value" + value);

        map.forEach(printEntry);
    }

    @Test
    public void handleItemPrice(){
        Map<String, Double> cart = new HashMap<>();
        cart.put("Apple", 1.99);
        cart.put("Banana", 0.99);
        cart.put("Cherry", 2.99);
        // 累加总价
        final double[] totalPrice = {0.0};
        BiConsumer<String,Double> calculateTotal = (item,price)-> totalPrice[0] +=price;
        //打印商品
        BiConsumer<String,Double> printItemInfo = (item,price)->
                System.out.println("Name: "+item+ ", Price"+price);

        cart.forEach(printItemInfo.andThen(calculateTotal));
        // 打印总价
        System.out.println("Total Price: $"+ totalPrice[0]);
    }

}
