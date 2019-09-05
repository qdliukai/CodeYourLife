package com.aoffer.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        ArrayList<Integer> arrList = new ArrayList<>();
        int mid = m * n / 2;
        if (k > mid) {
            for (int i = 1; i <= n; i++) {
                for (int j = m - i + 1; j >= 1; j--) {
                    arrList.add(i * j);
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = m; j >= m - i + 1; j--) {
                    arrList.add(i * j);
                }
            }
        }

        if (k > mid) {
            Collections.sort(arrList,new Comparator<Integer>() {
                @Override
                public int compare (Integer o1, Integer o2){
                    return o1 - o2;
                }
            });
            System.out.println(arrList.get(m*n-k));
        }else {
            Collections.sort(arrList,new Comparator<Integer>() {
                @Override
                public int compare (Integer o1, Integer o2){
                    return o2 - o1;
                }
            });
            System.out.println(arrList.get(k-1));
        }
    }

}
