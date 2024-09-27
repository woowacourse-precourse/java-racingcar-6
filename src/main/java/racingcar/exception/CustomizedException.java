package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomizedException {
    public static void numberUpException(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static void sameNameCarException(List<String> carList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carList) {
            if (uniqueNames.contains(carName)) {
                throw new IllegalArgumentException("같은 이름의 자동차가 존재합니다: " + carName);
            }
            uniqueNames.add(carName);
        }
    }

    public static void emptyCarNameException(List<String> carList) {
        for (String carName : carList) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("빈칸을 입력할 수 없습니다.");
            }
        }
    }

    public static void zeroOrMinusException(Integer countOfGame) {
        if (countOfGame <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
