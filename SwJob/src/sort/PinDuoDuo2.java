package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PinDuoDuo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrS = sc.nextLine().split(" ");
        ArrayList<String> listS = new ArrayList<String>();
        for(String s : arrS){
            listS.add(s);
        }
        circle(arrS, listS);

    }

    public static void circle(String[] arrS, List<String> listS){

        String initString = arrS[0];
        String current = arrS[0];
        while (true){
            int i = 0;
            int flag = 0;
            char highi = current.charAt(current.length()-1);
            for(String s : listS){
                if(listS.size() == 1){
                    break;
                }
                if(s.charAt(0) == highi){
                    listS.remove(i);
                    i++;
                    current = s;
                    flag = 1;
                    break;
                }
            }
            if(flag ==0 && listS.size() != 1) {
                System.out.println("false");
                break;
            }
            if(listS.size() == 1){
                break;
            }
        }
        if(listS.size() == 1){
            String a = listS.get(0);
            char end = a.charAt(a.length()-1);
            char start = initString.charAt(0);
            if(end == start){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }

    }
}
