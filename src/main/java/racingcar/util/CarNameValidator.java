package racingcar.util;

import java.util.List;

public class CarNameValidator {
    private static final String SPACE = " ";

    public static void validateSpaceCheck(final String carName) {
        if (carName.contains(SPACE)) {
            throw new IllegalArgumentException("이름에 공백이 존재할 수 없습니다.");
        }
    }

    public static void validateLengthCheck(final String carName, int legth) {
        if (carName.length() > legth) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 초과할 수 없습니다.", legth));
        }
    }

    public static void validateUniqueNameCheck(final List<String> carNames) {
        final int namesSize = carNames.size();
        if (namesSize == 0) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다.");
        }
        if (namesSize != countDistinctNames(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private static int countDistinctNames(final List<String> carNames) {
        return (int) carNames.stream()
                .distinct()
                .count();
    }
}
