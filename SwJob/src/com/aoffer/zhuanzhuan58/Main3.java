package com.aoffer.zhuanzhuan58;

import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        HashSet<String> hs = new HashSet<>();
        for(String s : lines){
            hs.add(s);
        }
        System.out.println(hs.size());
    }
}
