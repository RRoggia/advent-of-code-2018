package com.rroggia.day4;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.rroggia.utils.IOUtils;

public class Day4 {

	public static void main(String[] args) throws ParseException {
		List<String> guardsDuties = IOUtils.readStringsFromInputFile("/day4/input");
		Collections.sort(guardsDuties);
		Map<String, Map<Integer, Integer>> guardsSleepingMinutes = new HashMap<>();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");

		String guardId = null;
		LocalDateTime date = null;
		LocalDateTime previousDate = null;
		for (String guardDuty : guardsDuties) {
			previousDate = date;
			date = LocalDateTime.parse(guardDuty.subSequence(1, 17), dateTimeFormatter);

			if (guardDuty.contains("Guard")) {
				guardId = guardDuty.substring(guardDuty.indexOf("#") + 1, guardDuty.indexOf(" b"));
			} else if (guardDuty.contains("wake")) {
				Map<Integer, Integer> timeSleepingEachMinute;
				if (guardsSleepingMinutes.containsKey(guardId)) {
					timeSleepingEachMinute = guardsSleepingMinutes.get(guardId);
				} else {
					timeSleepingEachMinute = new HashMap<Integer, Integer>();
				}

				for (int minute = date.getMinute() - 1; minute >= previousDate.getMinute(); minute--) {
					if (timeSleepingEachMinute.containsKey(minute)) {
						timeSleepingEachMinute.put(minute, timeSleepingEachMinute.get(minute) + 1);
					} else {
						timeSleepingEachMinute.put(minute, 1);
					}
				}
				guardsSleepingMinutes.put(guardId, timeSleepingEachMinute);
			}

		}

		String sleepiestGuardId = null;
		Integer minuteMostSlept = 0;
		Integer higherTimeSleepingInMinute = 0;

		for (Entry<String, Map<Integer, Integer>> guardSleptMinutes : guardsSleepingMinutes.entrySet()) {
			Map<Integer, Integer> minutesSlept = guardSleptMinutes.getValue();
			Integer guardTotalTimeSlept = 0;
			Integer guardMinuteMostSlept = 0;
			Integer guardHigherTimeSleepingInMinute = -1;
			for (Entry<Integer, Integer> minuteSlept : minutesSlept.entrySet()) {
				guardTotalTimeSlept += minuteSlept.getValue();
				if (minuteSlept.getValue() > guardHigherTimeSleepingInMinute) {
					guardHigherTimeSleepingInMinute = minuteSlept.getValue();
					guardMinuteMostSlept = minuteSlept.getKey();
				}
			}

			if (guardHigherTimeSleepingInMinute > higherTimeSleepingInMinute) {
				higherTimeSleepingInMinute = guardHigherTimeSleepingInMinute;
				sleepiestGuardId = guardSleptMinutes.getKey();
				minuteMostSlept = guardMinuteMostSlept;
			}

		}
		System.out.println(Integer.parseInt(sleepiestGuardId) * minuteMostSlept);
	}
}
