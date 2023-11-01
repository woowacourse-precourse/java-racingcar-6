package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public void validateInputNotStartWithComma(String input) {
        if (input.startsWith(","))
            throw new IllegalArgumentException("입력값은 쉼표로 시작할 수 없습니다.");
    }

    public void validateInputNotEndWithComma(String input) {
        if (input.endsWith(","))
            throw new IllegalArgumentException("입력값은 쉼표로 끝날 수 없습니다.");
    }

    public void validateInputContainsConsecutiveCommas(String input) {
        if (input.contains(",,"))
            throw new IllegalArgumentException("쉼표는 연속으로 들어갈 수 없습니다.");
    }

    public void validateNumberOfCarName(String[] splitCarName) {
        for (String carName : splitCarName) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateDuplicateCarName(String[] splitCarName) {
        Set<String> carNameSet = new HashSet<>();

        for (String carName : splitCarName) {
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
