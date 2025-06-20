package com.source.string;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class StringSourceTest {

    @Test
    public void test(){
        CharSequence cs = "𝄞Music"; // 包含特殊字符𝄞
        cs.codePoints().forEach(cp -> System.out.println(Character.toChars(cp)));
    }

    @Test
    public void immutable(){
        String a = "hello";
        String b = a;
        // replace 就是修改后的字符串, 其实是在堆中新增了一个
        String replace = a.replace('h', 'l');
        System.out.println(replace);
        System.out.println(a);
        System.out.println(b);

    }

    @Test
    public void createString(){
        String a = "hello";
        String newHello = new String("hello");
        char[] charArray= {'h','e','l','l','o'};
        String newCharArrayString = new String(charArray);
        byte[] byteArray = {'b','y','t','e'};
        String newByteArrayString = new String(byteArray);
        int[] intArray = {'a','b','c'};
        String newIntArrayString = new String(intArray.toString());
        System.out.println(a);
        System.out.println(newHello);
        System.out.println(newCharArrayString);
        System.out.println(newByteArrayString);
        System.out.println(newIntArrayString);

    }

    @Test
    public void length(){
        String s = "Hello";
        System.out.println(s.length());
    }

    @Test
    public void rangeCheck(){
        char[] value = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        // 合法范围的调用
        rangeCheck(value,2,5);
        try {
            // 非法的范围调用
            rangeCheck(value,8,3);
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    /**
     *  该方法是检查char[]的索引或范围的合法性, 例如 offset 不能大于 value.length - count
     * @param value
     * @param offset
     * @param count
     * @return
     */
    private Void rangeCheck(char[] value, int offset, int count) {
        checkBoundsOffCount(offset, count, value.length);
        return null;
    }

    /**
     *  检查offset和count 的合理性和合法性
     * @param offset 偏移量
     * @param count
     * @param length
     */
    void checkBoundsOffCount(int offset, int count, int length) {
        if (offset < 0 || count < 0 || offset > length - count) {
            throw new StringIndexOutOfBoundsException(
                    "offset " + offset + ", count " + count + ", length " + length);
        }
    }

    @Test
    public void isEmpty(){
        String a = " ";
        System.out.println(a.isEmpty());
        System.out.println(a.isBlank());
    }

    /**
     *  字符串中 返回指定索引处的字符
     */
    @Test
    public void charAt(){
        String a = "hello";
        char c = a.charAt(0);
        System.out.println(c);
    }

    /**
     * codePointAt的到字符的 Unicode值 如 A -> 65
     */
    @Test
    public void codePointAt(){
        String a = "hello";
        String b = "a";
        int codePointAt = a.codePointAt(0);
        int bCodePointAt = b.codePointAt(0);
        System.out.println(codePointAt);
        System.out.println(bCodePointAt);
    }

    @Test
    public void codePointBefore(){
        String b = "ab";
        int codePointBefore = b.codePointBefore(1);
        int codePointAt = b.codePointAt(1);
        System.out.println(codePointBefore);
        System.out.println(codePointAt);
    }

    @Test
    public void codePointCount(){
        String b = "abc111";
        int codePointCount = b.codePointCount(0, 2);
        System.out.println(codePointCount);
    }

    /**
     *  字符串中 返回子字符串首次出现的索引
     */
    @Test
    public void indexOf(){
        String a = "hello";
        int index = a.indexOf("llo");
        System.out.println(index);
    }

    /**
     *  返回子字符串最后一次出现的索引
     */
    @Test
    public void lastIndexOf(){
        String a = "hello";
        int index = a.lastIndexOf("l");
        System.out.println(index);
    }

    @Test
    public void withBoolean(){
        String s = "hello worlds";
        // 是否以指定前缀开头
        boolean startsWith = s.startsWith("hello");
        // 是否以指定后缀结尾
        boolean endsWith = s.endsWith("hello");
        // 检查是否包含子字符串
        boolean contains = s.contains("hello");
        System.out.println(startsWith);
        System.out.println(endsWith);
        System.out.println(contains);
    }

    @Test
    public void sort(){
        String[] strings = {"banana", "apple", "cherry", "date"};
        Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        System.out.println(Arrays.toString(strings));
    }

    /**
     *  返回从指定索引开始的子字符串
     */
    @Test
    public void subString(){
        String a = "hello";
        // 返回从指定索引开始的子字符串
        String beginSubString = a.substring(2);
        System.out.println(beginSubString);
        // 返回指定范围的子字符串
        String rangeSubString = a.substring(0, 2);
        System.out.println(rangeSubString);
    }

    /**
     *  分割字符串, 也可以根据正则表达式分割字符串
     */
    @Test
    public void split(){
        String a = "my name is lixiwen";
        String b = "hello free worlds";
        String[] aSplit = a.split(" ");
        String[] bSplit = b.split(" ");
        System.out.println(Arrays.toString(aSplit));
        System.out.println(Arrays.toString(bSplit));
    }

    /**
     *  替换所有匹配的字符
     */
    @Test
    public void replace(){
        String a = "abacdgh";
        System.out.println(a.replace("a","l"));
        System.out.println(a.replaceFirst("a","l"));
        System.out.println(a.replace("ab","li"));
        String replaceAll = a.replaceAll("a", "l");
        System.out.println(replaceAll);
    }

    @Test
    public void replaceAll(){
        String str = "hello world 123";
        // 使用正则表达式替换数字 replaceAll 支持正则表达式转换
        System.out.println(str.replaceAll("\\d", "#")); // 输出: hello world ###
    }

    @Test
    public void equals(){
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    /**
     *  去除字符串两端的空白字符
     */
    @Test
    public void strip(){
        String s1 = " hello ";
        // 推荐使用 strip方法去掉空格, 因为strip是 去除字符串两端的 Unicode 空白字符
        System.out.println(s1.strip());
        String s2 = " world ";
        // 去除字符串两端的空白字符
        System.out.println(s2.trim());
    }

    /**
     *  检查是否包含子字符串
     */
    @Test
    public void content(){
        String s1 = "hello free world xiwen";
        // 检查是否包含子字符串
        boolean contains = s1.contains("xiwen");
        System.out.println(contains);
        boolean contentEquals = s1.contentEquals("hello free world xiwen");
        System.out.println(contentEquals);
        boolean startsWith = s1.startsWith("hello");
        System.out.println(startsWith);
    }

    /**
     *  将对象转换为字符串
     */
    @Test
    public void valueOf(){
        Integer a = 123;
        String valueOf = String.valueOf(a);
        System.out.println(valueOf);

        String s1 = "hello";
        System.out.println(s1.toCharArray());
        System.out.println(s1.getBytes());
    }

    /**
     * 将元素连接为一个字符串
     */
    @Test
    public void join(){
        String result = String.join(", ", "a", "b", "c");
        System.out.println(result);
    }

    /**
     *  格式化字符串
     */
    @Test
    public void format(){
        String name = "Alice";
        int age = 30;
        double salary = 12345.6789;

        String result = String.format("Name: %s, Age: %d, Salary: %.2f",name, age, salary);
        System.out.println(result);

        Date now = new Date();
        System.out.println(String.format("Year: %tY, Month: %tm, Day: %td", now, now, now));
        // 输出: Year: 2025, Month: 01, Day: 14
    }
}
