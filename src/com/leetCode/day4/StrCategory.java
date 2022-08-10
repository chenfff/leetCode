package com.leetCode.day4;

import java.util.HashSet;

/**
 * @author chenfeng
 * @description 字符串分类
 * 快手一面
 * 如果两个字符串，所含字符串种类完全一样，就算作一类，比如：baacba和bac虽然长度不一样，但是所含字符的种类完全一样（abc）
 * 只由小写字母（a~z)组成的一批字符串，
 * 都放在字符类型数组String[] arr中，返回arr中一共有多少类？
 * @date 2022/08/10 17:27
 **/
public class StrCategory {

    public static void main(String[] args) {
        System.out.println(type2(new String[]{"baacba"}));
    }

    public static int type1(String[] arr) {
        HashSet<String> types = new HashSet<>();
        for (String str : arr) {
            char[] chars = str.toCharArray();
            boolean[] map = new boolean[26];
            for (int i = 0; i < chars.length; i++) {
                map[chars[i] - 'a'] = true;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (map[i]) {
                    key.append((char) (i + 'a'));
                }
            }
            types.add(key.toString());
        }
        return types.size();
    }

    public static int type2(String[] arr) {
        HashSet<Integer> types = new HashSet<>();
        for (String str : arr) {
            char[] chars = str.toCharArray();
            int key = 0;
            for (int i = 0; i < chars.length; i++) {
                key |= (1 << (chars[i] - 'a'));
            }
            types.add(key);
        }
        return types.size();
    }
}
