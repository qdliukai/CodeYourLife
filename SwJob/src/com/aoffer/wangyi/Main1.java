package com.aoffer.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextLine());
        }
        for(int i = 0; i < n; i++){
            String[] line = arrayList.get(i).split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int p = Integer.parseInt(line[2]);
            int q = Integer.parseInt(line[3]);
            int count = 0;
            while ((A+p) < B){
                p = p * q;
                count++;
            }
            if(A >= B){
                System.out.println(0);
            }else {
                count++;
                System.out.println(count);
            }
        }
    }
}
