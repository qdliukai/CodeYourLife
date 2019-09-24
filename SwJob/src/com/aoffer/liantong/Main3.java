package com.aoffer.liantong;

public class Main3 {
    public static void main(String[] args) {
        int i = 0, j = 0, sum = 0;
        for( ;i < 100; i++){
            for(; j < i; j++){
                sum = i+j;
            }
        }
        System.out.println(sum);
    }
}
