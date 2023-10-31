package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_MOVING_NUMBER = 1;
    private static final int MAX_MOVING_NUMBER = 2000000000;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_COUNTING = 2;

    public static final String NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_ERROR =
            "자동차 이름을 영문자,한글로만 구성하고 쉼표로만 구분해주세요.";
    public static final String ENDWITHS_IS_NOT_COMMA_ERROR = "입력값의 마지막으로는 쉼표가 올 수 없습니다.";
    public static final String MIN_MOVING_NUMBER_ERROR = MIN_MOVING_NUMBER + "이상의 정수를 입력해야 경주가 시작됩니다.";
    public static final String MAX_MOVING_NUMBER_ERROR = "이동 횟수는 최대 " + MAX_MOVING_NUMBER + "입니다.";
    public static final String NOT_NUMBER_ERROR = "숫자외의 다른 값은 입력할 수 없습니다.(공백, 쉼표등이 있는지 확인해주세요)";
    public static final String CAR_NAME_LENGTH_ERROR =
            "자동차 이름은 " + MIN_CAR_NAME_LENGTH + "~" + MAX_CAR_NAME_LENGTH + "자로 입력해주세요.";
    public static final String CAR_NAME_COUNT_ERROR =
            "경주를 하기 위해서 자동차 이름을 최소 " + MIN_CAR_COUNTING + "개는 입력해주세요.";
    public static final String CAR_NAME_DUPLICATE_ERROR =
            "자동차 이름이 중복되면 우승자를 확인하는데 어려움이 있으니 중복 없이 입력하세요.";

    public void validateInput(String input) {
        consistOfEnglishKoreanComma(input);
        endWithsNotComma(input);
    }

    public void validateCarNames(List<String> carNames) {
        checkCarNameLength(carNames);
        checkCarNameCounting(carNames);
        checkCarNameDuplicated(carNames);
    }

    public void validateMovingNumber(String userInputMovingNumber) {
        int movingNumber = 0;
        try {
            movingNumber = Integer.parseInt(userInputMovingNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
        checkMinMovingNumber(movingNumber);
        checkMaxMovingNumber(movingNumber);
    }

    private void consistOfEnglishKoreanComma(String input) {
        if (!input.matches("^[가-힣a-zA-Z,]+$")) {
            throw new IllegalArgumentException(NOT_CONSIST_OF_ENGLISH_KOREAN_COMMA_ERROR);
        }
    }

    private void endWithsNotComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ENDWITHS_IS_NOT_COMMA_ERROR);
        }
    }

    private void checkCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
    }

    private void checkCarNameCounting(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNTING) {
            throw new IllegalArgumentException(CAR_NAME_COUNT_ERROR);
        }
    }

    private void checkCarNameDuplicated(List<String> carNames) {
        Set<String> duplicacySet = new HashSet<>(carNames);

        if (carNames.size() != duplicacySet.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

    private void checkMinMovingNumber(int movingNumber) {
        if (movingNumber < MIN_MOVING_NUMBER) {
            throw new IllegalArgumentException(MIN_MOVING_NUMBER_ERROR);
        }
    }

    private void checkMaxMovingNumber(int movingNumber) {
        if (movingNumber > MAX_MOVING_NUMBER) {
            throw new IllegalArgumentException(MAX_MOVING_NUMBER_ERROR);
        }
    }
}