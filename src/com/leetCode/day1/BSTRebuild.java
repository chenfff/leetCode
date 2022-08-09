package com.leetCode.day1;

/**
 * 已知一个搜索二叉树后续遍历的数组posArr,请根据posArr，重建树的头节点
 * 搜索二叉树例子：
 * 5
 * / \
 * 3   7
 * / \ / \
 * 2  4 6  8
 * 左->右->头   [2,4,3,6,8,7,5]
 */
public class BSTRebuild {

    public static void main(String[] args) {
        System.out.println(posArrayToBST1(new int[]{2,4,3,6,8,7,5}));
    }


    public static Node posArrayToBST1(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    //目前，我们在使用posArr[L..R]这些数字来建树
    //建出的每一个节点都连好，然后把整棵树的头节点返回
    public static Node process1(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        //L <= R
        //[L...R] [R]
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        //L < R
        //[L...R-1]找到
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }

    public static Node process2(int[] posArr, int L, int R) {
        //L <= R
        //[L...R] [R]
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        //L < R
        //[L...R-1]找到
        int M = -1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        //>
        if (M == -1) {
            head.right = process2(posArr, L, R - 1);
        } else if (M == R - 1) {
            head.left = process2(posArr, L, R - 1);
        } else {
            head.left = process2(posArr, L, M);
            head.right = process2(posArr, M + 1, R - 1);
        }
        return head;
    }

    public static Node process(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        //L <= R
        //[L...R] [R]
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        //L < R
        //[L...R-1]找到
        int M = L - 1;
        int left = L;
        int right = R - 1;
        while (left <= right) {
            // mid = (L+R)/2
            // mid =  L+(R-L)/2
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R]) {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        head.left = process(posArr, L, M);
        head.right = process(posArr, M + 1, R - 1);
        return head;
    }

    static class Node {
        int head;
        Node left;
        Node right;

        public Node(int head) {
            this.head = head;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "head=" + head +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
