package com.source.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class ArraysSourceTest {

    @Test
    public void createOneDimensionArray(){
        int[] b = {2,3,4,5};
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        System.out.println(Arrays.toString(a));


        System.out.println(Arrays.toString(b));

        int[] c = new int[]{3,4,5,6};
        System.out.println(Arrays.toString(c));
    }

    @Test
    public void createTwoDimensionArray(){
        int[][] a = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        System.out.println(Arrays.deepToString(a));

        int[][] b = new int[3][3];
        for(int i=0; i< b.length; i++){
            for (int j=0; j< b[i].length; j++){
                b[i][j] = i;
            }
        }
        System.out.println(Arrays.deepToString(b));
    }

    @Test
    public void createTwoDimensionArray2(){
        int[][] a = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        System.out.println(Arrays.deepToString(a));

        int[][] b = new int[3][3];
        for(int i=0; i< b.length; i++){
            Arrays.fill(b[i], 0,3,1);
        }
        System.out.println(Arrays.deepToString(b));
    }

    @Test
    public void fill(){
        int[] arr = new int[6];
        Arrays.fill(arr,20);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,0,2,10);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void sort(){
        int[] arr = {5, 3, 8, 1, 2};
        // 转换为 Integer 数组
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // 按降序排序
        Arrays.sort(boxedArr, Collections.reverseOrder());
        char[] chars = {'b','d','c','a'};
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        System.out.println(Arrays.toString(boxedArr));

    }

    @Test
    public void sort2(){
        int[] arr = {5, 3, 8, 1, 2};
        Integer[] sortedArr =  Arrays.stream(arr)
                .boxed()
                .sorted((a1,a2) -> Integer.compare(a2,a1))
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(sortedArr));
    }

    public void test(){
        char[] arr = {'a','b'};

    }
}
