package com.aoffer.vivo;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int res = isVaild(line);
        System.out.println(res);
    }

    public static int isVaild(String str){
        // 正确性判断
        if (0 == str.length())
            return 0;
        Stack<Character> stack = new Stack<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i<cs.length; i++){
            if (cs[i] == '(')
                stack.push(cs[i]);
            else {
                if (cs[i] == '0')
                    return stack.size();
                if (cs[i] == ')') {
                    char c = stack.pop();
                }
            }
        }
        return 0;
    }
}
