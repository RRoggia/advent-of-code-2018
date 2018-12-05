package com.rroggia.day5;

import java.util.List;

import com.rroggia.utils.IOUtils;

public class Day5 {

	public static void main(String[] args) {
		List<String> readStringsFromInputFile = IOUtils.readStringsFromInputFile("./src/com/rroggia/day5/input");
		String input = readStringsFromInputFile.get(0);

		String lastOne = input;
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
		System.out.println(currentOne.length());
	}
}
