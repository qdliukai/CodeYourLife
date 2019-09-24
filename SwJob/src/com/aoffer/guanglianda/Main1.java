package com.aoffer.guanglianda;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitLine = line.split(" ");
        String[] node = splitLine[0].split("->");
        int n = Integer.parseInt(splitLine[1]);
        ListNode head = insertTail(node);
        ListNode listNode = removeNthFromEnd(head, n);
        while (listNode != null){
            if(listNode.next != null){
                System.out.print(listNode.val + "->");
                listNode = listNode.next;
            }else {
                System.out.print(listNode.val);
                listNode = listNode.next;
            }

        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(null == head || null == head.next)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i<=n; i++){
            fast = fast.next;
        }
        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return dummyHead.next;
    }

    public static ListNode insertTail(String[] a) {
        ListNode listNode = new ListNode(Integer.parseInt(a[0]));
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {
            ListNode pListNode = new ListNode(Integer.parseInt(a[i]));
            ListNode tmp = listNode;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = pListNode;
            pListNode.next = null;
        }
        return listNode;
    }
}
