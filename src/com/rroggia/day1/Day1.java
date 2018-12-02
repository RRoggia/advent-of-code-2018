package com.rroggia.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Day1 {
	public static void main(String[] args) {
		int resultingFrequency = 0;

		try (Reader fileReader = new FileReader("./src/com/rroggia/day1/input");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String frequencyRead = bufferedReader.readLine();

			while (frequencyRead != null) {
				int frequency = Integer.parseInt(frequencyRead);
				resultingFrequency += frequency;
				frequencyRead = bufferedReader.readLine();
			}

			System.out.println(resultingFrequency);

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			System.out.println("Error in IO");
			e.printStackTrace();
		}
	}
}
