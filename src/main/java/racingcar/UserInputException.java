package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInputException {
    public void validateUniqueCarName(String[] carNames) {
        // 자동차 이름 중복 검사
        if (duplicateCarName(carNames)) {
            throw new IllegalArgumentException("자동차들의 이름 중 중복된 이름이 존재합니다. 게임이 종료됩니다.");
        }
    }

    private boolean duplicateCarName(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        // 중복된 값이 Set에 추가되지 않으면 true를 반환
        return Arrays.stream(carNames)
                .anyMatch(carName -> !uniqueCarNames.add(carName));
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

    public void validateCarNameLength(String[] carNames) {
        // 자동차 이름 길이 검사
        if (overMaxLength(carNames)) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다. 게임이 종료됩니다.");
        }
    }

    private boolean overMaxLength(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(carName -> carName.length() > 5);
    }
}
