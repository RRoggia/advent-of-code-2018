package com.rroggia.day2;

import java.util.List;

import com.rroggia.utils.IOUtils;

public class Day2 {

	public static void main(String[] args) {

		List<String> boxIDs = IOUtils.readStringsFromInputFile("/day2/input");

		String commonLetters = "";

		for (String boxID : boxIDs) {
			for (String nextBoxId : boxIDs) {

				boolean hasOneDifferentiation = false;

				for (int i = 0; i < boxID.length(); i++) {
					String key = Character.toString(boxID.charAt(i));
					String nextBoxKey = Character.toString(nextBoxId.charAt(i));

					if (key.equals(nextBoxKey)) {
						commonLetters += key;
						continue;
					}

					if (hasOneDifferentiation) {
						hasOneDifferentiation = false;
						break;
					} else {
						hasOneDifferentiation = true;
					}
				}

				if (hasOneDifferentiation) {
					break;
				} else {
					commonLetters = "";
				}
			}
			if (!commonLetters.isEmpty())
				break;
		}

		System.out.println(commonLetters);
	}
}
