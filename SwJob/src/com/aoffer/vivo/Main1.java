package com.aoffer.vivo;

import java.io.*;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */

public class Main1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        int len = input.length;
        for(int i = 0; i < len; i++){
            int count = 1;
            for(int j = i+1; j<len; j++){
                if(input[i] == input[j]){
                    count++;
                }
            }
        }
        return -1;
    }
}