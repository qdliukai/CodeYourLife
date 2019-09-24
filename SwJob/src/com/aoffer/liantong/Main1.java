package com.aoffer.liantong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(zuoti(n));
    }

    public static int zuoti(int n){
        if(n <= 0)
            return 0;
        if(n <= 2)
            return n;
        int a = 1, b = 2;
        int temp = 0;
        for(int i = 3; i <= n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
