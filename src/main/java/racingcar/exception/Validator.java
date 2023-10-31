package racingcar.exception;

import java.util.List;

public class Validator {

    public static void validateCarName(String carName) {

        boolean isValidCarName = (carName.length() <= 5) && (carName.length() > 0);
        if (!isValidCarName) {
            throw new IllegalArgumentException("자동차 이름은 앞,뒤 공백 없는 1~5자 사이입니다.");
        }
    }

    public static void validateNumberOfCar(List<String> carNames) {

        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차가 레이스에 참여해야 합니다.");
        }
    }

    public static void validateTryCountIsInteger(String tryCount) {

        try {
            validateTryCountIsZero(Integer.parseInt(tryCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateTryCountIsZero(Integer tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }
}
