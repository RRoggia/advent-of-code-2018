package com.rroggia.day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rroggia.utils.IOUtils;

public class Day1 {
	public static void main(String[] args) {

		List<Integer> frequencies = IOUtils.readIntegersFromInputFile("/day1/input");

		Set<Integer> frequenciesDeviceReached = new HashSet<>();
		boolean foundFrequencyDeviceReachedTwice = false;
		int resultingFrequency = 0;

		while (!foundFrequencyDeviceReachedTwice) {
			for (Integer frequency : frequencies) {
				if (!frequenciesDeviceReached.add(resultingFrequency)) {
					foundFrequencyDeviceReachedTwice = true;
					break;
				}
				resultingFrequency += frequency;
			}
		}
		System.out.println(resultingFrequency);
	}

}
