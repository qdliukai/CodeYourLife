package com.aoffer.liantong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitLine = line.split(" ");
        String[] res = bubleSort(splitLine);
        for(int i = 0; i < res.length-1; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println(res[res.length-1]);

    }
    public static String[] bubleSort(String[] arr){
        int length = arr.length;
        String tmp;
        for(int i = 0; i < length-1; i ++){
            for(int j = 0; j < length-1-i; j ++){
                int pre = Integer.parseInt(arr[j].split(":")[1]);
                int pos = Integer.parseInt(arr[j+1].split(":")[1]);
                if(pre < pos){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
