package com.util;
import java.util.Stack;
import java.util.Iterator;
import java.util.List;

/**
 * @desc Stack�Ĳ��Գ��򡣲��Գ���API���÷�
 *
 * @author skywang
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        // ��1,2,3,4,5��ӵ�ջ��
        for(int i=1; i<6; i++) {
            stack.push(String.valueOf(i));
        }

        // ��������ӡ����ջ
        iteratorThroughRandomAccess(stack) ;

        // ���ҡ�2����ջ�е�λ�ã������
        int pos = stack.search("2");
        System.out.println("the postion of 2 is:"+pos);

        // pupջ��Ԫ��֮�󣬱���ջ
        stack.pop();
        iteratorThroughRandomAccess(stack) ;

        // peekջ��Ԫ��֮�󣬱���ջ
        String val = (String)stack.peek();
        System.out.println("peek:"+val);
        iteratorThroughRandomAccess(stack) ;

        // ͨ��Iteratorȥ����Stack
        iteratorThroughIterator(stack) ;
    }

    /**
     * ͨ�����ٷ��ʱ���Stack
     */
    public static void iteratorThroughRandomAccess(List list) {
        String val = null;
        for (int i=0; i<list.size(); i++) {
            val = (String)list.get(i);
            System.out.print(val+" ");
        }
        System.out.println();
    }

    /**
     * ͨ������������Stack
     */
    public static void iteratorThroughIterator(List list) {

        String val = null;
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            val = (String)iter.next();
            System.out.print(val+" ");
        }
        System.out.println();
    }

}