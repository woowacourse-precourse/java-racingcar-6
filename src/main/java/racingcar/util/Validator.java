package racingcar.util;

import java.util.stream.Stream;

public class Validator {

    public static void checkValidCarNames(String[] carNames) {
        validateLengthOfCarName(carNames);
        validateNoWhitespaceOfCarName(carNames);
        validateUniqueOfCarName(carNames);
    }

    private static void validateLengthOfCarName(String[] carNames) {
        Stream<String> carNameStream = Stream.of(carNames);
        carNameStream.forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.length() == 0) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상만 가능합니다.");
            }
        });
    }

    private static void validateUniqueOfCarName(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        long rawCount = carNames.length;
        long distinctCount = carNamesStream.distinct().count();
        if (rawCount != distinctCount) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static void validateNoWhitespaceOfCarName(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        carNamesStream.forEach(carName -> {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }
        });
    }

    public static void isValidNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
