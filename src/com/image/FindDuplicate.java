package com.image;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {

	public static void main(String[] args) {
		String str = "interview";
		char[] chars = str.toCharArray();
		int counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : chars) {
			if (map.containsKey(c)) {
				counter = map.get(c);
				map.put(c, ++counter);
			} else {
				map.put(c, 1);
			}
		}

		System.out.println("Duplicate characters:");
		
		// Print duplicate characters
		for (char c : map.keySet()) {
			if (map.get(c) > 1) {
				System.out.println(c);
				
			}
		}
	}
}
