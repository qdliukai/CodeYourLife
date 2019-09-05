package com.shousi;

import java.util.Scanner;


/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author LKPC
 *
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class KthNode {

	static TreeNode root;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String kStr = scanner.nextLine();
		int k = Integer.parseInt(kStr);
		String arrayStr = scanner.nextLine();
		String[] split = arrayStr.split(" ");
		for(String string : split) {
			insert(Integer.parseInt(string));				
		}
		inOrder(root);
		TreeNode res = KthNode(root, k);
		System.out.println(res.val);
		
	}

	static int count = 0;
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null) {
        	TreeNode leftNode = KthNode(pRoot.left, k);
        	if(leftNode != null)
        		return leftNode;
        	count++;
        	if(count == k)
        		return pRoot;
        	TreeNode rightNode = KthNode(pRoot.right, k);
        	if(rightNode != null)
        		return rightNode;
        }
        return null;
    }
    
    public static void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        TreeNode currentNode = root;
        TreeNode parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (value < currentNode.val) {
                currentNode = currentNode.left;
                isLeftChild = true;
            } else {
                currentNode = currentNode.right;
                isLeftChild = false;
            }
        }
        TreeNode newNode = new TreeNode(value);
        if (isLeftChild) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
    }
    
    public static void inOrder(TreeNode rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.left);
            System.out.println("value: " + rootNode.val);
            inOrder(rootNode.right);
        }
    }
}
