package racingcar.utils;

import java.util.regex.Pattern;

public class CarNameValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String MULTIPLE_CAR_NAME_DELIMITER = ",";
    private static final String ALPHABET_CAR_NAME_REGEX = "^[A-Za-z]+$";
    private static final String MULTIPLE_CAR_NAME_ERROR_MESSAGE = "자동차는 두 대 이상 입력해야 합니다.";
    private static final String BLANK_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 공백일 수 없습니다.";
    private static final String ALPHABET_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 영문자만 입력할 수 있습니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하로 작성해야 합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "같은 자동차 이름이 중복으로 들어올 수 없습니다.";

    private CarNameValidator() {
    }

    public static void validateMultipleCarName(String names) {
        if (!names.contains(MULTIPLE_CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(MULTIPLE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateCarName(String carName) {
        isBlank(carName);
        isAlphabet(carName);
        isLessThanOrEqualMaxLength(carName);
    }

    private static void isBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private static void isAlphabet(String carName) {
        if (!Pattern.matches(ALPHABET_CAR_NAME_REGEX, carName)) {
            throw new IllegalArgumentException(ALPHABET_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private static void isLessThanOrEqualMaxLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateCarName(List<String> carNames){
        int carCount = carNames.size();
        HashSet<String> distinctCarNames = new HashSet<>(carNames);

        if(carCount != distinctCarNames.size()){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
