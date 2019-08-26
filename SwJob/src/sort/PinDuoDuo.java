package sort;

import java.util.Scanner;

public class PinDuoDuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrA = sc.nextLine().split(" ");
        String[] arrB = sc.nextLine().split(" ");
        findWarn(arrA, arrB);

    }

    public static void findWarn(String[] arrA, String[] arrB){
        int lenA = arrA.length;
        int lenB = arrB.length;
        int warnIndex = -1;
        for(int i = 0; i < lenA-1; i++){
            if(Integer.parseInt(arrA[i+1]) < Integer.parseInt(arrA[i])){
                warnIndex = i + 1;
            }
        }
        int left = Integer.parseInt(arrA[warnIndex-1]);
        int right = Integer.parseInt(arrA[warnIndex+1]);

        int maxRight = -99;
        for(int i = 0; i < lenB; i++){
            if(Integer.parseInt(arrB[i]) > left && Integer.parseInt(arrB[i]) < right){
                if(Integer.parseInt(arrB[i]) > maxRight){
                    maxRight = Integer.parseInt(arrB[i]);
                }
            }
        }
        if(maxRight == -99)
            System.out.println("NO");
        else {
            arrA[warnIndex] = String.valueOf(maxRight);
            int i = 0;
            for(; i < arrA.length-1; i++){
                System.out.print(arrA[i] + " ");
            }
            System.out.print(arrA[i]);
        }

    }
}
