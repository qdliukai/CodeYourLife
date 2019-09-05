package com.aoffer.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if(null == head || null == head.next)
            return null;
        ListNode p = head;
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode min = dummyHead1;
        ListNode max = dummyHead2;
        while (p != null) {
            if (p.val < m) {
                min.next = p;
                min = min.next;
            } else {
                max.next = p;
                max = max.next;
            }
            p = p.next;
        }
        if (null == dummyHead1.next)
            return head;
        else {
            min.next = dummyHead2.next;
            max.next = null;
            return dummyHead1.next;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
