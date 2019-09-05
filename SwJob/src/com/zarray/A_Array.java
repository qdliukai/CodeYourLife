package com.zarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A_Array {

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 1};
//        int[] res = twoSum(nums, 3);
//        for (int i : res){
//            System.out.print(nums[i] + " ");
//        }
//        int[][] twoArr = {{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}};
//        searchMatrix(twoArr, 3);

    }

    // 1、两数之和，给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
    // nums = [2, 7, 11, 15], target = 9
    // nums[0] + nums[1] = 9, 所以返回[0, 1]
    public static int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                res[0]= map.get(target-numbers[i]);
                res[1]= i;
                break;
            }
        }
        return res;
    }

    // 2、搜索二维矩阵
    // 每行中的整数从左到右按升序排列，每行的第一个整数大于前一行最后一个整数
    public static boolean searchMatrix(int[][] matrix, int target){
        // 正确性判断
        if (null == matrix || 0 == matrix.length)
            return false;
        if (null == matrix[0] || 0 == matrix[0].length)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            int number = matrix[mid / col][mid % col];
            System.out.println(mid/col + "--" + mid % col);
            if(number == target) {
                return true;
            }
            else if (number > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }


}
