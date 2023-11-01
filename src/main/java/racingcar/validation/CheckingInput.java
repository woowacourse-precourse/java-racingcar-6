package racingcar.validation;

import java.util.HashSet;

public class CheckingInput {

    static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하가 되어야 합니다.");
        }
    }

    static void validateCarNamesLength(int carNamesLength) {
        if (carNamesLength < 2) {
            throw new IllegalArgumentException("참여 자동차가 2개 이상이어야 합니다.");
        }
    }

    static void validateNamesDuplicate(String[] carNames) {
        HashSet<String> carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            if (!carNamesSet.add(carName)) {
                throw new IllegalArgumentException("같은 이름이 두개 이상 있습니다.");
            }
        }
    }

    static void validateLetter(char letter) {
        if (letter < '0' || letter > '9') {
            throw new IllegalArgumentException("입력된 값은 숫자여야 합니다");
        }
    }

    static void validateCountValue(int countNum) {
        if (countNum <= 0) {
            throw new IllegalArgumentException("입력된 값은 0보다 커야 합니다.");
        }
    }

    public static void validateInputNames(String[] carNames) {
        int carNamesLength = carNames.length;

        for (String carName : carNames) {
            validateCarName(carName);
        }

        validateCarNamesLength(carNames.length);
        validateNamesDuplicate(carNames);

    }

    public static void validateInputCount(String count) {
        for (int i = 0; i < count.length(); i++) {
            char letter = count.charAt(i);
            validateLetter(letter);
        }

        int countNum = Integer.parseInt(count);
        validateCountValue(countNum);

    }
}
