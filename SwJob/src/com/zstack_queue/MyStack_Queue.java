package com.zstack_queue;

import java.util.LinkedList;
import java.util.Stack;

public class MyStack_Queue {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.empty();
        if (isVaild("{[()]}"))
            System.out.println("yes");
    }

    // 1、有效括号
    // 给定一个包括(){}[]的字符串，判断字符串是否有效
    // 要求：左括号必须用相同类型的右括号闭合，左括号必须以正确的顺序闭合
    // （）true，{()}true
    public static boolean isVaild(String s){
        // 正确性判断
        if (0 == s.length())
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i<cs.length; i++){
            if (cs[i] == '(' || cs[i] == '[' || cs[i] == '{')
                stack.push(cs[i]);
            else {
                if (stack.isEmpty())
                    return false;
                char c = stack.pop();
                if ((cs[i] == ')' && c == '(') || (cs[i] == '}' && c == '{') || (cs[i] == ']' && c == '[')) {
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 2、栈的压入与弹出
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        // 辅助栈
        LinkedList<Integer> stackAux = new LinkedList<>();
        int popIndex = 0;
        for (int i = 0;i < pushA.length;i++) {
            // 按照入栈序列依次压入辅助栈中
            stackAux.push(pushA[i]);
            // 每入栈一次和出栈序列比较，如果栈顶和当前出栈元素相同，则弹出同时当前弹出元素指针前移；
            // 如果下一个栈顶元素还和当前弹出元素相同，继续弹出
            while (!stackAux.isEmpty() && stackAux.peek() == popA[popIndex]) {
                stackAux.pop();
                popIndex++;
            }
        }
        // 如果出栈顺序正确，模拟一次进出栈后，辅助栈应该为空。不为空说明序列不正确
        return stackAux.isEmpty();
    }
}
