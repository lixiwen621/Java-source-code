package com.source.string;

public class StringSourceTest {
    public void test(){
        CharSequence cs = "𝄞Music"; // 包含特殊字符𝄞
        cs.codePoints().forEach(cp -> System.out.println(Character.toChars(cp)));
    }

    public static void main(String[] args) {
        new StringSourceTest().test();
    }
}
