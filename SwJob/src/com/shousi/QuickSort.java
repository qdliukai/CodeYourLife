package com.shousi;

public class QuickSort {

	public static void main(String[] args) {
        int[] arr = {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("�����:");
        for (int i : arr) {
            System.out.println(i);
        }
	}
	
	public static void quickSort(int[] a, int startIndex, int endIndex) {
		//�ݹ��˳�����
		if(startIndex >= endIndex)	
			return;
		
		int temp;
		//pivotIndex�д�ľ��ǻ�׼��
	    int pivotIndex = a[startIndex];
	    int left = startIndex;
	    int right = endIndex;
	    
	    //˳�����Ҫ��Ҫ�ȴ��ұ߿�ʼ��
	    while(left != right) {
	    	while(a[right] >= pivotIndex && left < right)
	    		right--;
	    	while(a[left] <= pivotIndex && left < right)//�����ұߵ�
	    		left++;       
	    	if(left < right)//�����������������е�λ��
	    	{
	    		temp = a[left];
	    		a[left] = a[right];
	    		a[right] = temp;
	    	}
	    }
	    //���ս���׼����λ
	    a[startIndex] = a[left];
	    a[left] = pivotIndex;
	    quickSort(a,startIndex, left-1);//����������ߵģ�������һ���ݹ�Ĺ���
	    quickSort(a,left+1, endIndex);//���������ұߵ� ��������һ���ݹ�Ĺ���
	}
}
