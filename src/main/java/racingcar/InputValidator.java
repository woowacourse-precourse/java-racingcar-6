package racingcar;

public class InputValidator {
    public static void validateCarNames(String carNames) {
        if (carNames == null
                || carNames.isBlank()
                || carNames.isEmpty()) {
            throw new IllegalArgumentException("검증할 자동차 이름 목록이 없습니다.");
        }
    }
}
