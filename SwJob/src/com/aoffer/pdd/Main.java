package com.aoffer.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line  = sc.nextLine().split(",");
        int n = Integer.parseInt(line[line.length-1].split(";")[1]);
        line[line.length-1] = line[line.length-1].split(";")[0];
        ArrayList<Integer> danList = new ArrayList<>();
        ArrayList<Integer> shuangList = new ArrayList<>();
        for (String s : line){
            int x = Integer.parseInt(s);
            if(x % 2 == 0){
                shuangList.add(x);
            }else {
                danList.add(x);
            }
        }
        Collections.sort(danList);
        Collections.reverse(danList);
        Collections.sort(shuangList);
        Collections.reverse(shuangList);
        for (Integer i : danList){
            shuangList.add(i);
        }
        for(int j = 0; j < n; j++){
            if(j != n-1){
                System.out.print(shuangList.get(j) + ",");
            }else {
                System.out.print(shuangList.get(j));
            }
        }
    }
}
