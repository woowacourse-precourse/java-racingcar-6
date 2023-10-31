package racingcar.util;

import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int COUNT_MIN_VALUE = 1;
    private static final String CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE = "자동차 이름의 길이가 5를 초과했습니다.";
    private static final String EXIST_SPACE_IN_CAR_NAME_ERROR_MESSAGE = "자동차 이름에 공백이 존재합니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 중복됐습니다.";
    private static final String COUNT_NOT_GREATER_THAN_ONE_ERROR_MESSAGE = "시도 횟수는 1이상이어야 합니다.";
    private static final String SPACE = " ";

    public static void verifyCarNames(List<String> carNameList) {
        for (String name : carNameList) {
            verifyCarNameLength(name);
            verifyExistSpaceInCarName(name);
        }
        verifyDuplicateCarName(carNameList);
    }

    public static void verifyTrialCount(String input) {
        int count = InputParser.parseTrialCountToInt(input);
        verifyGreaterThanOne(count);
    }

    private static void verifyCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE);
        }
    }

    private static void verifyExistSpaceInCarName(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(EXIST_SPACE_IN_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private static void verifyDuplicateCarName(List<String> carNameList) {
        int distinctCount = (int) carNameList.stream()
                .distinct()
                .count();
        if (distinctCount < carNameList.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private static void verifyGreaterThanOne(int count) {
        if (count < COUNT_MIN_VALUE) {
            throw new IllegalArgumentException(COUNT_NOT_GREATER_THAN_ONE_ERROR_MESSAGE);
        }
    }
}
