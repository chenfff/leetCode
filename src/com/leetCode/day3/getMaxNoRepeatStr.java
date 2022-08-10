package com.leetCode.day3;

/**
 * 美团面试
 * 给定一个只由小写字母（a~z)组成的字符串str,返回其中最长无重复字符的子串长度。
 */
public class getMaxNoRepeatStr {
    public static void main(String[] args) {
        System.out.println(lnrs("zxzcv"));
    }

    public static int lnrs(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        //last[0] --> a 上次出现的位置
        //last[1] --> b 上次出现的位置
        //last[2] --> c 上次出现的位置
        //...
        //last[25] --> z 上次出现的位置
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            //初始化表示1次都没有出现
            last[i] = -1;
        }
        //第一个字母出现的位置为0
        last[str[0] - 'a'] = 0;
        int max = 1;
        //dp[i-1] 的值
        int preMaxLen = 1;
        for (int i = 1; i < N; i++) {
            preMaxLen = Math.min(i - last[str[i] - 'a'],  + 1);
            max = Math.max(max, preMaxLen);
            last[str[i] - 'a'] = i;
        }
        return max;
    }

}
