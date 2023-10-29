package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public final class CarListMaker {
    private static final String COMMA = ",";
    private static final int MAX_NAME_LENGTH = 5;
    public static List<Car> makeCarList(String names) {
        validateNames(names);
        return Arrays.stream(names.split(COMMA))
                .map(Car::new)
                .toList();
    }

    private static void validateNames(String names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        if (hasInvalidLength(names)) {
            throw new IllegalArgumentException("이름은 1글자부터 5글자까지 가능합니다.");
        }
        if (isInvalidFormat(names)) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }

    private static boolean hasInvalidLength(String names) {
        return Arrays.stream(names.split(COMMA))
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private static boolean isInvalidFormat(String names) {
        return !names.matches("([\\w가-힣]{1,5},?)+");
    }
}
