package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.example.demo.util.SortService;

public class StringSorter {
	
	public StringSorter() {
	    System.out.println();
	    String test = "to-read, z-awards-man-booker-prize-winners, novels";
	    String[] testArr = test.split(", ");
	    List<String> testList = Arrays.asList(testArr);        
	    Collections.sort(testList);
	    System.out.println(testList);
	    System.out.println();
	    SortService sortService = new SortService();
	    sortService.duh();
	    
	}
	

}
