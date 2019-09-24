package com.aoffer.guanglianda;

import sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 extends Sort {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int[] src = {string.charAt(0) - '0'};
        int[] dec = null;
        for(int i=0;i<string.length();i++){
            int find = string.charAt(i) - '0';
            int index = binarySearch(src, find,0, src.length - 1);
            if (index != -1) {
                System.out.println("index is :" + index + " value is :" + src[index]);
                continue;
            } else {
                dec = searchInsert(src, find);
                src = dec;
            }
        }
        printArray(src);
    }

    private static int[] searchInsert(int[] src, int i) {
        int left = 0;
        int right = src.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (src[middle] < i) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        int[] dec = Arrays.copyOf(src, src.length + 1);
        int decL = dec.length - 1;
        while (decL >= left) {
            if (decL == left) {
                dec[left] = i;
                break;
            }
            dec[decL] = dec[decL - 1];
            decL--;
        }
        return dec;
    }

    private static int binarySearch(int[] src, int i, int left, int right) {
        while (left <= right) {
            int middle = (right + left) / 2;
            if (src[middle] == i) {
                return middle;
            } else if (src[middle] < i) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void printArray(int[] src){
        System.out.println();
        for(int i=0;i<src.length;i++){
            System.out.print(src[i]);
        }
    }
}
