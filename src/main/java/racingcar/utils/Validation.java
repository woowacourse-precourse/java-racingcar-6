package racingcar.utils;

import racingcar.domain.Car;

import java.util.*;

import static racingcar.message.ErrorMessage.*;

public class Validation {
    private static final int MAX_LENGTH = 5;

    // 콤마 여부
    public static void validateNoComma(String inputNames) {
        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException(ERROR_COMMA);
        }
    }
    //자동차 글자 수 1 이상 5 이하
    public static void validateNameLength(String[] inputNames) {
        for (String i : inputNames) {
            if(i.length() > MAX_LENGTH || i.isEmpty()) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }
    // 자연수 여부
    public static void validateNaturalNumber(final String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber <= 0){
                throw new IllegalArgumentException(ERROR_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER);
        }
    }
    public static void validateSameName(String[] input){
        Set<String> set = new HashSet<>(Arrays.asList(input));
        String[] newArray = set.toArray(new String[0]);
        if(input.length != newArray.length){
            throw new IllegalArgumentException(ERROR_SAME_NAME);
        }
    }
}
