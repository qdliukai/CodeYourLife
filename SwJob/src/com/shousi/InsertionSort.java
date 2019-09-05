package com.shousi;

public class InsertionSort {
    public static int[] insertionsort(int arr[]){
        int len = arr.length;
        int preIndex,current;
        int i;
        for(i = 1; i < len; i++){
            preIndex = i-1;
            current = arr[i];
            while (preIndex>=0 && arr[preIndex] > current){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] intput = new int[]{2,1,5,9,0,6,8,7,3};
        int[] result = insertionsort(intput);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
