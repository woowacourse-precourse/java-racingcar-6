package racingcar.util;

import static racingcar.util.CarListMaker.ErrorMessage.*;

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
            throw new IllegalArgumentException(NOT_EXIST_EXCEPTION.getMessage());
        }
        if (hasInvalidLength(names)) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION.getMessage());
        }
        if (isInvalidFormat(names)) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION.getMessage());
        }
    }

    private static boolean hasInvalidLength(String names) {
        return Arrays.stream(names.split(COMMA))
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private static boolean isInvalidFormat(String names) {
        // 입력의 형태가 조근의 형식대로 이루어졌는지 확인
        return !names.matches("([\\w가-힣]{1,5},?)+");
    }

    enum ErrorMessage {
        NOT_EXIST_EXCEPTION("입력값이 존재하지 않습니다."),
        INVALID_LENGTH_EXCEPTION("이름은 1글자부터 5글자까지 가능합니다."),
        INVALID_FORMAT_EXCEPTION("입력 형식이 올바르지 않습니다.");

        private final String message;
        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
