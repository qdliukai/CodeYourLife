package com.aoffer.duxiaoman;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static volatile ArrayList<Integer> b = new ArrayList<>();
    private static volatile Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line1 = sc.nextLine();
        for( int i = 0; i < n; i++){
            b.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++){
            System.out.println(b.get(i));
        }
//        String[] strA = line1.split(" ");
//        ArrayList<Integer> a = new ArrayList<>();
//        for(int i = 0; i < n+1; i++){
//            a.add(Integer.parseInt(strA[i]));
//        }
//        int count = 0 ;
//        for(int i = 0; i < n; i++){
//            if((a.get(i) + a.get(i+1)) > b.get(i)){
//                if(a.get(i) >= b.get(i)){
//                    count += b.get(i);
//                    a.set(i, a.get(i) - b.get(i));
//                }else {
//                    count += b.get(i);
//                    a.set(i+1, (a.get(i+1)-(b.get(i)-a.get(i))));
//                    a.set(i, 0);
//                }
//            }else {
//                count += (a.get(i) + a.get(i+1));
//                a.set(i, 0);
//                a.set(i+1, 0);
//            }
//        }
//        System.out.println(count);
    }
}
