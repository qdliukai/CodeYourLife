package com.dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(diguiFibo(6));
        System.out.println(sum_diguiFibo(6));
        System.out.println(solutionFibonacci(6));
    }

    public static int diguiFibo(int n){
        if(n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return diguiFibo(n-1) + diguiFibo(n-2);
        }
    }
    public static int beiwangluFibo(int n){
        if(n < 1)
            return 0;
        return 0;
    }

    public static int sum_diguiFibo(int n){
        int sum = 0;
        for(int i=1;i<=n;i++) {
            sum += diguiFibo(i);  //累加前n项
        }
        return sum;
    }

    public static int solutionFibonacci(int n){
        int sum = 0;
        if(n == 0){
            System.out.println(sum);
            return 0;
        }
        else if(n == 1) {
            sum = 1;
            System.out.println(sum);
            return 1;
        }
        else {
            sum = 1;
            int result[] = new int[n+1];
            result[0] = 0;
            result[1] = 1;
            for(int i=2; i <= n; i++){
                result[i] = result[i-1] + result[i-2];
                sum += result[i];
            }
            System.out.println(sum);
            return result[n];
        }
    }
}
