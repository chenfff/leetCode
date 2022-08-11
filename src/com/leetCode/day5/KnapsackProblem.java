package com.leetCode.day5;

/**
 * @author chenfeng
 * @description 背包问题
 * @date 2022/08/11 09:00
 **/
public class KnapsackProblem {

    public static void main(String[] args) {
        //物品重量
        int[] w = new int[]{1, 4, 3};
        //物品价格
        int[] val = new int[]{1500, 3000, 2000};
        //背包容量
        int m = 4;
        //物品个数
        int n = val.length;

        System.out.println(solution2(n, m, w, val));

        //记录前i个物品中能够装入容量为j的背包中的最大值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                //w[i-1]：第i个物品的数组下标为i-1，当第i个物品的重量大于背包容量，表示装不下这个物品，因此最大值为v[i-1][j]
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //val[i-1] + v[i-1][j-w[i-1]]:表示装入第i-1个物品的价值加上剩余空间能够装的最大价值
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //标记该物品加入背包，便于查看那些物品加入背包
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }

        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();

        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        //回溯输出加入背包的物品
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品加入背包！");
                j = j - w[i - 1];
            }
            i--;
        }
    }


    public static int solution(int N, int W, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }
        return dp[N][W];
    }

    public static int solution2(int N, int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }

        return dp[W];
    }
}


