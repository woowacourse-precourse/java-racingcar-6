package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String CAR_NAME_PATTERN = "[가-힣a-zA-Z0-9]+";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            validateCarNamePattern(name);
            validateCarNameLength(name);
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
    }

    public static void validateCarNamePattern(String name) {
        if (!name.matches(CAR_NAME_PATTERN)) {
            throw new IllegalArgumentException("자동차 이름은 한글, 영문, 숫자만 포함해야 합니다.");
        }
    }

    public static void validateCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public static void verifyRounds(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }

        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자만 입력 가능합니다.");
        }
    }
}
