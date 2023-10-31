package racingcar.validate;

import java.util.LinkedHashMap;

public class RacingListValidator {
    public static final int NAME_LENGTH_LIMIT = 5;
    public static final String SIZE_LIMIT_MESSAGE = "이름의 길이가 5 이상입니다.";
    public static final String DUPLICATE_MESSAGE = "자동차 이름이 중복됩니다.";

    public static void sizeValidate(String input) {
        int size = input.length();
        if (size > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(SIZE_LIMIT_MESSAGE);
        }
    }

    public static void duplicateValidate(LinkedHashMap<String, Integer> carList, String input) {
        if (carList.containsKey(input)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }
}
