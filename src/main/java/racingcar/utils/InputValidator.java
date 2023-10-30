package racingcar.utils;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public static void validateRaceCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 회수를 입력해주세요.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
