package com.dp;

public class Knapsack {
    //          B(k-1,c);  当物品太重拿不下时，即w[k] > c
    // B(k,c) =     B(k-1, c-w[k]);  拿
    //          max B(k-1, c);       不拿
    //
    public static void main(String[] args) {
        int[] w = {0, 4, 6, 2, 2, 5, 1};
        int[] v = {0, 8, 10, 6, 3, 7, 2};
        int N = 7, W = 13;
        int[][] dp = new int[N][W];
        for(int k = 1; k < N; k++){
            for(int c = 1; c < W; c++){
                if (w[k] > c)
                    dp[k][c] = dp[k-1][c];
                else {
                    int value1 = dp[k-1][c-w[k]] + v[k];
                    int value2 = dp[k-1][c];
                    dp[k][c] = Math.max(value1, value2);
                }
            }
        }
        System.out.println(dp[6][12]);
    }
}
