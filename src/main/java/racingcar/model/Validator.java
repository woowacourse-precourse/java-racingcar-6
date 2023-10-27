package racingcar.model;

import java.util.List;

public class Validator {

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5 || !name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하의 알파벳 문자여야 합니다.");
            }
        }
    }
    public static void validateAttempts(int numAttempts) {
        if (numAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}