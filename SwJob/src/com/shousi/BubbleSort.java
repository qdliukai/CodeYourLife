package com.shousi;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        int temp = 0;
        for(int i = 0; i < len-1; i++){
            for(int j = 0; j < len-1-i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] intput = new int[]{2,1,5,9,0,6,8,7,3};
        int[] result = bubbleSort(intput);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
