package com.source.list.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;

@ExtendWith(MockitoExtension.class)
public class LinkedListSourceTest {

    @Test
    public void linkedListExample(){
        // 1. 创建一个空的 LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // 2. 向 LinkedList 中添加元素
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        linkedList.add("Mango");

        System.out.println("初始 LinkedList: " + linkedList); // 输出: [Apple, Banana, Orange, Mango]

        // 3. 在特定位置插入元素
        linkedList.add(2, "Pineapple"); // 将 "Pineapple" 插入到索引 2 位置
        System.out.println("插入元素后的 LinkedList: " + linkedList); // 输出: [Apple, Banana, Pineapple, Orange, Mango]

        // 4. 删除 LinkedList 中的元素
        linkedList.remove("Banana"); // 删除元素 "Banana"
        System.out.println("删除元素后的 LinkedList: " + linkedList); // 输出: [Apple, Pineapple, Orange, Mango]
        linkedList.pop();

        // 5. 删除指定位置的元素
        linkedList.remove(1); // 删除索引为 1 的元素（Pineapple）
        System.out.println("删除指定位置后的 LinkedList: " + linkedList); // 输出: [Apple, Orange, Mango]

        // 6. 获取 LinkedList 中的元素
        String element = linkedList.get(1); // 获取索引为 1 的元素（Orange）
        System.out.println("索引为 1 的元素: " + element); // 输出: Orange

        // 7. 查找元素是否存在
        boolean contains = linkedList.contains("Mango"); // 检查元素 "Mango" 是否存在
        System.out.println("LinkedList 是否包含 'Mango'?: " + contains); // 输出: true

        // 8. 遍历 LinkedList
        System.out.println("通过 for-each 遍历 LinkedList:");
        for (String fruit : linkedList) {
            System.out.println(fruit); // 输出: Apple, Orange, Mango
        }

        // 9. 清空 LinkedList
        linkedList.clear(); // 清空所有元素
        System.out.println("清空后的 LinkedList: " + linkedList); // 输出: []
    }
}
