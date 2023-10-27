package exception;

import java.util.Arrays;

public class Validator {
    private Validator() {
    }

    public static void validateCarNameLength(String[] carNameList) {
        final int CAR_NAME_LIST_LENGTH = carNameList.length;
        final int MIN_CAR_COUNT = 2;

        final int MIN_CAR_NAME_LENGTH = 1;
        final int MAX_CAR_NAME_LENGTH = 5;

        if (Arrays.stream(carNameList).mapToInt(String::length).filter(i -> i > MAX_CAR_NAME_LENGTH || i < MIN_CAR_NAME_LENGTH).count() != 0) {
            throw new IllegalArgumentException("자동차 이름은 " + MIN_CAR_NAME_LENGTH + "자 이상 " + MAX_CAR_NAME_LENGTH + "자 이하로 입력해야 합니다.");
        }

        if (Arrays.stream(carNameList).anyMatch(i -> i.isEmpty() || i.isBlank())) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        if (Arrays.stream(carNameList).distinct().count() != CAR_NAME_LIST_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }

        if (CAR_NAME_LIST_LENGTH < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 이름을 최소 2개 이상 입력해야 합니다.");
        }
    }
}
