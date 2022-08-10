package com.leetCode.day2;

import java.util.Arrays;

/**
 * 阿里面试
 * 输入一个int类型的值N，构造一个长度为N的数组arr并返回要求：对于任意的i<k<j,都满足arr[i] + arr[j] != arr[k] * 2
 */
public class ArrayBuild {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(build(5)));
    }

    public static int[] build(int size) {
        if (size == 1) {
            return new int[]{1};
        }
        int halfSize = (size + 1) / 2;
        int[] base = build(halfSize);
        int[] arr = new int[size];
        int index = 0;
        //构建左边一半的奇数队列
        for (; index < halfSize; index++) {
            arr[index] = base[index] * 2 + 1;
        }
        //构建右边一半偶数队列
        for (int i = 0; index < size; i++, index++) {
            arr[index] = base[i] * 2;
        }

        return arr;
    }
}
