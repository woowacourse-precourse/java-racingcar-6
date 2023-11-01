package racingcar.domain;

import java.util.List;

public class Validator {

    private final static int NAME_LENGTH = 5;
    private final static String NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    private final static String TRY_COUNT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하세요.";

    public static void validateCarsName(List<String> names) {
        for (String name: names) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
            }
        }
    }

    public static void validateTryCount(String tryCountString) {
        try {
            Integer.parseInt(tryCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }
}
