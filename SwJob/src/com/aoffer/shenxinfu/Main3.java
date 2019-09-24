package com.aoffer.shenxinfu;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int t=n;
        BigInteger res=new BigInteger("1");
        for(int i=2;i<=n;i++ ){
            String tp=""+i;
            BigInteger res1=new BigInteger(tp);
            res=res.multiply(res1);

        }
        System.out.println(res);
        in.close();//用了vscode才知道这里要关上QAQ
    }
}
