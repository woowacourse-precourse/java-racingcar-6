package racingcar.domain;

import java.util.List;

public class Validator {

    private final static int NAME_LENGTH = 5;
    private final static String NAME_ERROR_MESSAGE = "[ERROR] 이름을 제대로 입력해주세요.";
    private final static String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    private final static String ALREADY_EXISTS_NAME_ERROR_MESSAGE = "[ERROR] 같은 이름이 존재합니다.";
    private final static String TRY_COUNT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하세요.";
    private final static String TRY_COUNT_NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수가 0보다 작습니다.";

    public static void validateCarsName(List<String> names) {
        // 이름을 입력하지 않은 경우
        if (names.size() == 0) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            // 이름이 5자를 넘는 경우
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }

            // 같은 이름이 이미 존재하는 경우
            if (names.indexOf(name) != i) {
                throw new IllegalArgumentException(ALREADY_EXISTS_NAME_ERROR_MESSAGE);
            }
        }
    }

    public static void validateTryCount(String tryCountString) {
        // 숫자가 아닌 경우
        try {
            Integer.parseInt(tryCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }

        // 음수인 경우
        int tryCount = Integer.parseInt(tryCountString);
        if (tryCount < 0) {
            throw new IllegalArgumentException(TRY_COUNT_NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
