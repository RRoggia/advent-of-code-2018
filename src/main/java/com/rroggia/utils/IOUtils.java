package com.rroggia.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IOUtils {

	private final static String PACKAGE_PREFIX = "./src/main/java/com/rroggia";

	public static List<Integer> readIntegersFromInputFile(String inputFile) {
		return readFromInputFile(inputFile, a -> Integer.parseInt(a));
	}

	public static List<String> readStringsFromInputFile(String inputFile) {
		return readFromInputFile(inputFile, Function.identity());
	}

	private static <T> List<T> readFromInputFile(String inputFile, Function<String, T> convertion) {
		List<T> inputs = new ArrayList<>();

		try (Reader fileReader = new FileReader(PACKAGE_PREFIX + inputFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String value = bufferedReader.readLine();

			while (value != null) {
				T input = convertion.apply(value);
				inputs.add(input);
				value = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		} catch (IOException e) {
			System.out.println("Error in IO");
			e.printStackTrace();
		}
		return inputs;
	}

}
