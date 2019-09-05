package com.zsort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 56, 23, 45, 19, 99, 78, 89, 10, 2};
        mergeSort1(arr, 0, arr.length-1);
        for (int anInt : arr) {
            System.out.println(anInt);
        }
    }

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

    public static int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {    // 寻找最小的数
                    minIndex = j;                // 将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static void quickSort(int[] a, int startIndex, int endIndex) {
        // 递归退出条件
        if(startIndex >= endIndex)
            return;

        int temp;
        // pivotIndex中存的就是基准数
        int pivotIndex = a[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 顺序很重要，要先从右边开始找
        while(left != right) {
            while(a[right] >= pivotIndex && left < right)
                right--;
            while(a[left] <= pivotIndex && left < right) // 再找右边的
                left++;
            if(left < right)// 交换两个数在数组中的位置
            {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        // 最终将基准数归位
        a[startIndex] = a[left];
        a[left] = pivotIndex;
        quickSort(a,startIndex, left-1);// 继续处理左边的，这里是一个递归的过程
        quickSort(a,left+1, endIndex);// 继续处理右边的，这里是一个递归的过程
    }

    public static void fun(int[] a, int startIndex, int endIndex){
        if(startIndex >= endIndex)
            return;
        int temp;
        int pivot = a[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (a[right] >= pivot && left < right)
                right--;
            while (a[left] <= pivot && left < right)
                left++;
            if(left < right){
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        a[startIndex] = a[left];
        a[left] = pivot;
        quickSort(a, startIndex, left-1);
        quickSort(a, left+1, endIndex);

    }




    private static void mergeSort(int[] arr, int start, int end) {
        // 代表已经拆分到不可再拆了
        if (start>=end){
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(arr,start,middle);
        mergeSort(arr,middle+1,end);
        merge(arr,start,middle,end);
    }
    private static void merge(int[] arr, int start, int middle, int end) {
        // 临时数组的下标索引
        int index = 0;
        int[] tempArr = new int[end - start + 1];
        int s = start;
        int se = middle;
        int m = middle + 1;
        int me = end;

        // s<=se即第一个待排序数组,m<=me即第二个待排序数组,可以看代码变量说明图
        while (s<=se && m<=me){
            // 即第一个待排序数组和第二个待排序数组开始比较
            if (arr[s] < arr[m]){
                // 如果s比较小,那么就赋值给临时数组,然后将s边的数组索引往后移一位
                tempArr[index++] = arr[s++];
            }else {
                // 到这就算m边比较小了,那么就赋值给临时数组,然后将m边的数组索引往后移一位
                tempArr[index++] = arr[m++];
            }
        }
        // 下面这两个循环,代表如果切分的不是五五开,比如一边有4个元素一边有3个元素,然而上面的循环只能是比较
        // 两边元素的前三个,而会有一个剩余的没有添加进来,所以下面循环是来判断不是五五开的情况的
        while (s<=se){
            tempArr[index++] = arr[s++];
        }
        while (m<=me){
            tempArr[index++] = arr[m++];
        }
        // 到这了,那么这次的两个待排序数组就已经排序完毕,已经放入tempArr里面了.
        // 我们的方法的参数start代表了这次数组比较的开始,所以我们还必须将整个tempArr里面的元素
        // 倒入进arr里,开始就是start位置
        for (int i = 0; i < index; i++) {
            arr[start+i] = tempArr[i];
        }
    }

    public static void mergeSort1(int[] arr, int start, int end){
        if(start >= end)
            return;
        int middle = (start + end) / 2;
        mergeSort1(arr, start, middle);
        mergeSort1(arr, middle+1, end);
        merge1(arr, start, middle, end);
    }

    public static void merge1(int[] arr, int start, int middle, int end){
        int[] tempArr = new int[end - start + 1];
        int index = 0;
        int s = start;
        int se = middle;
        int m = middle + 1;
        int me = end;
        while (s <= se && m <= me){
            if(arr[s] < arr[m])
                tempArr[index++] = arr[s++];
            else
                tempArr[index++] = arr[m++];
        }
        while (s <= se)
            tempArr[index++] = arr[s++];
        while (m <= me)
            tempArr[index++] = arr[m++];
        for(int i = 0; i < index; i++)
            arr[start + i] = tempArr[i];
    }
}
