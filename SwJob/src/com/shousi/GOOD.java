package com.shousi;

import java.util.Scanner;

public class GOOD {
	public Node1 head;
	public Node1 current;

	public static void main(String[] args) {
		int[] arr = new int[] {2,4,1,3,9,6};
		GOOD good = new GOOD();
		for(int i = 0; i < arr.length; i++) {
			good.add(arr[i]);
		}
		good.current = good.head;
		while(good.current != null) {
			System.out.println(good.current.data);
			good.current = good.current.next;
		}
	}
	
	public void add(int data) {
		if(head == null) {
			head = new Node1(data);
			current = head;
		}else {
			current.next = new Node1(data);
			current = current.next;
		}
		
	}
	
	public static ListNode insertHead(int n, Scanner scanner) {
		ListNode listNode = new ListNode(scanner.nextInt());
		for (int i = 1; i < n; i++) {
			ListNode pListNode = new ListNode(scanner.nextInt());
			pListNode.next = listNode.next;
			listNode.next = pListNode;
		}
		return listNode;
	}
}

class Node1{
	int data;
	Node1 next;
	public Node1(int data) {
		this.data = data;
	}
}