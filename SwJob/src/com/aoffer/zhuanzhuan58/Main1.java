package com.aoffer.zhuanzhuan58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n-1; i++){
            if (arr[i] > arr[i-1]){
                res[i] = res[i-1]+1;
            }else if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                res[i] = 1;
            }else if(arr[i] < arr[i-1] && arr[i] > arr[i+1]){
                res[i] = 2;
            }else if(arr[i] == arr[i-1]){
                res[i] = res[i-1];
            }
        }
        if (arr[n-1] < arr[n-2]){
            res[n-1] = 1;
        }else if (arr[n-1] > arr[n-2]){
            res[n-1] = res[n-2] + 1;
        }else {
            res[n-1] = res[n-2];
        }
        int count = 0;
        for(int i =0; i< n; i++){
            count+=res[i];
        }
        System.out.println(count);
    }
}
