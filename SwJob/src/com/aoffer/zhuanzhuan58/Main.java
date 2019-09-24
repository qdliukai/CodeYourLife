package com.aoffer.zhuanzhuan58;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(lines[j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    arr[i][j] += arr[i][j - 1];
                } else if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else {
                    int min = Math.min(arr[i][j - 1], arr[i - 1][j]);
                    arr[i][j] += min;
                }
            }
        }
        System.out.println(arr[arr.length - 1][arr[0].length - 1]);
    }
}
