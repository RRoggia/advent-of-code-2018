package com.rroggia.day5;

import java.util.List;

import com.rroggia.utils.IOUtils;

public class Day5 {

	public static void main(String[] args) {
		List<String> readStringsFromInputFile = IOUtils.readStringsFromInputFile("/day5/input");
		String input = readStringsFromInputFile.get(0);

		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		String letter = "";
		Integer length = Integer.MAX_VALUE;
		for (int j = 0; j < alphabet.length; j++) {

			String lastOne = input.replace(Character.toString(alphabet[j]).toLowerCase(), "");
			lastOne = lastOne.replace(Character.toString(alphabet[j]).toUpperCase(), "");
			String currentOne = "";

			while (!lastOne.equals(currentOne)) {
				if (!currentOne.equals(""))
					lastOne = currentOne;

				String[] polymers = lastOne.split("");
				StringBuilder polymerBuilder = new StringBuilder();
				for (int i = 0; i < polymers.length; i++) {
					String polymer = polymers[i];
					String nextPolymer;

					if (i + 1 < polymers.length) {
						nextPolymer = polymers[i + 1];
					} else {
						polymerBuilder.append(polymer);
						break;
					}

					if (polymer.equalsIgnoreCase(nextPolymer) && !polymer.equals(nextPolymer)) {
						i++;
						continue;
					} else {
						polymerBuilder.append(polymer);
					}
				}
				currentOne = polymerBuilder.toString();
			}
			if (currentOne.length() < length) {
				length = currentOne.length();
				letter = Character.toString(alphabet[j]);
			}
		}
		System.out.println(letter);
		System.out.println(length);
	}
}
