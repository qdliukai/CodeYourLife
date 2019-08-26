package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        String arr[] = sc.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(String s: arr){
            list.add(Integer.parseInt(s));
        }
        fun(list);
    }

    public static void fun(ArrayList<Integer> list){
        ArrayList<Integer> sortedList = (ArrayList<Integer>)list.clone();
        Collections.sort(sortedList);
        int len = list.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 1; i <= len; i++){
            int flag = len - i;
            if(i == 1){
                int min = sortedList.get(0);
                res.add(min);
                continue;
            }
            if(i == len){
                int min = sortedList.get(len-1);
                res.add(min);
                continue;
            }
            int min = -1;
            for(int j = 0; j < len - i + 1; j++){
                List<Integer> tempList = list.subList(j, j+i);
                Object[] objects = tempList.toArray();
                ArrayList<Integer> sl = new ArrayList<Integer>();
                for(Object s : objects) {
                    sl.add(Integer.parseInt(s.toString()));
                }
                Collections.sort(sl);
                if(j == 0)
                    min = sl.get(i-1);
                int max = sl.get(i-1);
//                System.out.println(max);
                if(min > max) {
                    min = max;
                }

            }
            res.add(min);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); i++){
            if(i != res.size()-1)
                sb.append(res.get(i) + " ");
            else {
                sb.append(res.get(i));
            }
        }
        System.out.println(sb.toString());
    }
}
