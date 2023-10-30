package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_MOVING_NUMBER = 1;
    private static final int MAX_MOVING_NUMBER = 2000000000;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_CAR_COUNTING = 2;
    public static final String NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_MESSAGE =
            "자동차 이름을 영문자,한글로만 구성하고 쉼표로만 구분해주세요.";
    public static final String END_OF_INPUT_IS_NOT_COMMA_MESSAGE = "입력값의 마지막으로는 쉼표가 올 수 없습니다.";

    public void validateInput(String input) {
        checkInputConsistOfEnglishKoreanComma(input);
        checkEndOfInputNotComma(input);
    }

    public void validateCarNames(List<String> carNames) {
        checkCarNameLength(carNames);
        checkCarNameCounting(carNames);
        checkCarNameDuplicated(carNames);
    }

    public void validateMovingNumber(String userInputMovingNumber) {
        try {
            int movingNumber = Integer.parseInt(userInputMovingNumber);
            if (movingNumber < MIN_MOVING_NUMBER) {
                throw new IllegalArgumentException("1이상의 정수를 입력해야 경주가 시작됩니다.");
            }
            if (movingNumber > MAX_MOVING_NUMBER) {
                throw new IllegalArgumentException("이동 횟수는 최대 20억입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상의 정수를 입력하세요.");
        }
    }

    private void checkInputConsistOfEnglishKoreanComma(String input) {
        if (!input.matches("^[가-힣a-zA-Z,]+$")) {
            throw new IllegalArgumentException(NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_MESSAGE);
        }
    }

    private void checkEndOfInputNotComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(END_OF_INPUT_IS_NOT_COMMA_MESSAGE);
        }
    }

    private void checkCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1~5자로 입력해주세요.");
            }
        }
    }

    private void checkCarNameCounting(List<String> carNames) {
        if (carNames.size() < MAX_CAR_COUNTING) {
            throw new IllegalArgumentException("경주를 하기 위해서 자동차 이름을 최소 2개는 입력해주세요.");
        }
    }

    private void checkCarNameDuplicated(List<String> carNames) {
        Set<String> duplicacySet = new HashSet<>(carNames);

        if (carNames.size() != duplicacySet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되면 우승자를 확인하는데 어려움이 있으니 중복 없이 입력하세요.");
        }
    }
}