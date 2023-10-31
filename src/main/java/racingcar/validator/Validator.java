package racingcar.validator;

import racingcar.constant.GameConstants;

public class Validator {
    public static void isLessThanFiveLetter(String carName) {
        if (carName.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이름 길이 5초과");
    }

    public static void isEmptyString(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지  않습니다.");
        }
    }


    public static void checkCarNamesForm(String carNames) {
        String regularExpForInput = "[^,]+,(?:[^,]+,)*[^,]+";
        if (!carNames.matches(regularExpForInput)) {
            throw new IllegalArgumentException("[ERROR] 자동자이름들 형식이 잘못 됐습니다.");
        }
    }


    public static void isNumber(String input) {
        String regularExpForInput = "\\d+";
        if (!input.matches(regularExpForInput)) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }

    public static void isMoreThanOne(String attemptNumberString) {
        int attemptNumber = Integer.parseInt(attemptNumberString);
        if (attemptNumber >= 1) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 입력시도는 한번 이상이어야 합니다.");
    }

    public static void randomNumberRange(int num) {
        if (GameConstants.MIN_NUM <= num && num <= GameConstants.MAX_NUM) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 랜던 값이 범위에 맞지 않습니다");
    }

}
