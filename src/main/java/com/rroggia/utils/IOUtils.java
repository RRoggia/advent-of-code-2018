package com.rroggia.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

	public static List<Integer> readIntegersFromInputFile(String inputFile) {
		List<Integer> integers = new ArrayList<>();

		try (Reader fileReader = new FileReader(inputFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String value = bufferedReader.readLine();

			while (value != null) {
				integers.add(Integer.parseInt(value));
				value = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			System.out.println("Error in IO");
			e.printStackTrace();
		}
		return integers;
	}

	public static List<String> readStringsFromInputFile(String inputFile) {
		List<String> strings = new ArrayList<>();

		try (Reader fileReader = new FileReader(inputFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String value = bufferedReader.readLine();

			while (value != null) {
				strings.add(value);
				value = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			System.out.println("Error in IO");
			e.printStackTrace();
		}
		return strings;
	}

}
