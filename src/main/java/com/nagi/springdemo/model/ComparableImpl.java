package com.nagi.springdemo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableImpl {
	
	public static void main(String[] args) {
		
		List<DemoComparable> list=new ArrayList<>();
		
		list.add(new DemoComparable(1, "Nagi", 80123.32));
		list.add(new DemoComparable(2, "Rani", 1003000.52));
		list.add(new DemoComparable(3, "Nani", 10000.76));
		list.add(new DemoComparable(4, "Gopal", 1800000.54));
		
		Collections.sort(list);
		
		for(DemoComparable l:list){
			System.out.println(l);
		}
		
		
	}

}
