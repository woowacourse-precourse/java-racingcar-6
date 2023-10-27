package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInputException {
    public void validateUniqueCarName(String[] carNames) {
        // 자동차 이름 중복 검사
        if (duplicateCarName(carNames) > 0) {
            throw new IllegalArgumentException("자동차들의 이름 중 중복된 이름이 존재합니다. 게임이 종료됩니다.");
        }
    }

    private long duplicateCarName(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        // 중복되는 자동차 이름의 개수를 센다.
        return Arrays.stream(carNames)
                .filter(carName -> !uniqueCarNames.add(carName))
                .count();
    }

    public void validateBlankCarName(String[] carNames) {
        // 자동차 이름 공백 검사
        if (containsBlankName(carNames)) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다. 게임이 종료됩니다.");
        }
    }

    private boolean containsBlankName(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(carName -> carName.contains(" "));
    }
}
