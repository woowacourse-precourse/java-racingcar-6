package util;

import racingcar.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<String> stringToStringList(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter)).toList();
    }
}
