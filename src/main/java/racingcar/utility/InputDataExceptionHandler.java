package racingcar.utility;

import java.util.List;

public class InputDataExceptionHandler {
    private static final int MAX_CAR_NAME_SIZE = 5;
    private static final String IS_ZERO = "0";
    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';
    private static final String NAME_SIZE_ERROR = "이름의 크기가 5를 초과했습니다";
    private static final String ZERO_GAME_ERROR = "경주는 최소 1번 이상 진행되어야합니다.";
    private static final String NO_NUMBER_ERROR = "이름의 크기가 5를 초과했습니다";

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException(NAME_SIZE_ERROR);
            }
        }
    }

    public static void validateTotalRounds(String totalRounds) {
        if (totalRounds.equals(IS_ZERO)) {
            throw new IllegalArgumentException(ZERO_GAME_ERROR);
        }
        for (char isNum : totalRounds.toCharArray()) {
            if (isNum < MIN_NUMBER || isNum > MAX_NUMBER) {
                throw new IllegalArgumentException(NO_NUMBER_ERROR);
            }
        }
    }
}
