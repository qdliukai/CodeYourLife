package com.zbinarytree;

class NodeT{
    Object data;
    NodeT left;
    NodeT right;

    public NodeT(Object data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}

public class Pre_In_2_Post {
    private NodeT root;
    public Pre_In_2_Post(){
        root = null;
    }
    //后序遍历方法递归实现
    public void postOrder(NodeT localRoot){
        if(localRoot!=null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data+" ");
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    public void initTree(Object[] preOrder,Object[] inOrder){
        this.root = this.initTree(preOrder, 0, preOrder.length-1,
                inOrder,0, inOrder.length-1
        );
    }

    public NodeT initTree(Object[] preOrder,int start1,int end1,
                          Object[] inOrder,int start2,int end2){
        if(start1>end1||start2>end2){
            return null;
        }
        Object rootData = preOrder[start1];
        NodeT head = new NodeT(rootData);
        //找到根节点所在位置
        int rootIndex = findIndexInArray(inOrder,rootData,start2,end2);
        //构建左子树(不太懂end1表示的含义)
        NodeT left = initTree(preOrder,start1+1,start1+rootIndex-start2,
                inOrder,start2,rootIndex-1);
        //构建右子树（不太懂start1表示的含义）
        NodeT right = initTree(preOrder,start1+rootIndex-start2+1,end1,
                inOrder,rootIndex+1,end2);
        head.left = left;
        head.right = right;
        return head;
    }

    public int findIndexInArray(Object[] a,Object x,int begin,int end){
        for(int i = begin;i<=end; i++){
            if(a[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pre = "A D C E F G I H B";
        String in = "C D F E I G H A B";
        Object[] preOrder = pre.split(" ");
        Object[] inOrder = in.split(" ");
        Pre_In_2_Post biTree = new Pre_In_2_Post();
        biTree.initTree(preOrder, inOrder);
        System.out.print("二叉树的后序遍历:");
        biTree.postOrder();

        //50 20 10 30 25 80 60 90 85 100
        //10 20 25 30 50 60 80 85 90 100
        //10 25 30 20 60 85 100 90 80 50
    }
}