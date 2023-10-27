package racingcar.model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5 || !name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하의 알파벳 문자여야 합니다.");
            }
        }
        validateDuplicateCarNames(carNames);
    }
    public static void validateAttempts(int numAttempts) {
        if (numAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
    private static void validateDuplicateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}