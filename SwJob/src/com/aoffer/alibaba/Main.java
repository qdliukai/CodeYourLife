package com.aoffer.alibaba;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        int[][] arr = new int[n][m];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(line[k]);
                k++;
            }
        }

        int count = 0;
        HashSet<String> flag = new HashSet<>();
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
//                System.out.println(i+"_"+j);
                if(flag.contains(i+"_"+j)){
                    continue;
                }else {
                    if(arr[i][j] == 1) {
                        if (arr[i][j + 1] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j + 1] == 1) {
                            String a = i + "_" + j;
                            String b = i + "_" + (j + 1);
                            String c = (i + 1) + "_" + j;
                            String d = (i + 1) + "_" + (j + 1);
                            flag.add(a);
                            flag.add(b);
                            flag.add(c);
                            flag.add(d);
                            count++;
                            System.out.println(flag.size());
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}
