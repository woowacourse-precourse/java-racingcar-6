package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {

    private static final int CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 null 또는 비어 있을 수 없습니다.";
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String NON_INTEGER_MESSAGE = "시도 횟수는 정수여야 합니다.";
    private static final String NON_POSITIVE_MESSAGE = "시도 횟수는 0보다 커야 합니다.";


    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameNotNullOrBlank(carName);
            validateCarNameLength(carName);
        }
        validateDuplicateCarName(carNames);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateCarNameNotNullOrBlank(String carName){
        if(StringUtils.isBlank(carName)){
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private static void validateDuplicateCarName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if(set.size() != carNames.size()){
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }
    }


    public static int validateAttemptCount(String attemptCount) {
        try {
            int parsedCount = Integer.parseInt(attemptCount);
            validatePositiveCount(parsedCount);
            return parsedCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MESSAGE, e);
        }
    }


    private static void validatePositiveCount(int parsedCount) {
        if (parsedCount <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_MESSAGE);
        }
    }

}
