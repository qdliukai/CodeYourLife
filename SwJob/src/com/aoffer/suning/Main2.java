package com.aoffer.suning;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String lines = sc.nextLine();
        String[] line = lines.split(" ");
        int index = 0;
        int max = 0;
        for(int i = 0; i < num; i++){
            int count = 0;
            int high = -1;
            int pre = Integer.parseInt(line[i]);
            for(int j = i + 1; j < line.length; j++){
                int current = Integer.parseInt(line[j]);
                if(current > pre || current == high)
                    break;
                if(current >= high && current <= pre){
                    count++;
                    if(current > high)
                        high = current;
                }
            }
            if (count > max){
                max = count;
                index = i;
            }
        }
        System.out.println(line[index]);
    }
}
