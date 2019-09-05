package com.shousi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}
}
/**
 * ��β��ͷ��ӡ����
 * 
 * @author LKPC
 *
 */
public class LianBiao {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ListNode listNode = insertHead(n, scanner);
		ArrayList<Integer> res = printListFromTailToHead(listNode);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}

	/**
	 * ͷ�巨
	 */
	public static ListNode insertHead(int n, Scanner scanner) {
		ListNode listNode = new ListNode(scanner.nextInt());
		for (int i = 1; i < n; i++) {
			ListNode pListNode = new ListNode(scanner.nextInt());
			pListNode.next = listNode.next;
			listNode.next = pListNode;
		}
		return listNode;
	}

	/**
	 * β�巨
	 */
	public static ListNode insertTail(int n, Scanner scanner) {
		ListNode listNode = new ListNode(scanner.nextInt());

		for (int i = 1; i <= n - 1; i++) {
			ListNode pListNode = new ListNode(scanner.nextInt());
			ListNode tmp = listNode;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = pListNode;
			pListNode.next = null;
		}
		return listNode;
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		if (listNode == null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			return list;
		}
		Stack<Integer> stk = new Stack<Integer>();
		while (listNode != null) {
			stk.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (!stk.isEmpty()) {
			arr.add(stk.pop());
		}
		return arr;
	}
}
