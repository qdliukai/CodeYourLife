package com.aoffer.suning;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MyMap{
    Entry[]array;
    int size = 0;
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式

    public MyMap(int length) {
        array = new Entry[length];
    }

    public void insert(String key, long value) {
        boolean exists = false;
        if(this.size == 0){
            long time = Long.parseLong(df.format(new Date()));
            array[size] = new Entry(key, value, time);
            size += 1;
            exists = true;
        }else {
            for (int i = 0; i < size; i++) {
                if (array[i].key.equals(key)) {
                    exists = true;
                    if (array[i].value < value) {
                        array[i].value = value;
                        long time = Long.parseLong(df.format(new Date()));
                        array[i].time = time;
                    }
                }
            }
        }
        if (!exists) {
            if (size < array.length) {
                long time = Long.parseLong(df.format(new Date()));
                array[size] = new Entry(key, value, time);
                size += 1;
            } else {
                int minIndex = 0;
                long minTime = array[0].time;
                for (int i = 0; i < array.length; i++) {
                    if (array[i].time < minTime) {
                        minTime = array[i].time;
                        minIndex = i;
                    }
                }
                System.out.println(array[minIndex].key + " " + array[minIndex].value);
                array[minIndex].key = key;
                array[minIndex].value = value;
                long time = Long.parseLong(df.format(new Date()));
                array[minIndex].time = time;
            }
        }
    }
}

class Entry {
    String key;
    long value;
    long time;
    public Entry(String key, long value, long time) {
        this.key = key;
        this.value = value;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) {
        MyMap myMap = new MyMap(2);
        myMap.insert("10_123_50_A0", 1566918054);
        myMap.insert("10_123_50_A1", 1566918054);
        myMap.insert("10_123_50_A1", 1566918055);
        myMap.insert("10_123_50_A3", 1566918055);
        myMap.insert("10_123_50_A4", 1566918056);

    }
}
