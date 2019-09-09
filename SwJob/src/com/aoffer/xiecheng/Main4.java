package com.aoffer.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[255][10];
        for (int i = 0; i < 255; i++) {
            Arrays.fill(arr[i], 0);
        }
        for (int i = 0; i < 255; i++) {
            arr[i][1] = 1;
        }
        for (int i = 2; i < 255; i++) {
            for (int j = 1; j < 10; j++) {
                if (j > i) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i - j][j] + arr[i - 1][j - 1];
                }
            }
        }
        System.out.println(arr[n][k]);
    }
}