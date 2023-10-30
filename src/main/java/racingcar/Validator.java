package racingcar;

import java.util.stream.Stream;

public class Validator {

    public static void checkValidCarNames(String[] carNames) {
        isValidCarName(carNames);
        hasUniqueCarName(carNames);
    }

    private static boolean isValidCarName(String[] carNames) {
        Stream<String> carNameStream = Stream.of(carNames);
        carNameStream.forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.length() == 0) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상만 가능합니다.");
            }
        });
        return true;
    }

    private static boolean hasUniqueCarName(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        long rawCount = carNames.length;
        long distinctCount = carNamesStream.distinct().count();
        if (rawCount != distinctCount) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        return true;
    }
}
