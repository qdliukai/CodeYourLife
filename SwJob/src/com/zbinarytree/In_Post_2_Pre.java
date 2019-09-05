package com.zbinarytree;

//利用java api来进行遍历
////已知二叉树后序和中序，求先序
public class In_Post_2_Pre {
    //全局变量存放后序序列
    //先写根，后写左子树，最后写右子树
    public static String res = "";
    //两个字符串是否包含了相同的字符
    public static boolean StringEquals(String a1, String a2) {
        boolean state = true;
        if (a1.length() != a2.length()) {
            state = false;
        }
        if (a1.length() == a2.length()) {
            for (int i = 0; i < a1.length(); i++) {
                if (a2.indexOf(a1.charAt(i)) == -1)
                    state = false;
            }
        }
        return state;
    }
    //进行遍历输出
    //参数依此为中序序列，后序序列
    public static void cal_tree(String smid, String slast) {
        boolean state = StringEquals(smid, slast);
        if (state == false)
            return;
        if (smid.length() == 0)
            return;
        //每次添加都是添加中序的字符，当中序字符串长度为1的时候，就返回
        if (smid.length() == 1) {
            res += smid;
            return;
        }
        //后序序列中最后一个就是根
        char root = slast.charAt(slast.length()-1);
        //获取字符在中序序列总的位置
        //mid代表的是索引
        int mid = smid.indexOf(root);
        //中序序列的左子树
        String c=smid.substring(0, mid);
        //中序序列的右子树
        String d = smid.substring(mid+1);
        //写入根
        res += String.valueOf(root);
        //中序左子树，后序左子树
        cal_tree(c,slast.substring(0, c.length()));
        //中序右子树，后序右子树,注意这里后序的右子树要最大为slast.length()-1
        cal_tree(d,slast.substring(c.length(),slast.length()-1));
        return;
    }
    public static void main(String[] agrs) {
        //cal_tree("ADEFGHMZ","AEFDHZMG");=GDAFEMHZ
        //cal_tree("CDBEAGF","DCEBGFA");=ABCDEFG
        String in = "EDA";
        String post = "EAD";
        cal_tree(in, post);
        if (res.length() != in.length())
        {
            System.out.println("wrong tree list!");
        }
        else {
            System.out.println(res);
        }
    }
}
