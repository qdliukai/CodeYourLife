package com.zbinarytree;

import java.util.*;

class TreeNodeOffer{
    int data;
    TreeNodeOffer left;
    TreeNodeOffer right;

    public TreeNodeOffer(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}

public class A_BinaryTree_Offer {

    private static TreeNodeOffer root;
    // 插入
    public void insert(int data) {
        if(root == null){
            root = new TreeNodeOffer(data);
            return;
        }
        TreeNodeOffer currentNode = root;
        TreeNodeOffer parentNode = null;
        boolean isLeftChild = true;
        while (currentNode != null){
            parentNode = currentNode;
            if(data < currentNode.data){
                currentNode = currentNode.left;
                isLeftChild = true;
            }else {
                currentNode = currentNode.right;
                isLeftChild = false;
            }
        }
        TreeNodeOffer newNode = new TreeNodeOffer(data);
        if(isLeftChild)
            parentNode.left = newNode;
        else
            parentNode.right = newNode;
    }
    // 前序遍历--递归
    public void preOrder(TreeNodeOffer currentNode) {
        if(currentNode != null){
            System.out.print(currentNode.data + " ");
            preOrder(currentNode.left);
            preOrder(currentNode.right);
        }
    }

    public static void main(String[] args) {
        A_BinaryTree_Offer bt = new A_BinaryTree_Offer();
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

//        ArrayList<ArrayList<Integer>> lists = Print(root);
//        Iterator<ArrayList<Integer>> iterator = lists.iterator();
//        while (iterator.hasNext()){
//            List<Integer> next = iterator.next();
//            System.out.println(next.toString());
//        }

        int num = get_k_level_leaf_number(root, 2);
        System.out.println(num);


    }

