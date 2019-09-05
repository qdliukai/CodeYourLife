package com.zlianbiao;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class A_Lian_Biao {
    public static void main(String[] args) {
        int[] a = {2, 3, 16};
        int[] b = {1, 2, 5};
        ListNode aListNode = insertTail(a);
        ListNode bListNode = insertTail(b);
        ListNode listNode = mergeTwoLists(aListNode, bListNode);
        while (listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }

    // 1、两数相加，给定两个非空链表表示两个非负整数，位数按照逆序方式存储，将两数相加，返回一个新的链表
    // 输入：2->4->3 + 5->6->4
    // 输出：7->0->8
    // 原因：342+465=807
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    // 2、删除链表的倒数第n个节点
    // 1->2->3->4->5   n=2   => 1->2->3->5
    public static ListNode removeNthFromEnd(ListNode head, int n){
        // 正确性判断
        if(null == head || null == head.next)
            return null;
        // 定义虚拟头节点方便遍历
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 定义快慢两个节点
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 让fast先跑到第n个位置
        for (int i = 0; i<=n; i++){
            fast = fast.next;
        }
        // 再让两个一起移动，当fast为尾节点时slow的位置即删除元素的位置
        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;  // heap GC

        return dummyHead.next;
    }

    // 3、合并两个有序链表为一个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    // 4、判断链表是否有环
    public static boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            // move 2 steps
            fast = fast.next.next;
            // move 1 step
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    // 5、删除链表中等于给定值val的所有节点
    public static ListNode removeElements(ListNode head, int val){
        // 定义一个虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    // 6、反转链表
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        while (null != head){
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }


    /**
     * 头插法
     */
    public static ListNode insertHead(int[] a) {
        int n = a.length;
        ListNode listNode = new ListNode(a[0]);
        for (int i = 1; i < n; i++) {
            ListNode pListNode = new ListNode(a[i]);
            pListNode.next = listNode.next;
            listNode.next = pListNode;
        }
        return listNode;
    }

    /**
     * 尾插法
     */
    public static ListNode insertTail(int[] a) {
        ListNode listNode = new ListNode(a[0]);
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {
            ListNode pListNode = new ListNode(a[i]);
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
