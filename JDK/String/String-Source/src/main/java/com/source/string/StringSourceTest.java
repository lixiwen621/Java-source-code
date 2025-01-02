package com.source.string;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StringSourceTest {

    @Test
    public void test(){
        CharSequence cs = "𝄞Music"; // 包含特殊字符𝄞
        cs.codePoints().forEach(cp -> System.out.println(Character.toChars(cp)));
    }


}
