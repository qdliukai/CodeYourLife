package com.aoffer.wangyi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < k; i++){
            String[] line1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
            String[] line2 = sc.nextLine().split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int j = 0; j < n; j++){
                arrayList.add(Integer.parseInt(line2[0]));
            }
            if(arrayList.get(0) != 0){
                arrayList.set(0,arrayList.get(0)-1);
                m++;
            }
            int flag = 0;
            for(int j = 0; j < n-1; j++){
                if (arrayList.get(j) < arrayList.get(j+1)-1){
                    arrayList.set(j+1, arrayList.get(j+1)-1);
                    m++;
                }else {
                    int chaju = Math.abs(arrayList.get(j+1)-arrayList.get(j));
                    if(chaju == 0){
                        if(m >= 1){
                            m--;
                            arrayList.set(j+1, arrayList.get(j+1)+1);
                        }else {
                            flag = 1;
                        }
                    }else if(chaju == 1){
                        continue;
                    }else {
                        if(m >= (chaju+1)){
                            m-=(chaju+1);
                            arrayList.set(j+1, arrayList.get(j+1)+(chaju+1));
                        }else {
                            flag = 1;
                        }
                    }

                }
            }
            if (flag == 0){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
}
