package com.zsearch;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1,3,5,7,9,11};
        int key = 9;
        int position = recursionBinarySearch(arr,key,0,arr.length - 1);

        //int position = commonBinarySearch(arr, key);
        if(position == -1){
            System.out.println("not found");
        }else{
            System.out.println("search: "+key+" ,position is: "+position);
        }
    }

    public static int recursionBinarySearch(int[] arr, int key, int low, int high){
        if(key < arr[low] || key > arr[high] || low > high)
            return -1;
        int middle = (low + high) / 2;
        if (arr[middle] > key)
            return recursionBinarySearch(arr, key, low, middle-1);
        else if (arr[middle] < key)
            return recursionBinarySearch(arr, key, middle + 1, high);
        else
            return middle;
    }

    public static int commonBinarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        int middle = 0;
        if(key < arr[low] || key > arr[high] || low > high)
            return -1;
        while (low <= high){
            middle = (low + high) / 2;
            if (arr[middle] > key)
                high = middle - 1;
            else if (arr[middle] < key)
                low = middle + 1;
            else
                return middle;
        }
        return -1;
    }
}
