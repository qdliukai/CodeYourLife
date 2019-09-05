package com.shousi;

import java.io.FilterInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
	
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<>();
		hm.put("1", "A");
		hm.put("2", "B");
		hm.put("3", "C");
		for (String s : hm.values()){
			System.out.print(s + " ");
		}
		System.out.println();
		for (String key : hm.keySet()){
			System.out.println("key=" + key + "  val=" + hm.get(key));
		}
		for (Map.Entry<String, String> entry : hm.entrySet()){
			System.out.println(entry.getKey() + entry.getValue());
		}

	}

}
