package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static int CAR_NAME_LENGTH_LIMIT = 5;
    public static String DELIMITER = ",";
    public static String CAR_NAME_LENGTH_ERROR_MESSAGE = CAR_NAME_LENGTH_LIMIT + "자를 이하의 이름만 가능합니다.";
    public static String NUMBER_OF_ATTEMPTS_ERROR_MESSAGE = "시도 횟수는 0 이상으로 입력해주세요.";

    public static List<String> validateCarNames(String userInput) {
        String[] carNames = userInput.split(DELIMITER);
        validateNameLength(carNames);
        return Arrays.stream(carNames)
                .collect(Collectors.toList());
    }

    private static void validateNameLength(String[] carNames) {
        Arrays.stream(carNames)
                .filter(carName -> carName.length() > CAR_NAME_LENGTH_LIMIT)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
                });
    }

    public static int validateNumberOfAttempts(String userInput) {
        try {
            int numberOfAttempts = Integer.parseInt(userInput);
            validateNonNegative(numberOfAttempts);
            return numberOfAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_ERROR_MESSAGE);
        }
    }

    private static void validateNonNegative(int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_ERROR_MESSAGE);
        }
    }
}
