package com.aoffer.xiecheng;

import java.util.*;
public class Main3 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array, int low,int high) {
        if(low > high)
            return high+1;
        else {
            int mid=(low+high)/2;
            int sum = 0, group = 0, flag;
            for(int i = 0; i < array.length; i++){
                sum += array[i];
                if(sum > mid) {
                    sum = array[i];
                    group++;
                }
            }
            flag = group >= m ? 0 : 1;
            if(flag == 1)
                return schedule(m, array, low,mid-1);
            else
                return schedule(m, array,mid+1, high);
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int[] copy_array = array.clone();
        Arrays.sort(copy_array);
        int low = copy_array[0];
        int high = copy_array[copy_array.length-1];
        int res = schedule(m, array, low, high);
        System.out.println(String.valueOf(res));
    }
}
