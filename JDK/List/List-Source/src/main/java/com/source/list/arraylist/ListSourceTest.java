package com.source.list.arraylist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ListSourceTest {

    /**
     *  元素添加
     */
    @Test
    public void add(){
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add(1,"worlds");
        System.out.println(stringList);
    }

    /**
     *  元素获取
     */
    @Test
    public void get(){
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("rock");
        stringList.add("apple");

        System.out.println(stringList.get(1));
        System.out.println(stringList.indexOf("apple"));
        System.out.println(stringList.lastIndexOf("apple"));
    }

    /**
     *  修改元素
     */
    @Test
    public void set(){
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("rock");
        stringList.add("apple");

        // List集合在循环的时候可以 set
        for (int i=0; i<stringList.size(); i++){
            stringList.set(i,stringList.get(i)+"s");
        }

        System.out.println(stringList);
    }

    /**
     *  移除元素
     */
    @Test
    public void remove(){
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("rock");
        stringList.add("apple");

        // 循环删除, 避免使用remove，请使用removeIf
        for (int i=0; i<stringList.size(); i++){
            stringList.removeIf( a-> a.startsWith("a"));
        }

        System.out.println(stringList);
    }

    @Test
    public void remove2(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // 使用 for 循环直接删除元素
        for (int i = 0; i < list.size(); i++) {
            if ("banana".equals(list.get(i))) {
                list.remove(i); // 删除元素
            }
        }

        System.out.println(list); // 输出可能不符合预期
    }

    @Test
    public void remove3(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // 使用增强 for 循环删除元素
        for (String item : list) {
            if ("banana".equals(item)) {
                list.remove(item); // 导致 ConcurrentModificationException
            }
        }
    }

    @Test
    public void remove4(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("banana".equals(item)) {
                iterator.remove(); // 使用 Iterator 的 remove 方法
            }
        }

        System.out.println(list); // 输出: [apple, cherry]
    }

    @Test
    public void foreach(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        // 增强 for
        for (String item: list){
            System.out.println(item);
        }

        //使用迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

    }

    @Test
    public void checkList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        // list 集合中的包含
        System.out.println(stringList.contains("apple"));
        System.out.println(stringList.isEmpty());
        System.out.println(stringList.size());
    }

    @Test
    public void subList(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        List<String> subList = list.subList(1, 3);  // 索引 1 到 3 的子列表
        System.out.println(subList);  // 输出: [banana, cherry]
        System.out.println(list == subList);
    }

    @Test
    public void listToArray(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        String[] stringArray = list.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));

    }

    @Test
    public void listSort(){
        List<String> list = new ArrayList<>();
        list.add("bananas");
        list.add("apple");
        list.add("cherry");
        Comparator<String> comparator = (s1,s2) -> Integer.compare(s1.length(),s2.length());
        list.sort(Comparator.naturalOrder()); //按字典顺序
        System.out.println(list);
        list.sort(Comparator.reverseOrder()); // 排倒序
        System.out.println(list);
        list.sort(comparator); // 按照比较器排序
        System.out.println(list);
    }

    /**
     *  清空方法
     */
    @Test
    public void clear(){
        List<String> list = new ArrayList<>();
        list.add("lixiwen");
        list.add("lixin");
        list.clear();
        System.out.println(list);
    }

    /**
     *   返回指定元素第一次出现的索引
     */
    @Test
    public void indexOf(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("Bob");

        int index = list.indexOf("Bob");
        System.out.println(index);
    }

    /**
     *  返回指定元素最后一次出现的索引
     */
    @Test
    public void lastIndexOf(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");

        int lastIndexOf = list.lastIndexOf("apple");
        System.out.println(lastIndexOf);
    }


}
