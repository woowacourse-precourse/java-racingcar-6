package racingcar;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void checkCount(List<String> carNames) {

        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해 주세요.");
        }

    }

    public static void checkBlank(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.isBlank()) {
                throw new IllegalArgumentException("이름을 공백으로 입력하지 마세요.");
            }

        }

    }

    public static void checkLength(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해 주세요.");
            }

        }

    }

    public static void checkDuplication(List<String> carNames) {

        CarManager.trimNames(carNames);

        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해 주세요.");
        }

    }

    public static void checkNumber(String userInput) {

        try {

            if (Integer.parseInt(userInput) < 1) {
                throw new IllegalArgumentException("1이상의 숫자를 입력하세요.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }

    }
}
