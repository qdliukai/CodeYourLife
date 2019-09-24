package com.aoffer.guanglianda;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char[] chars = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> ll = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        Dictionary<Integer, Integer> hashMap = new Hashtable<>();
        int i = 0;
        for(char c : chars){
            hashMap.put(Integer.parseInt(""+c), i);
            i++;
        }
        ((Hashtable<Integer, Integer>) hashMap).forEach((key, value) -> {
            if(!set.contains(key)){
                while (!stack.isEmpty() && key < stack.peek() && value < hashMap.get(stack.peek())){
                    set.remove(stack.pop());
                }
                set.add(key);
                stack.add(key);
            }
        });
        stack.forEach(integer -> System.out.print(integer+""));
    }
}
