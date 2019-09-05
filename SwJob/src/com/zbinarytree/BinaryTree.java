package com.zbinarytree;

import java.util.Stack;

class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    boolean isDelete;

    public TreeNode(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}

public class BinaryTree{

    private static TreeNode root;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        // 最值
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        // 查找
        TreeNode treeNode = bt.find(130);
        if(treeNode != null)
            System.out.println(treeNode.data);
        else
            System.out.println("not found");
        // 遍历
        bt.preOrder(root);
        System.out.println();
        bt.infixOrder(root);
        System.out.println();
        bt.postOrder(root);
    }

    // 查找
    public TreeNode find(int key) {
        TreeNode currentNode = root;
        while (currentNode != null){
            if(currentNode.data > key)
                currentNode = currentNode.leftChild;
            else if (currentNode.data < key)
                currentNode = currentNode.rightChild;
            else{
                if (currentNode.isDelete)
                    return null;
                else
                    return currentNode;
            }
        }
        return null;
    }

    // 插入
    public void insert(int data) {
        if(root == null){
            root = new TreeNode(data);
            return;
        }
        TreeNode currentNode = root;
        TreeNode parentNode = null;
        boolean isLeftChild = true;
        while (currentNode != null){
            parentNode = currentNode;
            if(data < currentNode.data){
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            }else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        TreeNode newNode = new TreeNode(data);
        if(isLeftChild)
            parentNode.leftChild = newNode;
        else
            parentNode.rightChild = newNode;
    }

    // 前序遍历--递归
    public void preOrder(TreeNode currentNode) {
        if(currentNode != null){
            System.out.print(currentNode.data + " ");
            preOrder(currentNode.leftChild);
            preOrder(currentNode.rightChild);
        }
    }

    // 前序遍历--迭代
    public void _preOrder(TreeNode currentNode) {
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(currentNode);
            while (!stack.isEmpty() && (currentNode = stack.pop()) != null) {
                System.out.print(currentNode.data + " ");
                if (currentNode.rightChild != null) {
                    stack.push(currentNode.rightChild);
                }
                if (currentNode.leftChild != null) {
                    stack.push(currentNode.leftChild);
                }
            }
        }
    }

    // 中序遍历--递归
    public void infixOrder(TreeNode currentNode) {
        if(currentNode != null){
            infixOrder(currentNode.leftChild);
            System.out.print(currentNode.data+" ");
            infixOrder(currentNode.rightChild);
        }
    }

    // 中序遍历--迭代
    public void _infixOrder(TreeNode currentNode){
        if(currentNode != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || currentNode != null) {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.leftChild;
                }
                currentNode = stack.peek();
                stack.pop();
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.rightChild;
            }
        }
    }

    // 后序遍历--递归
    public void postOrder(TreeNode currentNode) {
        if(currentNode != null){
            postOrder(currentNode.leftChild);
            postOrder(currentNode.rightChild);
            System.out.print(currentNode.data + " ");
        }
    }

    // 后序遍历--迭代
    public void _postOrder(TreeNode currentNode) {
        if(currentNode != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            Stack<Integer> vals = new Stack<>();
            while (!stack.isEmpty()){
                currentNode = stack.peek();
                stack.pop();
                vals.push(currentNode.data);
                if(currentNode.leftChild != null){
                    stack.push(currentNode.leftChild);
                }
                if(currentNode.rightChild != null){
                    stack.push(currentNode.rightChild);
                }

            }
            while (!vals.isEmpty()){
                System.out.print(vals.pop() + " ");
            }
        }
    }

    // 找最大值
    public TreeNode findMax() {
        TreeNode current = root;
        TreeNode maxNode = current;
        while(current != null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找最小值
    public TreeNode findMin() {
        TreeNode current = root;
        TreeNode minNode = current;
        while(current != null){
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    // 删除
    public boolean delete(int key) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while(current.data != key){
            parent = current;
            if(current.data > key){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }
        //如果当前节点没有子节点
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;

            //当前节点有一个子节点，右子节点
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
        }else if(current.leftChild != null && current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
            return true;
        }else{
            //当前节点存在两个子节点
            TreeNode successor = getSuccessor(current);
            if(current == root){
                root= successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    public TreeNode getSuccessor(TreeNode delNode){
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }
}
