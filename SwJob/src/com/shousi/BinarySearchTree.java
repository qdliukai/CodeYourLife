package com.shousi;

class Node {
    int key;
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void displayNode() {

    }
}

class Tree {
    Node root;

    public Node find(int key) {
        Node currentNode = root;
        while (currentNode != null && currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        return currentNode;
    }

    public void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        Node newNode = new Node(key, value);
        if (isLeftChild) {
            parentNode.leftChild = newNode;
        } else {
            parentNode.rightChild = newNode;
        }
    }

    public boolean delete(int key) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null && currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            //Ҫɾ���Ľڵ�ΪҶ�ӽڵ�
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parentNode.leftChild = null;
            else
                parentNode.rightChild = null;
        } else if (currentNode.rightChild == null) {//Ҫɾ���Ľڵ�ֻ������
            if (currentNode == root)
                root = currentNode.leftChild;
            else if (isLeftChild)
                parentNode.leftChild = currentNode.leftChild;
            else
                parentNode.rightChild = currentNode.leftChild;
        } else if (currentNode.leftChild == null) {//Ҫɾ���Ľڵ�ֻ���Һ���
            if (currentNode == root)
                root = currentNode.rightChild;
            else if (isLeftChild)
                parentNode.leftChild = currentNode.rightChild;
            else
                parentNode.rightChild = currentNode.rightChild;
        } else { //Ҫɾ���Ľڵ�������������Һ���
            //˼·���ô�ɾ���ڵ��������е�keyֵ��С�ڵ��ֵ�����Ҫɾ���Ľڵ��ֵ,Ȼ��ɾ����������keyֵ��С�Ľڵ�
            //������key��С�Ľڵ�һ������������,����ɾ�����key��С�Ľڵ�һ��������Ҷ�ӽڵ����ֻ���������Ľڵ�
            Node directPostNode = getDirectPostNode(currentNode);
            currentNode.key = directPostNode.key;
            currentNode.value = directPostNode.value;
        }
        return true;
    }

    private Node getDirectPostNode(Node delNode) {//��������Ϊ�õ���ɾ���ڵ��ֱ�Ӻ�̽ڵ�

        Node parentNode = delNode;//���������ɾ���ڵ��ֱ�Ӻ�̽ڵ�ĸ��׽ڵ�
        Node direcrPostNode = delNode;//���������ɾ���ڵ��ֱ�Ӻ�̽ڵ�
        Node currentNode = delNode.rightChild;
        while (currentNode != null) {
            parentNode = direcrPostNode;
            direcrPostNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        if (direcrPostNode != delNode.rightChild) {//������ɾ����ֱ�Ӻ�̽ڵ�
            parentNode.leftChild = direcrPostNode.rightChild;
            direcrPostNode.rightChild = null;
        }
        return direcrPostNode;//���ش�ֱ�Ӻ�̽ڵ�

    }

    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            System.out.println("key: " + rootNode.key + " " + "value: " + rootNode.value);
            inOrder(rootNode.rightChild);
        }
    }

    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            System.out.println(rootNode.key + " " + rootNode.value);
        }
    }
//    private void destroy(Node tree) {
//    	if (tree==null)
//    		return ;
//    	if (tree.left != null)
//			destroy(tree.leftChild);
//    	if (tree.right != null)
//    		destroy(tree.rightChild);
// 
//    	tree=null;
//  ����  }
//
//	public void destory() {
//		destory(root);
//	}
} 
public class BinarySearchTree { 
	public static void main(String[] args) {
		Tree tree = new Tree(); 
		tree.insert(6, 6);//�������,����ͼһ��ʾ�Ķ����� 
		tree.insert(3, 3); 
		tree.insert(14, 14); 
		tree.insert(16, 16); 
		tree.insert(10, 10); 
		tree.insert(9, 9); 
		tree.insert(13, 13); 
		tree.insert(11, 11); 
		tree.insert(12, 12); 
		System.out.println("ɾ��ǰ�������"); 
		tree.inOrder(tree.root);//����������� 
		System.out.println("ɾ���ڵ�10֮��������"); 
		tree.delete(10);//ɾ������ 
		tree.inOrder(tree.root);
	} 
}