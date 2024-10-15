package com.tanya.movie_rating.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	public static LocalDate convertStringToLocalDate(String value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value, formatter);
        return localDate;
	}
	
	public static String covnertLocalDateToString(LocalDate value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String formattedDate = value.format(formatter);
        return formattedDate;
	}
}
