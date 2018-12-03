package com.rroggia.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rroggia.utils.IOUtils;

public class Day2 {

	public static void main(String[] args) {

		List<String> boxIDs = IOUtils.readStringsFromInputFile("./src/com/rroggia/day2/input");

		int boxIDsWithTwoLetters = 0;
		int boxIDsWithThreeLetters = 0;

		for (String boxID : boxIDs) {

			Map<String, Integer> letters = new HashMap<String, Integer>();

			for (int i = 0; i < boxID.length(); i++) {
				String key = Character.toString(boxID.charAt(i));

				if (letters.containsKey(key))
					letters.put(key, letters.get(key) + 1);
				else
					letters.put(key, 1);
			}

			if (letters.values().contains(Integer.valueOf(2)))
				boxIDsWithTwoLetters++;

			if (letters.values().contains(Integer.valueOf(3)))
				boxIDsWithThreeLetters++;

		}

		System.out.println(boxIDsWithTwoLetters * boxIDsWithThreeLetters);
	}
}
