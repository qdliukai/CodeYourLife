package com.shousi;

public class QuickSort {

	public static void main(String[] args) {
        int[] arr = {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
	}
	
	public static void quickSort(int[] a, int startIndex, int endIndex) {
		//递归退出条件
		if(startIndex >= endIndex)	
			return;
		
		int temp;
		//pivotIndex中存的就是基准数
	    int pivotIndex = a[startIndex];
	    int left = startIndex;
	    int right = endIndex;
	    
	    //顺序很重要，要先从右边开始找
	    while(left != right) {
	    	while(a[right] >= pivotIndex && left < right)
	    		right--;
	    	while(a[left] <= pivotIndex && left < right)//再找右边的
	    		left++;       
	    	if(left < right)//交换两个数在数组中的位置
	    	{
	    		temp = a[left];
	    		a[left] = a[right];
	    		a[right] = temp;
	    	}
	    }
	    //最终将基准数归位
	    a[startIndex] = a[left];
	    a[left] = pivotIndex;
	    quickSort(a,startIndex, left-1);//继续处理左边的，这里是一个递归的过程
	    quickSort(a,left+1, endIndex);//继续处理右边的 ，这里是一个递归的过程
	}
}
