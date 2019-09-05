package com.aoffer.alibaba;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        int[] arr = new int[line.length];
        for(int i = 0; i < line.length; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        sort(arr);
    }

    public static void fun(){

    }
    public static int[] sort(int[] arr){
        int temp;
        for(int j = arr.length;j>0;j--){
            for(int i = 1;i<arr.length;i++){
                if(arr[i]>arr[i+1]){
                    temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
}
