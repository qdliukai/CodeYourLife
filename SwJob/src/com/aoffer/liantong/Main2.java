package com.aoffer.liantong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splitLine = sc.nextLine().split(",");
        int[] money = new int[splitLine.length];
        for(int i = 0; i < splitLine.length; i++){
            money[i] = Integer.parseInt(splitLine[i]);
        }
        int[] res = saveMoney(money);
        for(int i = 0; i < res.length-1; i++){
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length-1]);
    }

    public static int[] saveMoney(int[] money) {
        int len = money.length;
        int[] arr = new int[len + 1];
        int i;
        for (i = 0; i < len; i++) {
            arr[i+1] = money[i];
        }
        arr[i] = ++money[i-1];
        if (arr[i] > 9) {
            for (int j = arr.length - 1; j > 0 ; j--) {
                if (arr[j] > 9) {
                    arr[j] %= 10;
                    arr[j-1] += 1;
                }
            }
            if (arr[0] == 0) {
                int[] x = new int[len];
                for (int j = 0; j < x.length; j++) {
                    x[j] = arr[j+1];
                }
                return x;
            }
            return arr;
        }
        else
            return money;
    }
}
