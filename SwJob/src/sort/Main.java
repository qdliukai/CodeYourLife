package sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        netEase(a, b);
    }

    public static void netEase(long a, long b){
        if(a == 0 || b == 0)
            return;
        long temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }
        long r = a%b;
        while (r != 0){
            a = b;
            b = r;
            r = a%b;
        }
        System.out.println(b);
    }
}
