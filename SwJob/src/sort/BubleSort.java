package sort;

public class BubleSort {
    public static int[] bubleSort(int[] arr){
        int length = arr.length;
        int tmp;
        for(int i = 0; i < length-1; i ++){
            for(int j = 0; j < length-1-i; j ++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
