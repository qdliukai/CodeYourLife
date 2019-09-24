package com.aoffer.wangyi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);
        while (sc.hasNext()){
            int count = 0;
            int val = sc.nextInt();
            int index = arrayList.indexOf(val);
            if(index == -1){
                System.out.println(0);
            }else {
                for (int j = index; j < n; j++){
                    if (arrayList.get(j) == val){
                        count++;
                    }else {
                        break;
                    }
                }
                System.out.println(count);
            }
        }

    }
}
