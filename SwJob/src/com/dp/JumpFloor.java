package com.dp;

public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(jumpFloor(10));
        System.out.println(jumpFloorDP(10));
    }
    // 递归实现
    public static int jumpFloor(int n)
    {
        if(n <= 0)
            return 0;
        if(n <= 2)
            return n;
        return jumpFloor(n-1) + jumpFloor(n-2);
    }
    // 动态规划实现
    public static int jumpFloorDP(int n){
        if(n <= 0)
            return 0;
        int f = 1;
        int g = 1;
        while(n-- != 0)
        {
            g = g + f;
            f = g - f;
        }
        return f;
    }
    //题目：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级......它也可以跳上n级。
    // 此时该青蛙跳上一个n级的台阶总共有多少种跳法？
    //
    //分析：用f(n)表示青蛙跳上n阶台阶的跳法数，设定f(0) = 1;
    //当n = 1 时，只有一种跳的方式，一阶跳，f(1) = 1
    //当n = 2 时，有两种跳的方式，一阶跳和两阶跳，f(2) = f(1) + f(0) = 2
    //当n = 3 时，有三种跳的方式，第一次跳出一阶后，后面还有f(3-1)中跳法；
    //                       第一次跳出二阶后，后面还有f(3-2)中跳法；
    //                       第一次跳出三阶后，后面还有f(3-3)中跳法，f(3) = f(2) + f(1) + f(0) = 4
    //当n = n 时，第一次跳出一阶后，后面还有f(n-1)中跳法；
    //           第一次跳出二阶后，后面还有f(n-2)中跳法......
    //           第一次跳出n阶后，后面还有 f(n-n)中跳法，即：
    //f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-n) = f(0) + f(1) + f(2) + ... + f(n-1)
    //又因为 f(n-1) = f(0) + f(2) + f(3) + ... + f(n-2)
    //两式相减得：f(n) = 2 * f(n-1)    ( n >= 2)
    //        |  0，n = 0
    //f(n) =  |  1, n = 1
    //        |  2 * f(n-1) , n >= 2
    public static int fun(int n)
    {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        int f = 1;
        for(int i = 2; i <= n; i++)
        {
            f = 2 * f;
        }
        return f;
    }
}
