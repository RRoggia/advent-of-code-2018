package com.rroggia.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
	public static void main(String[] args) {

		List<Integer> frequencies = readFrequenciesFromInputFile();

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

	private static List<Integer> readFrequenciesFromInputFile() {
		List<Integer> frequencies = new ArrayList<>();

		try (Reader fileReader = new FileReader("./src/com/rroggia/day1/input");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String frequencyRead = bufferedReader.readLine();

			while (frequencyRead != null) {
				frequencies.add(Integer.parseInt(frequencyRead));
				frequencyRead = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			System.out.println("Error in IO");
			e.printStackTrace();
		}
		return frequencies;
	}
}
