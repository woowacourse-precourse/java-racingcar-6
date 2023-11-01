package racingcar.utils;

import java.util.List;

public class Validator {
    private final static String CARS_SIZE_ERROR_MESSAGE = "자동차는 콤마로 구분하여 최소 두대 이상 최대 다섯대 이하로 입력해야 합니다.";
    private final static String CAR_NAME_ONLY_ENGLISH_ERROR_MESSAGE = "이름은 영문만 가능합니다.";
    private final static String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 한글자 이상, 다섯글자 이하로 입력해 주세요.";
    private final static String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "자동차의 이름은 중복되어서는 안 됩니다.";
    private final static String TRY_COUNT_INT_ERROR_MESSAGE = "진행 횟수는 정수만 입력 가능합니다.";
    private final static String TRY_COUNT_ERROR_MESSAGE = "시도하실 횟수를 정확하게 입력해 주세요.";
    private final static String TRY_COUNT_LENGTH_ERROR_MESSAGE = "진행 횟수는 1회에서 10회 사이로만 가능합니다.";
    private final static String CAR_NAME_ERROR_MESSAGE = "형식에 맞게 자동차 이름을 입력해 주세요.";
    private final static String COMMA = ",";
    private final static int MIN_CAR = 2;
    private final static int MAX_CAR = 5;
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 5;
    private final static int MIN_COUNT = 1;
    private final static int MAX_COUNT = 10;

    private void validateInputCarOneToFive(List<String> input) {
        if (input.size() < MIN_CAR || input.size() > MAX_CAR) {
            throw new IllegalArgumentException(CARS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateInputCarNameIsEnglish(String input) {
        if (input == null || !input.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException(CAR_NAME_ONLY_ENGLISH_ERROR_MESSAGE);
        }
    }

    private void validateInputCarNameLengthOneToFive(String input) {
        if (input.length() < MIN_LENGTH || input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateCarName(List<String> input) {
        for (String carName : input) {
            validateInputCarNameIsEnglish(carName);
            validateInputCarNameLengthOneToFive(carName);
        }
    }

    private void validateCarNameDuplicates(List<String> input) {
        List<String> distinctInput = input.stream()
                .distinct()
                .toList();
        if (distinctInput.size() < input.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(TRY_COUNT_INT_ERROR_MESSAGE);
            }
        }
    }

    private void validateMovingTryCountNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateOutOfMovingTryCountBoundary(String input) {
        int intInput = Integer.parseInt(input);
        if (intInput < MIN_COUNT || intInput > MAX_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_LENGTH_ERROR_MESSAGE);
        }
    }

    public void validateInputCar(List<String> input) {
        validateInputCarOneToFive(input);
        validateCarName(input);
        validateCarNameDuplicates(input);
    }

    public void validateInputMovingTryCount(String input) {
        validateMovingTryCountNull(input);
        validateNumeric(input);
        validateOutOfMovingTryCountBoundary(input);
    }

    public void validateInputCarNameStartOrEndComma(String input) {
        if (input.startsWith(COMMA) || input.endsWith(COMMA)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}