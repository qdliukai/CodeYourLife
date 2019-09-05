package com.aoffer.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        // 正确性判断
        if (0 == expr.length())
            return "";
        if (expr.length() % 2 == 1)
            return "";
        Stack<Character> stack = new Stack<>();
        char[] cs = expr.toCharArray();
        char c = 'c';
        StringBuilder sb = new StringBuilder();
        StringBuilder ssb = new StringBuilder();
        int flag = 0;
        for (int i = 0; i<cs.length; i++){
            if (cs[i] == '(') {
                flag = 1;
                stack.push(cs[i]);
            }
            else {
                if (flag == 0){
                    ssb.append(cs[i]);
                }else {

                    if (stack.isEmpty())
                        return sb.toString();
                    if(cs[i] == ')'){
                        c = stack.pop();
                    }
                    if ((cs[i] == ')' && c == '(')) {
                        sb = sb.reverse();
                    } else {
                        sb.append(cs[i]);
                    }
                }
            }
        }
        StringBuilder append = ssb.append(sb);
        return append.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
