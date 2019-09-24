package com.aoffer.shenxinfu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int z = (int)Math.pow(2,n);
        int a[] = new int[z];
        for(int i = 0; i < z; i++){
            a[i] = sc.nextInt();
        }
        int b[][] = new int[m][2];
        for(int j = 0; j < m; j++){
            b[j][0] = sc.nextInt();
            b[j][1] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            int index = b[i][0];
            int value = b[i][1];
            a[index] = value;
            List<int[]> ints = Arrays.asList(a);
            for(int j = 0; j < z/2; j++){
                for(int k = 0; k < z; k++){

                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ; i < z-1; i++){
            int x = arrayList.get(i) | arrayList.get(i+1);
            arrayList.add(x);
        }
    }
}
