package com.shousi;

public class SelectionSort {
    public static int[] selectionSort(int arr[]){
        int len = arr.length;
        int minIndex,temp;
        int i,j;
        for(i = 0; i < len-1; i++){
            minIndex = i;
            for(j = i+1; j<len; j++){
                if(arr[j] < arr[minIndex]){ //寻找最小的数
                    minIndex = j;       //将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
