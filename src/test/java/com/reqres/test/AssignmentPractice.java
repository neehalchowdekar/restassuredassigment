package com.reqres.test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.function.BinaryOperator;

public class AssignmentPractice {
	
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 1; i < 10; i++) {
			int randomNo = randomNumberGen(1, 20);
			int userid = getuserid(randomNo);
			arr[i]= userid;
			System.out.println(randomNo + ": " +  userid  + ": " + getPaths(userid));
		}
		
		int majorityId = majority(arr);
		System.out.println("majority of element is " + majorityId  + " with " + getPaths(majorityId));
	}
	
	
	public static int randomNumberGen(int min, int max) {
		BinaryOperator<Integer> bi = (a, b) -> new Random().nextInt(b - a) + a;
		return bi.apply(min, max);
	}
	
	
	
	public static int getuserid(int userid) {
		int result = userid % 3;
		return result;
	}
	
	public static String getPaths(int userid) {
		switch (userid) {
		case 0:
			return "Path A";
		case 1:
			return "Path B";
		case 2:
			return "Path C";
		default:
			return "user id invalid";
		}
	}
	
	public static int majority(int[] arr) {
		 HashMap<Integer, Integer> map = new HashMap<>();
	        
	        for(Integer i : arr){
	            if(map.containsKey(i)){
	                map.put(i, map.get(i) + 1);
	            }else{
	                map.put(i,1);
	            }
	        }
	        Set<Entry<Integer, Integer>> entryKey = map.entrySet();
	        int max = 0, res = -1;
	        for(Entry<Integer, Integer> entry : entryKey){
	            if(max < entry.getValue()){
	            max = entry.getValue();
	            res = entry.getKey();
	            }
	        }
	        return res;
	}

}