    // 1. 求二叉树中的节点个数   递归解法：
    // (1)如果二叉树为空，节点个数为0
    // (2)如果不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
    public static int getNodeNumRec(TreeNodeOffer root) {
        if (root == null)
            return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    // 2. 求二叉树的最大层数(最大深度)  递归解法：
    // (1)如果二叉树为空，二叉树的深度为0
    // (2)如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
    public static int maxDepth(TreeNodeOffer root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 3. 求二叉树的最小层数(最小深度)  递归解法：
    public static int minDepth(TreeNodeOffer root) {
        if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    // 4.自顶向下、分层遍历、
    public static List<List<Integer>> levelOrder(TreeNodeOffer root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNodeOffer> queue = new LinkedList<>();
        TreeNodeOffer cur = null;
        queue.add(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int l = queue.size();
            for(int i=0; i<l;i++){
                cur = queue.poll();
                level.add(cur.data);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    // 5.自下向上、分层遍历、
    public static List<List<Integer>> levelOrderBottom(TreeNodeOffer root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNodeOffer> queue = new LinkedList<>();
        if(root == null)
            return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<count; i++){
                TreeNodeOffer node = queue.poll();
                temp.add(node.data);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            // 每次都添加到第一个位置
            res.add(0, temp);
        }
        return res;
    }
    // 6、按之字形顺序打印二叉树
    public static ArrayList<ArrayList<Integer>> Print(TreeNodeOffer pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        Stack<TreeNodeOffer> s1 = new Stack<>();
        Stack<TreeNodeOffer> s2 = new Stack<>();
        int flag = 1;
        if(pRoot == null)
            return res;
        s2.push(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(flag % 2 != 0){
                while(!s2.isEmpty()){
                    TreeNodeOffer node = s2.pop();
                    temp.add(node.data);
                    if(node.left != null){
                        s1.push(node.left);
                    }
                    if(node.right != null){
                        s1.push(node.right);
                    }
                }
            }
            if(flag % 2 == 0){
                while(!s1.isEmpty()){
                    TreeNodeOffer node = s1.pop();
                    temp.add(node.data);
                    if(node.right != null){
                        s2.push(node.right);
                    }
                    if(node.left != null){
                        s2.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag ++;
        }
        return res;
    }

    // 7、求二叉树第K层的节点个数
    public static int get_k_level_number(TreeNodeOffer root, int k){
        if(root == null || k <=0){
            return 0;
        }
        if(root != null && k == 1){
            return 1;
        }
        return get_k_level_number(root.left, k-1) + get_k_level_number(root.right, k-1);
    }

    // 8、求二叉树第K层的叶子节点个数
    public static int get_k_level_leaf_number(TreeNodeOffer root, int k){
        if(root == null || k <=0){
            return 0;
        }
        if(root != null && k == 1){
            if(root.left == null && root.right == null)
                return 1;
            else
                return 0;
        }
        return get_k_level_number(root.left, k-1) + get_k_level_number(root.right, k-1);
    }

    // 9、判断两棵二叉树是否结构相同  递归解法：
    //（1）如果两棵二叉树都为空，返回真
    //（2）如果两棵二叉树一棵为空，另一棵不为空，返回假
    //（3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
    public static boolean isSameTree(TreeNodeOffer p, TreeNodeOffer q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.data == q.data)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    // 10. 判断二叉树是不是平衡二叉树    递归解法：
    // 对于此问题，高度平衡二叉树定义为： 一个二叉树，其中每个节点的两个子树的深度差不相差超过1。
    //（1）如果二叉树为空，返回真
    //（2）如果二叉树不为空，如果左子树和右子树高度相差不大于1且左子树和右子树都是AVL树，返回真，其他返回假
    public static boolean isBalanced(TreeNodeOffer root) {
        if(root == null)
            return true;
        return Math.abs(maxHigh(root.left) - maxHigh(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxHigh(TreeNodeOffer root){
        if(root == null)
            return 0;
        return Math.max(maxHigh(root.left), maxHigh(root.right))+1;
    }

    // 11. 求二叉树的镜像
    //     源二叉树          镜像二叉树
    //        8                8
    //       /  \             /  \
    //      6   10           10   6
    //     / \  / \         /  \ /  \
    //    5  7 9  11       11  9 7   5
    public static TreeNodeOffer invertTree(TreeNodeOffer root) {
        if(root == null)
            return root;

        TreeNodeOffer node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);

        return root;
    }
    public static void Mirror(TreeNodeOffer root) {
        //当前节点为空，直接返回
        if(root == null)
            return;
        //当前节点没有叶子节点，直接返回
        if(root.left == null && root.right == null)
            return;
        TreeNodeOffer temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换叶子节点
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

    // 11.1 对称二叉树   给定一个二叉树，检查它是否是镜像对称的。
    // 递归。根节点的左右子树相同，左子树的左子树和右子树的右子树相同，左子树的右子树和右子树的左子树相同即可。
    public static boolean isSymmetric(TreeNodeOffer root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }
    public static boolean isSymmetricHelper(TreeNodeOffer left, TreeNodeOffer right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.data != right.data)
            return false;
        return isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }

    // 12、由前序遍历序列和中序遍历序列重建二叉树
    public TreeNodeOffer buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        return buildTreeHelper1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNodeOffer buildTreeHelper1(int[] preorder, int pre_start, int pre_end,
                                    int[] inorder, int in_start, int in_end){
        if(pre_start > pre_end || in_start > in_end)
            return null;
        TreeNodeOffer root = new TreeNodeOffer(preorder[pre_start]);
        for(int i = in_start; i <= in_end; i++){
            if(inorder[i] == preorder[pre_start]){
                // 左子树的长度：i-is
                root.left = buildTreeHelper1(preorder, pre_start + 1, pre_start + i - in_start, inorder, in_start, i - 1);
                root.right = buildTreeHelper1(preorder, pre_start + i - in_start + 1, pre_end, inorder, i + 1, in_end);
            }
        }
        return root;
    }

    // 12.1、从中序与后序遍历序列构造二叉树
    public TreeNodeOffer buildTree2(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;
        return buildTreeHelper2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNodeOffer buildTreeHelper2(int[] inorder, int in_start, int in_end,
                                    int[] postorder, int post_start, int post_end){
        if(in_start > in_end || post_start > post_end)
            return null;
        TreeNodeOffer root = new TreeNodeOffer(postorder[post_end]);
        for(int i = in_start; i <= in_end; i++){
            if(inorder[i] == postorder[post_end]){
                root.left = buildTreeHelper2(inorder, in_start, i - 1, postorder, post_start, post_start + i - in_start - 1);
                root.right = buildTreeHelper2(inorder, i + 1, in_end, postorder, post_start + i - in_start, post_end - 1);
            }
        }
        return root;
    }

    // 15. 判断二叉树是不是完全二叉树
    // 完全二叉树是指最后一层左边是满的，右边可能慢也不能不满，然后其余层都是满的
    // 根据这个特性，利用层遍历。如果我们当前遍历到了NULL结点，如果后续还有非NULL结点，说明是非完全二叉树。
    public boolean isCompleteTree(TreeNodeOffer root) {
        Queue<TreeNodeOffer> queue=new LinkedList<TreeNodeOffer>();
        queue.offer(root);
        boolean re=true;
        int tag=0;
        while(!queue.isEmpty()){
            for(int i=0;i<queue.size();i++){
                TreeNodeOffer node=queue.poll();
                if(node==null){
                    if(!queue.isEmpty()||queue.poll()!=null){
                        re=false;
                        break;
                    }
                }
                else{
                    if(node.left!=null||node.right!=null){
                        if(tag==1){
                            re=false;
                            break;
                        }
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                    else{

                        tag=1;
                    }
                }
            }
            if(re==false)
                break;
        }
        return re;
    }

    // 16、序列化二叉树
    // 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点不为空时，
    // 在转化val所得的字符之后添加一个’,’作为分割; 对于空节点则以 ‘#,’ 代替。
    // 对于反序列化：将字符串按照“，”进行分割，插入到队列中，
    // 然后依次从队列中取出字符建立节点，递归创建一个二叉树。
    // Encodes a tree to a single string.
    public String serialize(TreeNodeOffer root) {
        if(root == null)
            return "#,";
        StringBuffer res = new StringBuffer(root.data + ",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNodeOffer deserialize(String data) {
        String [] d = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < d.length; i++){
            queue.offer(d[i]);
        }
        return pre(queue);
    }

    public TreeNodeOffer pre(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#"))
            return null;
        TreeNodeOffer node = new TreeNodeOffer(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }

    // 17.  二叉搜索树中第K小的元素
    public int kthSmallest(TreeNodeOffer root, int k) {
        int count = countNodes(root.left);

        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.data;
    }
    public int countNodes(TreeNodeOffer n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    // 18.另一个树的子树
    public boolean isSubtree(TreeNodeOffer s, TreeNodeOffer t) {
        // Write your code here
        if (s == null)
            return t == null;
        if (s.data == t.data && isSametree(s, t))
            return true;
        return isSubtree(s.left, t) | isSubtree(s.right, t);
    }
    private boolean isSametree(TreeNodeOffer s, TreeNodeOffer t) {
        if (s == null)
            return t == null;
        if (t == null)
            return false;
        if (s.data != t.data)
            return false;
        return isSametree(s.left, t.left) & isSametree(s.right, t.right);
    }
}
