package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final int MIN_CAR_NAMES_SIZE = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_MOVE_COUNT = 1;

    public static void validateCarNamesSize(List<String> carNames) {
        if (carNames.size() < MIN_CAR_NAMES_SIZE) {
            throw new IllegalArgumentException("경주에 참여할 자동차의 이름 수가 모자릅니다. 적어도 2개 이상의 이름을 입력해주세요.");
        }
    }

    public static void validateCarNameLength(List<String> carNames) {
        boolean isOverMaxCarNameLength = carNames.stream()
                .map(carName -> carName.length())
                .filter(nameLength -> nameLength > MAX_CAR_NAME_LENGTH)
                .count() > 0;

        if (isOverMaxCarNameLength) {
            throw new IllegalArgumentException("자동차의 이름이 5글자를 초과 했습니다. 5글자 이하의 이름으로 입력해주세요.");
        }
    }

    public static void validateBlankName(List<String> carNames) {
        boolean hasBlank = carNames.stream()
                .map(carName -> carName.trim())
                .filter(carName -> carName.equals(""))
                .count() > 0;

        if (hasBlank) {
            throw new IllegalArgumentException("자동차의 이름 중 공백으로만 이루어진 이름이 포함되어있습니다. 공백 이름은 입력하실 수 없습니다.");
        }
    }

    public static void validateMoveCountRange(int moveCount) {
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException("최소 시도 횟수보다 낮은 값을 입력하셨습니다. 최소 1회 이상의 시도 횟수를 입력해주세요.");
        }
    }
}
