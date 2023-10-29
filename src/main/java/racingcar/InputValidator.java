package racingcar;

public class InputValidator {
    public static void validateCarNames(String carNames) {
        if (Util.isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException("검증할 자동차 이름 목록이 없습니다.");
        }
    }

    public static void validateCarName(String carName) {
        if (Util.isNullOrEmpty(carName)) {
            throw new IllegalArgumentException("검증할 자동차 이름이 없습니다.");
        }

        String carNamePattern = "^[a-zA-Z가-힣]{1,5}$";
        if (!carName.matches(carNamePattern)) {
            throw new IllegalArgumentException("자동차 이름은 1~5자의 한글, 영어 대소문자로 구성됩니다.");
        }
    }
}
